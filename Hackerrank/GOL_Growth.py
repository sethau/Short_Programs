#!/usr/bin/python
#author: Seth Denney
#date: 1/2013
#Conway's Game of Life challenge on Hackerrank.com
#29x29 grid with two players alternating initial cell
#placement choices; Each player gets 40 initial cells,
#and then the game runs for 500 iterations to
#determine the victor
#
# Conway's Game of Life on Hackerrank.com
# This solution in Python to CGOL creates 4 growers
# that will multiply 3x if left alone. After that,
# stable 2x2 squares fill up the center space
# until all cells have been placed.
#
#UL = Upper Left, BR = Bottom Right, etc.

# Head ends here
def nextMove(player, board):
	growers = []
	squares = []
	g = [[4, 4], [4, 24], [24, 4], [24, 24]]
	s = [[17, 13], [17, 17], [13, 13], [13, 17], [15, 9], [15, 21],
	[9, 15], [21, 15], [15, 1], [15, 28], [15, 5], [15, 24]]
	newBoard = []
	
	#determine opponent color
	if player == 'b':
		opp = 'w'
	else:
		opp = 'b'
	
	for str in board:
		newBoard.append(list(str))
	#construct patterned coord lists from start cells
	for coord in g:
		x = coord[0]
		y = coord[1]
		l = [[x, y], [x, y-1], [x, y+1], [x-1, y]]
		growers.append(l)
	for coord in s:
		x = coord[0]
		y = coord[1]
		l = [[x, y], [x-1, y], [x-1, y-1]]
		squares.append(l)
	#build patterns
	for grower in growers:
		for cell in grower:
			if not taken(newBoard, cell[0], cell[1]):
				return cell[0], cell[1]
	for square in squares:
		for cell in square:
			if not taken(newBoard, cell[0], cell[1]):
				return cell[0], cell[1]
	
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