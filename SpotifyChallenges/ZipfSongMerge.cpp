#include <string>
#include <vector>
#include <stdio.h>
#include <iostream>

using namespace std;

struct Song {
	string name;
	double zipfScore;
};

void mergeSort(Song *songs, int begin, int end);
void merge(Song *songs, int a, int mid, int end);

int main()
{
	int numCases, numChoose;
	double basePlays, numPlays, zipfScore;
	string songName;
	Song *songs;

	cin >> numCases;
	cin >> numChoose;

	songs = new Song[numCases];

	cin >> basePlays;
	cin >> songName;

	// if (basePlays == 0)
	// {
	// 	basePlays = 1;
	// }

	songs[0].zipfScore = basePlays;
	songs[0].name = songName;

	for (int i = 2; i < numCases + 1; i++)
	{
		cin >> numPlays;
		cin >> songName;

		//zipfScore = basePlays / i;
		//zipfScore = numPlays / zipfScore;
		zipfScore = numPlays * i;
		
		songs[i - 1].zipfScore = zipfScore;
		songs[i - 1].name = songName;
	}

	//if numChoose/numCases is sufficiently small, use numChoose selection sort?
	mergeSort(songs, 0, numCases - 1);

	for (int i = 0; i < numChoose; i++)
	{
		if (i > 0)
		{
			cout << endl;
		}
		cout << songs[i].name;
	}

	return 0;
}

void mergeSort(Song *songs, int begin, int end)
{
	int mid = begin + (end - begin) / 2;
	if (end > begin + 1)
	{
		mergeSort(songs, begin, mid);
		mergeSort(songs, mid + 1, end);
	}
	merge(songs, begin, mid, end);
}

void merge(Song *songs, int a, int mid, int end)
{
	int begin = a, b = mid + 1, i;
	Song *tempSongs;
	tempSongs = new Song[end - a + 1];
	for (i = 0; i <= end - begin; i++)
	{
		if (a <= mid)
		{
			if (b <= end)
			{
				if (songs[a].zipfScore >= songs[b].zipfScore)
				{
					tempSongs[i] = songs[a];
					a++;
				}
				else
				{
					tempSongs[i] = songs[b];
					b++;
				}
			}
			else
			{
				tempSongs[i] = songs[a];
				a++;
			}
		}
		else if (b <= end)
		{
			tempSongs[i] = songs[b];
			b++;
		}
	}
	for (i = begin; i <= end; i++)
	{
		songs[i] = tempSongs[i - begin];
	}
}
