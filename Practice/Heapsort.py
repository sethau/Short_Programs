#! usr/bin.env python
'''
Heapsort

O(nlogn) in place
'''

SEQ = [1, 4, -3, 10, -5, -1, 7, 2, 2, -15, 2, 5, 20, -7]

def bubbleDown(seq, i, size = None):
	if size:
		length = size
	else:
		length = len(seq)
	while i < length:
		#sift down as far as necessary
		l = 2 * i + 1
		r = l + 1
		if l < length:
			leftChild = seq[l]
			if r < length:
				rightChild = seq[r]
			else:
				rightChild = seq[i] - 1
		else:
			leftChild = seq[i] - 1
			rightChild = seq[i] - 1
		#if a child is greater than parent, swap parent with larger child
		if leftChild > rightChild and leftChild > seq[i]:
			seq[i], seq[l] = seq[l], seq[i]
			i = l
		elif rightChild > leftChild and rightChild > seq[i]:
			seq[i], seq[r] = seq[r], seq[i]
			i = r
		else:
			i = length

def heapify(seq):
	#index of last parent
	i = int((len(seq) - 2) / 2)
	while i >= 0:
		bubbleDown(seq, i)
		i -= 1

def heapsort(seq):
	heapify(seq)
	next = len(seq) - 1
	while next > 0:
		seq[0], seq[next] = seq[next], seq[0]
		bubbleDown(seq, 0, next)
		next -= 1

print SEQ
heapsort(SEQ)
print SEQ