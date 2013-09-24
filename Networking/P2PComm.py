#! usr/bin/env python
'''
This simple TCP Client will check the target IP for a sibling
client and attempt to open a communication channel between them.
The clients will alternate sending messages until one sends the
KILL_CODE message, which will close both clients.

run as python $PATH/P2PComm.py (Partner IP)

You can also run with 127.0.0.1 and chat with yourself.
'''

import socket
import struct
import sys

TCP_IP = ''
TCP_PORT = 12321
BUF_SIZE = 256
MAX_ATTEMPTS = 15
KILL_CODE = "Bye"

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))

conn = None
myTurn = False
exitCount = 0
while not conn and not myTurn:
	if exitCount is MAX_ATTEMPTS:
		exit(1)
	try:
		print "Trying to connect to", sys.argv[1]
		s.settimeout(1)
		s.connect((sys.argv[1], TCP_PORT))
		myTurn = True
		print "Connection accepted!"
	except:
		try:
			print "Nope. Listening..."
			s.listen(1)
			s.settimeout(3)
			conn, addr = s.accept()
			print "Connection received!"
		except:
			print "Nothing out there."
	exitCount += 1

s.settimeout(None)
if myTurn:
	while True:
		if myTurn:
			msg = raw_input(">>")
			pkt = struct.pack(str(len(msg)) + 's', msg)
			s.send(pkt)
			if msg == KILL_CODE:
				s.close()
				exit(0)
			myTurn = False
		pkt = s.recv(BUF_SIZE)
		msg = struct.unpack(str(len(pkt)) + 's', pkt)[0]
		print msg
		if msg == KILL_CODE:
			s.close()
			exit(0)
		myTurn = True
else:
	while True:
		if myTurn:
			msg = raw_input(">>")
			pkt = struct.pack(str(len(msg)) + 's', msg)
			conn.send(pkt)
			if msg == KILL_CODE:
				conn.close()
				s.close()
				exit(0)
			myTurn = False
		pkt = conn.recv(BUF_SIZE)
		msg = struct.unpack(str(len(pkt)) + 's', pkt)[0]
		print msg
		if msg == KILL_CODE:
			conn.close()
			s.close()
			exit(0)
		myTurn = True