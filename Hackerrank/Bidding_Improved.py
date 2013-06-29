#!/bin/python
#author: Seth Denney
#date: 1/2013
#Bidding For Scotch on Hackerrank.com
#
#Dynamic Level 1 implementation

BOARD_LEN = 10
VIC_DIST = 1
LOSS_DIST = 9
LOW_BID = 5
MIN_RESERVE = 7
MIN_BID = 1

#game passes in only:
#player id {1|2}
#scotch position {0,10}
#lists of each player's previous bids
def calculate_bid(player, pos, first_moves, second_moves):
	#current money must be calculated from move lists, from $100
	#only bid winner pays
    money1, money2 = 100, 100
    count = 0
    for i in range(0, len(first_moves)):
		bid1 = first_moves[i]
		bid2 = second_moves[i]
		if bid1 > bid2:
			money1 -= bid1
		elif bid1 < bid2:
			money2 -= bid2
		elif count % 2 == 0:
			money1 -= bid1
			count += 1
		else:
			money2 -= bid2
			count += 1
	#determine ownership of funds
    if player == 1:
		mine = money1
		me = first_moves
		theirs =  money2
		them = second_moves
    else:
		mine = money2
		me = second_moves
		theirs = money1
		them = first_moves
	
	#draw advantage alternates each turn
    draw = (count % 2 == player - 1 and theirs > 0)
	#strategy is more dynamic, with prioritized move options
    if victory(player, pos, mine, theirs):
		if draw:
			return theirs
		else:
			return theirs + 1
	elif nearVictory(player, pos, mine, theirs):
		return int((mine - theirs) / distance(player, pos)) + int(0.5 * theirs)
    elif distance(player, pos) == VIC_DIST:
		return mine
    elif distance(player, pos) == LOSS_DIST:
		if (mine > theirs):
			if draw:
				return theirs
			else:
				return theirs + 1
		else:
			return mine
    elif len(them) > 0
	and not wonLast(me, them, draw)
	and mine > me[len(me) - 1] + int(mine / distance(player, pos)):
		return me[len(me) - 1] + int(mine / distance(player, pos))
    elif int(mine / distance(player, pos)) > 0:
		return int(mine / (distance(player, pos) + 1))
    elif mine > MIN_RESERVE:
		return LOW_BID
    elif mine > 0:
		return MIN_BID
	else:
		return 0

def distance(player, pos):
	if player == 1:
		return pos
	else:
		return BOARD_LEN - pos

#victory is guaranteed
def victory(player, pos, mine, theirs):
	return theirs < int(mine / distance(player, pos))

#victory could be close
def nearVictory(player, pos, mine, theirs):
	return int(0.5 * theirs) < int(mine / distance(player, pos))

#did I win the last bid?
def wonLast(me, them, draw):
	if (me[len(me) - 1] > them[len(them) - 1]):
		return true
	if (them[len(them) - 1] > me[len(me) - 1]):
		return false
	if (me[len(me) - 1] == them[len(them) - 1]):
		return not draw

#required Hackerrank game code
player = input()
scotch_pos = input()
first_moves = [int(i) for i in raw_input().split()]
second_moves = [int(i) for i in raw_input().split()]
bid = calculate_bid(player,scotch_pos,first_moves,second_moves)
print bid
