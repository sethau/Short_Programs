#include <string>
#include <vector>
#include <stdio.h>
#include <iostream>

using namespace std;

void bubbleNumToFront(string *names, double *scores, int numCases, int numChoose);

int main()
{
	int numCases, numChoose;
	double basePlays, numPlays, zipfScore;
	string songName;
	double *scores;
	string *songs;

	cin >> numCases;
	cin >> numChoose;

	scores = new double[numCases];
	songs = new string[numCases];

	cin >> basePlays;
	cin >> songName;

	if (basePlays == 0)
	{
		basePlays = 1;
	}

	scores[0] = 1.0;
	songs[0] = songName;

	for (int i = 2; i < numCases + 1; i++)
	{
		cin >> numPlays;
		cin >> songName;

		zipfScore = basePlays / i;
		zipfScore = numPlays / zipfScore;

		scores[i - 1] = zipfScore;
		songs[i - 1] = songName;
	}

	bubbleNumToFront(songs, scores, numCases, numChoose);

	for (int i = 0; i < numChoose; i++)
	{
		if (i > 0)
		{
			cout << endl;
		}
		cout << songs[i];
	}

	return 0;
}

void bubbleNumToFront(string *songs, double *scores, int numCases, int numChoose)
{
	int tempScore;
	string tempSong;

	for (int i = 0; i < numChoose; i++)
	{
		for (int j = numCases - 1; j > 0; j--)
		{
			if (j - 1 < numCases && scores[j - 1] < scores[j])
			{
				tempScore = scores[j];
				tempSong = songs[j];
				scores[j] = scores[j - 1];
				scores[j - 1] = tempScore;
				songs[j] = songs[j - 1];
				songs[j - 1] = tempSong;
			}
		}
	}
}