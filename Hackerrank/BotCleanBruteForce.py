#!/usr/bin/python
#author: Seth Denney
#date: 1/2013
#BotClean challenge on Hackerrank.com
#4x4 grid with n dirty squares
#move to squares and clean in fewest moves
#
#Simple Brute Force (exponential) implementation
#to find shortest path
#NOTE: Standard Traveling Salesman solution would not be
#shortest because there is no need to return to "home"
import math

# Head ends here
def next_move(posx, posy, board):
    newBoard = []
	#split board into 2D char array
    for str in board:
		newBoard.append(list(str))

    if (newBoard[posx][posy] == "d"):
        print "CLEAN"
        return "herpes"

    dirty = dirtyCells(newBoard)

    path = shortestPath(paths(posx, posy, ([(posx, posy),]), dirty, 0))
    print directionTo(posx, posy, path[0])

def dirtyCells(board):
	cells = []
	for row in range(0, len(board)):
		for col in range(0, len(board[row])):
			if board[row][col] == "d":
				cells.append((row, col))
	return cells

#Returns all possible cleaning paths
def paths(x, y, cleaned, remaining, distance):
	if (len(remaining) == 0):
		return [(cleaned, distance),]
	else:
		distances = []
        for cell in remaining:
            if (cell[0] != x and cell[1] != y):
                c = list(cleaned)
                r = list(remaining)
                r.remove(cell)
                c.append(cell)
                distances.append(paths(cell[0], cell[1], list(cleaned), list(remaining), distance + distanceTo(cell[0], cell[1], cell)))
		return distances

def shortestPath(paths):
	best = ([], 99999),
	for possible in paths:
		if (possible[1] < best):
			best = possible
	return best[0]

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