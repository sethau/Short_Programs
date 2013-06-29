#!/usr/bin/python
#author: Seth Denney
#date: 1/2013
#BotClean challenge on Hackerrank.com
#4x4 grid with n dirty squares
#move to squares and clean in fewest moves
#
#Simple Dynamic (but still exponential *sigh*) implementation
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
        return

    dirty = dirtyCells(newBoard)
	#certain versions of the game add the stipulation that
	#the bot can only see a 3x3 square at a time, so if
	#no dirty cells are seen, the bot will explore new ground
    if (len(dirty) == 0):
        if (posx < 2 and posy <= 2):
            print directionTo(posx, posy, (1, 3))
            return
        elif (posx <= 2 and posy > 2):
            print directionTo(posx, posy, (3, 3))
            return
        elif (posx > 2 and posy >= 2):
            print directionTo(posx, posy, (4, 1))
            return
        elif (posx > 2 and posy < 2):
            print directionTo(posx, posy, (2, 1))
            return
        elif (posx == 2 and posy <= 2):
            print directionTo(posx, posy, (1, 3))
            return
	else:
		path = shortestPath(paths((posx, posy), [(posx, posy),], dirty, 0, 99999))
		print directionTo(posx, posy, path[1])

def dirtyCells(board):
	cells = []
	for row in range(0, len(board)):
		for col in range(0, len(board[row])):
			if board[row][col] == "d":
				cells.append((row, col))
	return cells

#Begins checking all possible cleaning paths,
#but keeps track of the best so far, and stops
#any paths that breach the current best distance.
#This can considerably cut down the constants involved,
#especially if the optimal path is found soon.
def paths(xy, cleaned, remaining, distance, best):
    if (len(remaining) == 0):
		if distance < best:
			best = distance
		return [(cleaned, distance),], best
    else:
        distances = []
        for cell in remaining:
            if (not (cell == xy)):
				d = distance + distanceTo(x, y, cell)
				if (d < best)
					c = list(cleaned)
					r = list(remaining)
					r.remove(cell)
					c.append(cell)
					paths = paths(cell, c, r, d, best)
					distances += paths[0]
					best = paths[1]
    return distances

def shortestPath(paths):
    best = 99999
    path = []
    for (candidate, distance) in paths:
        if (distance < best):
            best = distance
            path = candidate
    return path

#sorts list of dirty cells by distance to raise
#probability of optimal path being found sooner
#rather than later; see paths();
#will use a partial BubbleSort, as optimal path
#will probably not go in strict distance order,
#and hence a full sort may actually be counter-productive;
#think "guided randomization"
def sortDirtyByDistance(x, y, dirty):
	for range(1, int(len(dirty) / 1.5)):
		for i in range(0, len(dirty) - 1):
			if (distanceTo(x, y, dirty[i]) > distanceTo(x, y, dirty[i + 1]):
				dirty[i], dirty[i + 1] = dirty[i + 1], dirty[i]

def distanceTo(x, y, target):
    return math.fabs(x - target[0]) + math.fabs(y - target[1])

def directionTo(x, y, target):
	if (x < target[0]):
		return "DOWN"
	elif (x > target[0]):
		return "UP"
	elif (y < target[1]):
		return "RIGHT"
	elif (y > target[1]):
		return "LEFT"
	else:
		return "CLEAN"

#Hackerrank Tail starts here