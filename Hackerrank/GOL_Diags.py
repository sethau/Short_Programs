#!/usr/bin/python
#author: Seth Denney
#date: 1/2013
#Conway's Game of Life challenge on Hackerrank.com
#29x29 grid with two players alternating initial cell
#placement choices; Each player gets 40 initial cells,
#and then the game runs for 500 iterations to
#determine the victor
#
# This solution in Python to CGOL creates a series of lines
# (until the allotted 40 cells are placed) from DR
# to UL. Each path is a straight line. This implementation
# is mostly just a first test of the game in Python.
# The idea is that these lines will disrupt any designs
# the opponent may have.
#
#UL = Upper Left, BR = Bottom Right, etc.

# Head ends here
def nextMove(player, board):
	newBoard = []
	for s in board:
		newBoard.append(list(s))
	for row in range(0, 28, 2):
		if (newBoard[28 - row][28] == "-"):
			return 28 - row, 28
		else:
			i, j = diagonalUL(newBoard, 28 - row, 28)
			if (i != -1):
				return i, j
	for col in range(0, 28, 2):
		if (newBoard[28][28 - col] == "-"):
			return 28, 28 - col
		else:
			i, j = diagonalUL(newBoard, 28, 28 - col)
			if (i != -1):
				return i, j
	for row in range(0, 28, 2):
		if (newBoard[row][28] == "-"):
			return row, 28
		else:
			i, j = diagonalUR(newBoard, row, 28)
			if (i != -1):
				return i, j
	for col in range(0, 28, 2):
		if (newBoard[0][28 - col] == "-"):
			return 0, 28 - col
		else:
			i, j = diagonalUR(newBoard, 0, 28 - col)
			if (i != -1):
				return i, j
	
def diagonalUL(board, x, y):
	if (x == 0 or y == 0):
		return -1, -1
	elif (board[x - 1][y - 1] == "-"):
		return x - 1, y - 1
	else:
		return diagonalUL(board, x - 1, y - 1)
		
def diagonalUR(board, x, y):
	if (x == 28 or y == 0):
		return -1, -1
	elif (board[x + 1][y - 1] == "-"):
		return x + 1, y - 1
	else:
		return diagonalUL(board, x + 1, y - 1)

#Hackerrank Tail starts here
player = raw_input()
board = []
for i in xrange(0, 29):
    board.append(raw_input())
a,b = nextMove(player,board)
print a,b