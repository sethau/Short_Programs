def isPalindrome(x):
	n = x
	numBits = int(math.log(n, 2)) + 1
	mirror = 0
	for i in xrange(numBits):
		mirror += (n & 0b01)
		mirror <<= 1
		n >>= 1
	mirror >>= 1
	return mirror ^ x is 0

def binaryAdd(x, y):
	if x is 0:
		return y
	elif y is 0:
		return x
	else:
		temp = x & y
		temp <<= 1
		return binaryAdd(x ^ y, temp)