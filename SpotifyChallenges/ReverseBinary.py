numIn = int(raw_input())
revBinary = None
powOf2 = 1
i = 0
while powOf2 < numIn:
	powOf2 *= 2
	i += 1
while numIn > 0:
	if numIn > 1:
		while powOf2 > numIn:
			powOf2 /= 2
			i -= 1
	else:
		i = 0
	if not revBinary:
		revBinary = [0] * (i + 1)
	revBinary[i] = 1
	numIn -= powOf2
numOut = 0
i = len(revBinary) - 1
p = 1
while i >= 0:
	numOut += p * revBinary[i]
	p *= 2
	i -= 1
print numOut