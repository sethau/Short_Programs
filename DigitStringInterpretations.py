# a=1 b=2 c=3 ... z=26
# Given string of digits, output all possible interpretations.
# Ex: 121 -> aba, la, au
letters = '0abcdefghijklmnopqrstuvwxyz'

#ensures valid number, and returns the appropriate letter
def getLetter(strNum):
    if len(strNum) == 1 and strNum != '0':
        return letters[int(strNum)]
    elif len(strNum) == 2:
        if strNum[0] == '0':
            return letters[int(strNum[1])]
        elif strNum[0] == '1':
            return letters[int(strNum)]
        elif strNum[0] == '2' and int(strNum[1]) < 7:
            return letters[int(strNum)]
    return ''

#covers all possible interpretations recursively
#parses number string from rear
def printPossibleValues(numString, soFar):
    if len(numString) == 0:
        print soFar
    elif len(numString) == 1:
        print getLetter(numString) + soFar
    elif len(numString) == 2:
        print getLetter(numString[0]) + getLetter(numString[1]) + soFar
        print getLetter(numString) + soFar
    else:
        printPossibleValues(numString[:-1], getLetter(numString[-1:]) + soFar)
        temp = getLetter(numString[-2:])
        if temp != '':
            printPossibleValues(numString[:-2], temp + soFar)

#program start
printPossibleValues('12412345674559456789098765', '')