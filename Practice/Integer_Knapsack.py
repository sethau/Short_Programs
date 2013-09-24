#!usr/bin/env python
'''
Integer Knapsack Problem
Knapsack with (Integer) Capacity
n Items each with Value and (Integer) Size
Duplicate Items Allowed
Find combination of Items to maximize value.

This solution uses an O(C*n) dynamic programming method.
'''

import sys

ITEMS = [
{"size": 1, "value": 2},
{"size": 2, "value": 5},
{"size": 3, "value": 7},
{"size": 4, "value": 11},
{"size": 5, "value": 15}]

CAP = int(sys.argv[1])
maxVal = {0: {"val": 0, "prevCap": 0}}

for cap in xrange(1, CAP + 1):
	maxVal[cap] = {"val": 0, "prevCap": 0}
	for item in ITEMS:
		rem = cap - item["size"]
		if rem >= 0:
			if rem > 0 and rem in maxVal:
				maxVal[cap]["val"] = max(maxVal[cap]["val"], item["value"] + maxVal[rem]["val"])
				maxVal[cap]["prevCap"] = rem
			elif rem is 0:
				maxVal[cap]["val"] = item["value"]
				maxVal[cap]["prevCap"] = 0
print "Maximum value for capacity", CAP, "is", maxVal[cap]["val"]
cap = CAP
while cap > 0:
	valDiff = maxVal[cap]["val"] - maxVal[maxVal[cap]["prevCap"]]["val"]
	sizeDiff = cap - maxVal[cap]["prevCap"]
	for item in ITEMS:
		if item["size"] is sizeDiff and item["value"] is valDiff:
			print item
			break
	cap -= sizeDiff