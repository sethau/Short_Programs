#!/usr/bin/python
#author: Seth Denney
#date: 1/2013
#BotClean challenge on Hackerrank.com
#nxn grid with m < n^2 dirty squares
#move to squares and clean in fewest moves
#
#Brute Force implementation will be too costly
#for large values of n, so a more time-efficient but
#less optimal "nearest neighbor" algorithm is used
import math

# Head ends here
def next_move(posx, posy, dimx, dimy, board):
    newBoard = []
	#split board into 2D char array
    for str in board:
		newBoard.append(list(str))

    if (newBoard[posx][posy] == "d"):
        print "CLEAN"
        return 0

    dirty = dirtyCells(newBoard)
	
	print directionTo(posx, posy, nearest(posx, posy, dirty)

def dirtyCells(board):
	cells = []
	for row in range(0, len(board)):
		for col in range(0, len(board[row])):
			if board[row][col] == "d":
				cells.append((row, col))
	return cells

def nearest(x, y, dirty):
	dist = 999999
	for cell in dirty:
		if distanceTo(x, y, cell) < dist:
			best = cell
	return best

def distanceTo(x, y, target):
    return math.fabs(x - target[0]) + math.fabs(y - target[1])

def directionTo(x, y, target):
	if (x < target[0]):
		return "DOWN"
	if (x > target[0]):
		return "UP"
	if (y < target[1]):
		return "RIGHT"
	if (y > target[1]):
		return "LEFT"
	else:
		return "CLEAN"

#Hackerrank Tail starts here
if __name__ == "__main__":
    pos = [int(i) for i in raw_input().strip().split()]
    dim = [int(i) for i in raw_input().strip().split()]
    board = [[j for j in raw_input().strip()] for i in range(dim[0])]
    next_move(pos[0], pos[1], dim[0], dim[1], board)