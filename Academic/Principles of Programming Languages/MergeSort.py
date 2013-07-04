#! usr/bin/env python
#Seth Denney Homework 1

import sys
import math

print 'Enter the integers: '
read = sys.stdin.readline()

array = read.split()
int_array = [int(s) for s in array]
n = len(int_array)

print 'n = ', n
print int_array
print 'Sorting...'

def Merge(first, mid, last):
	L = int_array[first:mid + 1]
	R = int_array[mid + 1:last + 1]
	L.append(float('inf'))
	R.append(float('inf'))
	i = 0
	j = 0
	while first <= last:
		if (L[i] <= R[j]):
			int_array[first] = L[i]
			i += 1
			first += 1
		else:
			int_array[first] = R[j]
			j += 1
			first += 1

def MergeSort(l, r):
	if (l < r):
		m = int(math.floor((l + r) / 2))
		MergeSort(l, m)
		MergeSort(m + 1, r)
		Merge(l, m, r)

MergeSort(0, n - 1)
print 'n = ', n
print int_array