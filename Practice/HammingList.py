#This program calculates the Hamming Distance of each pair of binary strings.
#Two methods of doing this have been implemented:
#one through string interpretation, and the other through arithmetic analysis

#converts binary string to int
def valueOf(str):
    n = 0
    value = 1
    i = len(str) - 1
    while i >= 0:
        if str[i] == '1': n += value
        value *= 2
        i -= 1
    return n

def indexOf(l, x):
    i = 0
    while i < len(l) and l[i] != x:
        i += 1
    if i < len(l):
        return i
    return -1

#calculates Hamming Distance between two binary strings
#character by character comparison
def strHammingDistance(a, b):
    if len(a) < len(b): a, b = b, a
    distance = 0
    i = 1
    while i <= len(a):
        if i <= len(b) and a[len(a) - i] != b[len(b) - i]:
            distance += 1
        elif i > len(b) and a[len(a) - i] == '1':
            distance += 1
        i += 1
    return distance

#calculates Hamming Distance between two (base 10) integers
#compares remainders from powers of two subtractions
def intHammingDistance(a, b):
    if b > a: a, b = b, a
    distance = 0
    x = 1
    while x <= a:
        x *= 2
    while x >= 1:
        if (x <= a and x > b) or (x > a and x <= b):
            distance += 1
        if x <= a: a -= x
        if x <= b: b -= x
        x /= 2

    return distance

#prints Hamming Distance of each pair of binary strings
#(as calculated via both string interpretation and arithmetic analysis)
def allPairsDistance(values):
    for i in xrange(len(values)):
        for j in xrange(i + 1, len(values)):
            if i != j:
                print values[i], values[j], strHammingDistance(values[i], values[j]), intHammingDistance(valueOf(values[i]), valueOf(values[j]))

#program start
numList = ["1001", "1100", "1010", "1", "11110"]
allPairsDistance(numList)