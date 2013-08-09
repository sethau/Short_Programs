#This program takes in two string representations of binary
#numbers, adds them,and returns the result as a string.
#Yes, I know there are prebuilt methods, but this is more fun.
num1 = "1001"
num2 = "100001"

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

#converts int to binary string
def toBinary(n):
    output = ""
    
    i = 0
    x = 1
    while x <= n:
        x *= 2
        i += 1
    
    i -= 1
    while i >= 0:
        if n >= 2**i:
            output += "1"
            n -= 2**i
        else:
            output += "0"
        i -= 1
    
    return output

#program start
print toBinary(valueOf(num1) + valueOf(num2))