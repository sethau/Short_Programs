#include <string>
#include <vector>
#include <stdio.h>
#include <iostream>

using namespace std;

void selectNumToFront(string *names, double *scores, int numCases, int numChoose);

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

	selectNumToFront(songs, scores, numCases, numChoose);

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

void selectNumToFront(string *songs, double *scores, int numCases, int numChoose)
{
	int bestIndex;
	double bestScore, tempScore;
	string bestSong, tempSong;

	for (int i = 0; i < numChoose; i++)
	{
		bestIndex = numCases - 1;
		bestScore = scores[bestIndex];
		bestSong = songs[bestIndex];
		for (int j = numCases - 1; j >= i; j--)
		{
			if (scores[j] >= bestScore)
			{
				bestIndex = j;
				bestScore = scores[bestIndex];
				bestSong = songs[bestIndex];
			}
		}
		
		tempScore = scores[bestIndex];
		tempSong = songs[bestIndex];
		scores[bestIndex] = scores[i];
		scores[i] = tempScore;
		songs[bestIndex] = songs[i];
		songs[i] = tempSong;
	}
}