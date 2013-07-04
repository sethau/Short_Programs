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
	j = i - 1
	key = int_array[i]
	while (j >= 0 and int_array[j] > key):
		int_array[j + 1] = int_array[j]
		j -= 1
	int_array[j + 1] = key

print 'n = ', n
print int_array