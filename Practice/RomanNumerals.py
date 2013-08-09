#This program evaluates a roman numeral string stored in 'numeral'
hierarchy = ['I', 'V', 'X', 'L', 'C', 'D', 'M']
values =    [ 1,   5,  10,  50,  100, 500, 1000]

def lessThan(a, b):
    if indexOf(hierarchy, a) < indexOf(hierarchy, b):
        return True
    return False
    
def indexOf(l, x):
    i = 0
    while i < len(l) and l[i] != x:
        i += 1
    if i < len(l):
        return i
    return -1

def valueOf(digit):
    i = indexOf(hierarchy, digit)
    if i < 0:
        return 0
    return values[i]

def evaluate(numString):
	output = 0
	i = len(numString) - 1
	while i >= 0:
		if i == len(numString) - 1:
			output += valueOf(numString[i])
		elif lessThan(numString[i], numString[i + 1]):
			output -= valueOf(numString[i])
		else:
			output += valueOf(numString[i])
		i -= 1
	return output

#program start
numeral = "IVXLCDM"

print numeral, " means ", evaluate(numeral)