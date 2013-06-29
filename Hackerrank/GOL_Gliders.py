#!/bin/python

# Conway's Game of Life on Hackerrank.com
# This solution in Python to CGOL attempts to create
# a 'safe' set of 3 2X2 stable squares in the DR corner
# and 2 in the DL corner. It also creates 5 gliders in DR
# whose purpose is to attack the opponent's designs.
# It then creates a path from UR which
# is a straight line of the same
# stable boxes useed in DR and DL. The idea is that UR
# may disrupt any designs the opponent may have. 
# If they are almost exclusively
# in UL, the UR stable boxes will maintain life
# for the entirety of the game.

# Head ends here
def nextMove(player, board):
	squares = []
	gliders = []
	s = [[28, 28], [28, 5], [24, 28], [28, 24], [28, 1]]
	g = [[28, 19], [23, 19], [20, 28], [20, 23], [18, 18]]
	newBoard = []
	
	#determine opponent color
	if player == 'b':
		opp = 'w'
	else:
		opp = 'b'
	#split board into 2D char array
	for str in board:
		newBoard.append(list(str))
	#construct patterned coord lists from start cells
	for coord in s:
		x = coord[0]
		y = coord[1]
		l = [[x, y], [x-1, y], [x-1, y-1]]
		squares.append(l)
	for coord in g:
		x = coord[0]
		y = coord[1]
		l = [[x, y], [x, y-2], [x-1, y-2], [x-1, y-1], [x-2, y-1]]
		gliders.append(l)
	#build patterns
	for square in squares:
		for cell in square:
			if not taken(newBoard, cell[0], cell[1]):
				return cell[0], cell[1]
	for glider in gliders:
		for cell in glider:
			if not taken(newBoard, cell[0], cell[1]):
				return cell[0], cell[1]
	#if extra cells are left, try some opp blocking
	success = False
	mod = 0
	while not success and mod < 100:
		if mod % 3 != 2:
			if not success:
				success, x, y = blockUR(newBoard, mod)
		if mod % 3 == 0:
			if not success:
				success, x, y = assistUR(newBoard, mod, 'b')
		mod += 1
	return x, y
				
#tests for opp disruption from UR
def blockUR(board, mod):
	x1, y1 = 0, 28
	if not taken(board, x1, y1):
		return True, x1, y1
	if not taken(board, x1 + mod, y1 - mod) and 0 <= x1 + mod <= 28 and 0 <= y1 - mod <= 28:
		return True, x1 + mod, y1 - mod
	else:
		return False, x1 + mod, y1 - mod
				
#test for improving disruptors from UR
def assistUR(board, mod, side):
	if (side == 'a'):
		x1, y1 = 1, 28
	else:
		x1, y1 = 0, 27
	if not taken(board, x1, y1):
		return True, x1, y1
	if not taken(board, x1 + mod, y1 - mod) and 0 <= x1 + mod <= 28 and 0 <= y1 - mod <= 28:
		return True, x1 + mod, y1 - mod
	else:
		return False, x1 + mod, y1 - mod
	
def taken(board, x, y):
	if (0 <= x <= 28 and 0 <= y <= 28):
		return board[x][y] != '-'
	else:
		return True

#Hackerrank Tail starts here
player = raw_input()
board = []
for i in xrange(0, 29):
    board.append(raw_input())
a,b = nextMove(player,board)
print a,b