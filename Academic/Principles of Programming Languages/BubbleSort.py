#! usr/bin/env python
#Seth Denney Homework 1

import sys

print 'Enter the integers: '
read = sys.stdin.readline()

array = read.split()
int_array = [int(s) for s in array]
n = len(int_array)

print 'n = ', n
print int_array
print 'Sorting...'

for i in range(1, len(int_array)):
	for j in range(0, len(int_array) - 1):
		if (int_array[j] > int_array[j + 1]):
			int_array[j], int_array[j + 1] = int_array[j + 1], int_array[j]

print 'n = ', n
print int_array