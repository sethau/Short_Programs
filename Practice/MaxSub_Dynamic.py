#!usr/bin/env python
'''
Maximum Contiguous Subsequence
Given a sequence of integers, find the MCS.
A subsequence is maximum if the sum of its elements
is positive and greater than the respective sums
of all other possible subsequences.

This solution uses an O(n) dynamic programming method
that consists of repeatedly equivalizing sections of the
input list until a maximum net-positive subsequence is found.
'''

SEQ = [1, 4, -3, 10, -5, -1, 2, 2, 0, -15, 3, 5, 20, -7]
#SEQ = [1, 4, 3, 10, -5, -1, 2, 2, 0, -15, 3, 5, 2, -7]
#SEQ = [100, -4, -3, -10, -5, -1, -2, -2, 0, -15, -3, -5, -2, 40]
#SEQ = [100, -4, -3, -10, -5, -1, -2, -2, 0, -15, -3, -5, -2, 70]

def condenseMonotonics(seq):
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

def equivalize(seq):
	best = (-1, -1, -1)
	while len(seq) > 3:
		i = 0
		#combine net positives
		while i < len(seq) - 2:
			if seq[i][2] + seq[i + 1][2] > 0 and seq[i + 2][2] + seq[i + 1][2] > 0:
				temp = (seq[i][0], seq[i + 2][1], seq[i][2] + seq[i + 1][2] + seq[i + 2][2])
				del seq[i + 1], seq[i + 1]
				seq[i] = temp
			else:
				i += 2
		i = 0
		#combine net negatives
		#if a net negative set of three is
		#found around a new best net positive,
		#save net positive in $best before equivalizing
		while i < len(seq) - 1:
			if i is 0:
				if seq[0][2] + seq[1][2] < 0:
					if seq[0][2] > best[2]:
						best = seq[0]
					del seq[0], seq[0]
				else:
					i += 1
			elif i is len(seq) - 1 and seq[i][2] + seq[i + 1][2] < 0:
				if seq[i + 1][2] > best[2]:
					best = seq[i + 1]
				del seq[i], seq[i]
			elif i < len(seq) - 2 and seq[i][2] + seq[i + 1][2] < 0 and seq[i + 2][2] + seq[i + 1][2] < 0:
				temp = (seq[i][0], seq[i + 2][1], seq[i][2] + seq[i + 1][2] + seq[i + 2][2])
				del seq[i + 1], seq[i + 1]
				seq[i] = temp
			else:
				i += 2
	#one final positive combination pass
	if len(seq) is 3:
		if seq[0][2] + seq[1][2] > 0 and seq[2][2] + seq[1][2] > 0:
			temp = (seq[0][0], seq[2][1], seq[0][2] + seq[1][2] + seq[2][2])
			del seq[1], seq[1]
			seq[0] = temp
	#sequence is in most condensed form
	#either [pos] or [pos, neg, pos]
	if len(seq) is 3:
		if seq[0][2] > seq[2][2]:
			temp = seq[0]
		else:
			temp = seq[2]
	else:
		temp = seq[0]
	if temp[2] > best[2]:
		return temp
	else:
		return best
		
def findMaxSubsequence(seq):
	range = equivalize(condenseMonotonics(seq))
	return range

print findMaxSubsequence(SEQ)