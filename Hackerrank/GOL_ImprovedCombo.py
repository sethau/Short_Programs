#!/usr/bin/python
#author: Seth Denney
#date: 1/2013
#Conway's Game of Life challenge on Hackerrank.com
#29x29 grid with two players alternating initial cell
#placement choices; Each player gets 40 initial cells,
#and then the game runs for 500 iterations to
#determine the victor
#
# This solution in Python to CGOL attempts to create
# a 'safe' set of 4 2X2 stable squares in the DR corner
# if no opponent cells are detected nearby.
# It then creates same-depth lines (until the allotted
# 40 cells are placed) inward from each of the three
# remaining corners. The path from UL is a straight line.
# The path from UR and DL are straight lines of the same
# stable boxes useed in DR. The idea is that UL, UR, and DL
# will disrupt any designs the opponent may have, as most
# tend to emanate from UL. If opp is almost exclusively
# in UL, the UR and DL stable boxes will maintain life
# for the entirety of the game.
#
#UL = Upper Left, BR = Bottom Right, etc.
#
# This version differs from GOL_Combo by only using 3/4 of
# the cells for each stable 2X2 block, as the fourth will
# immediately become filled in anyway, thereby allowing for
# those extra initial cells to be placed elsewhere.

# Head ends here
def nextMove(player, board):
	#a 2x2 square is a stable pattern, so leave a "safety net" of squares in the BR corner,
	#where opp is least likely to go (because of subconscious index preferences toward starting around [0,0])
	squares = [[[28, 28], [28, 27], [27, 27]], [[28, 24], [28, 23], [27, 23]],
	[[24, 28], [24, 27], [23, 27]], [[24, 24], [24, 23], [23, 23]]]
	newBoard = []
	
	#determine opponent color
	if player == 'b':
		opp = 'w'
	else:
		opp = 'b'
	#split board into 2D char array
	for s in board:
		newBoard.append(list(s))
	#try safety squares first, but they are only stable
	#if opp does not insert any cells near them and
	#disrupt the pattern
	numCells = 0
	if (squaresClear(newBoard, 23, opp)):
		for square in squares:
			for cell in square:
				if not taken(newBoard, cell[0], cell[1]):
					return cell[0], cell[1]
	#after safety squares have been placed or disrupted,
	#run diagonals through most likely opponent locations (UL corner, then UR and DL)
	#to disrupt any fragile patterns that may exist
	success = False
	mod = 0
	while not success and mod < 100:
		success, x, y = blockUL(newBoard, mod)
		if mod % 3 != 2:
			if not success:
				success, x, y = blockUR(newBoard, mod)
			if not success:
				success, x, y = blockDL(newBoard, mod)
		if mod % 3 == 0:
			if not success:
				success, x, y = assistUR(newBoard, mod, 'b')
			if not success:
				success, x, y = assistDL(newBoard, mod, 'b')
		mod += 1
	return x, y

#tests for opp disruption from UL
def blockUL(board, mod):
	x1, y1 = 0, 0
	if not taken(board, x1, y1):
		return True, x1, y1
	if not taken(board, x1 + mod, y1 + mod) and 0 <= x1 + mod <= 28 and 0 <= y1 + mod <= 28:
		return True, x1 + mod, y1 + mod
	else:
		return False, x1 + mod, y1 + mod

#tests for opp disruption from UR
def blockUR(board, mod):
	x1, y1 = 0, 28
	if not taken(board, x1, y1):
		return True, x1, y1
	if not taken(board, x1 + mod, y1 - mod) and 0 <= x1 + mod <= 28 and 0 <= y1 - mod <= 28:
		return True, x1 + mod, y1 - mod
	else:
		return False, x1 + mod, y1 - mod

#tests for opp disruption from DL
def blockDL(board, mod):
	x1, y1 = 28, 0
	if not taken(board, x1, y1):
		return True, x1, y1
	if not taken(board, x1 - mod, y1 + mod) and 0 <= x1 - mod <= 28 and 0 <= y1 + mod <= 28:
		return True, x1 - mod, y1 + mod
	else:
		return False, x1 - mod, y1 + mod

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

#test for improving disruptors from DL
def assistDL(board, mod, side):
	if (side == 'a'):
		x1, y1 = 28, 1
	else:
		x1, y1 = 27, 0
	if not taken(board, x1, y1):
		return True, x1, y1
	if not taken(board, x1 - mod, y1 + mod) and 0 <= x1 - mod <= 28 and 0 <= y1 + mod <= 28:
		return True, x1 - mod, y1 + mod
	else:
		return False, x1 - mod, y1 + mod

#checks BR range for preexisting opponent cells
def squaresClear(board, bound, opp):
	for x in range(bound, 29):
		for y in range(bound, 29):
			if (board[x][y] == opp):
				return False
	return True
	
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