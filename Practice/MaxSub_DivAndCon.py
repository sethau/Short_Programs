#!usr/bin/env python
'''
Maximum Contiguous Subsequence
Given a sequence of integers, find the MCS.
A subsequence is maximum if the sum of its elements
is greater than the sum of all other possible subsequences.

This solution uses an O(nlogn) divide and conquer method.
'''

#SEQ = [1, 4, -3, 10, -5, -1, 2, 2, 0, -15, 3, 5, 20, -7]
#SEQ = [1, 4, 3, 10, -5, -1, 2, 2, 0, -15, 3, 5, 2, -7]
#SEQ = [100, -4, -3, -10, -5, -1, -2, -2, -0, -15, -3, -5, -2, 40]
SEQ = [100, -4, -3, -10, -5, -1, -2, -2, -0, -15, -3, -5, -2, 70]

def condense(seq):
	dense_seq = []
	start = -1
	posFlag = True #True when searching for positive val
	#condense any continuous pos/neg sequences in one pass
	for i in xrange(len(seq)):
		if posFlag and seq[i] > 0:
			if start is not -1:
				end = i - 1
				dense_seq.append((start, end, sum))
			start = i
			sum = seq[i]
			posFlag = False
		elif not posFlag and seq[i] < 0:
			end = i - 1
			dense_seq.append((start, end, sum))
			start = i
			sum = seq[i]
			posFlag = True
		else:
			sum += seq[i]
		if not posFlag and i is len(seq) - 1:
			end = i
			dense_seq.append((start, end, sum))
	print "Size condensed by factor of", float(len(SEQ)) / len(dense_seq)
	return dense_seq

def maxSub(seq, a, b):
	#run MCS algorithm on condensed list
	if a is b:
		return (a, a, seq[a][2])
	else:
		pivot = (a + b) / 2
		#max subsequence exclusively in left half
		left = maxSub(seq, a, pivot)
		#max subsequence exclusively in right half
		right = maxSub(seq, pivot + 1, b)
		#calculate max sequence left from mid
		lsum = seq[pivot][2]
		temp = 0
		for i in xrange(pivot, a - 1, -1):
			temp += seq[i][2]
			if temp >= lsum:
				l = i
				lsum = temp
		#calculate max sequence right from mid
		rsum = seq[pivot + 1][2]
		temp = 0
		for i in xrange(pivot + 1, b + 1):
			temp += seq[i][2]
			if temp >= rsum:
				r = i
				rsum = temp
		#combine to find max subsequence crossing mid
		mid = (l, r, lsum + rsum)
		if left[2] > mid[2] and left[2] > right[2]:
			return left
		elif right[2] > mid[2] and right[2] > left[2]:
			return right
		else:
			return mid

def findMaxSubsequence(seq):
	dense = condense(seq)
	range = maxSub(dense, 0, len(dense) - 1)
	unpackedRange = (dense[range[0]][0], dense[range[1]][1], range[2])
	return unpackedRange

print findMaxSubsequence(SEQ)