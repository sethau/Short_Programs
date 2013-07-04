The overall strategy used for implementing this Boggle game was to:

use a driver method in Boggle.java to run the game
set up the board
read in a list of acceptable words and store them in a dictionary object
print the board for the user
search through the board for all acceptable words
allow the user to input guesses for acceptable words
check user words and filter out unacceptable or duplicate words
calculate and print scores


Some specific ways that efficiency was addressed:

Only words that are of length 3 or greater are made searchable in the dictionary, to remove unneccessary obstacles in word checking.
The TrieNode class was built to store the dictionary to make word checking more efficient.
All aceptable words were found before the user words were entered to circumvent the possibility of double searching the board.
In addition to the above strategic streamlining decisions, all methods were written to ensure that the processes involved were
	only executed when necessary (ie. not if certain necessary conditions were met)


Additional Notes:

No iterator() method was implemented because of your post on the Discussion thread stating that it was not required
	if one chose to implement a Trie.
For the LARGE_WORD_LIST file, the word loading can take a VERY long time (at least on my laptop), so if it does seem as if it has
	stopped running, or gotten stuck in a loop, etc. don't lose hope. It IS loading the words. I (as you can see in the code) simply
	used a Scanner object's getNextLine() method inside a while loop, so I don't feel as though it could be anything from my program
	causeing the lag. *NOTE* The long load time was happening even before I moved my TrieNode.addSequence() calls into the Scanner loop,
	so that is not the cause. It is solely intrinsic to the Scanner class (and the ridiculously large number of lines in the file).
