#!/bin/python
#author: Seth Denney
#date: 1/2013
#Bidding For Scotch on Hackerrank.com
#
#Simple concept implementation

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
		else:
			money2 -= bid2
		count += 1
	#determine ownership of funds
    if player == 1:
		mine = money1
		theirs =  money2
    else:
		mine = money2
		theirs = money1
	#very basic, arbitrary, and terrible strategy
	#that mostly guards against or seizes boundary cases
    if distance(player, pos) == 1:
		return mine
    elif distance(player, pos) == 9:
		if (mine > theirs):
			return theirs + 1
		else:
			return mine
    else:
		return int(mine / distance(player, pos))
    
    return 0

def distance(player, pos):
	if player == 1:
		return pos
	else:
		return 10 - pos

#required Hackerrank game code
player = input()
scotch_pos = input()
first_moves = [int(i) for i in raw_input().split()]
second_moves = [int(i) for i in raw_input().split()]
bid = calculate_bid(player,scotch_pos,first_moves,second_moves)
print bid
