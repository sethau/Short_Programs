def add(targetList, newTuple):
	for i in range(len(targetList)):
		if newTuple[1] > targetList[i][1]:
			targetList.insert(i, newTuple)
			return
	targetList.append(newTuple)

[numCases, numChoose] = [int(n) for n in raw_input().split(' ')]
chosen = []
infoIn = raw_input().split(' ')
numPlays, songName = int(infoIn[0]), infoIn[1]
basePlays = numPlays
chosen.append((songName, 1))

for i in range(2, numCases + 1):
	infoIn = raw_input().split(' ')
	numPlays, songName = int(infoIn[0]), infoIn[1]
	zipfScore = float(basePlays) / i
	zipfScore = float(numPlays) / zipfScore
	if len(chosen) < numChoose:
		add(chosen, (songName, zipfScore))
	elif zipfScore > chosen[-1][1]:
		chosen = chosen[:-1]
		add(chosen, (songName, zipfScore))
		
for songTuple in chosen:
	print songTuple[0]
