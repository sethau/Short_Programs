#include <string>
#include <vector>
#include <stdio.h>
#include <iostream>

using namespace std;

void add(vector<string> &names, vector<double> &scores, string nameIn, double scoreIn);
int findIndex(vector<double> &scores, double scoreIn);

int main()
{
	unsigned int numCases, numChoose;
	double basePlays, numPlays, zipfScore;
	string songName;
	vector<double> *chosenScores = new vector<double>();
	vector<string> *chosenNames = new vector<string>();

	cin >> numCases;
	cin >> numChoose;
	
	chosenScores->reserve((vector<double>::size_type) numChoose);
	chosenNames->reserve((vector<string>::size_type) numChoose);

	cin >> basePlays;
	cin >> songName;

	if (basePlays == 0)
	{
		basePlays = 1e-12;
	}

	chosenScores->push_back(1.0);
	chosenNames->push_back(songName);

	for (int i = 2; i < numCases + 1; i++)
	{
		cin >> numPlays;
		cin >> songName;

		zipfScore = basePlays / i;
		zipfScore = numPlays / zipfScore;

		if (chosenScores->size() < numChoose)
		{
			add(*chosenNames, *chosenScores, songName, zipfScore);
		}
		else if (zipfScore > chosenScores->back())
		{
			chosenScores->pop_back();
			chosenNames->pop_back();
			add(*chosenNames, *chosenScores, songName, zipfScore);
		}
	}

	for (unsigned int i = 0; i < chosenNames->size(); i++)
	{
		if (i > 0)
		{
			cout << endl;
		}
		cout << chosenNames->at(i);
	}

	return 0;
}

void add(vector<string> &names, vector<double> &scores, string nameIn, double scoreIn)
{
	unsigned int index = findIndex(scores, scoreIn);
	if (index == scores.size())
	{
		names.push_back(nameIn);
		scores.push_back(scoreIn);
	}
	else
	{
		names.insert(names.begin() + index, nameIn);
		scores.insert(scores.begin() + index, scoreIn);
	}
}

int findIndex(vector<double> &scores, double scoreIn)
{
	int index, upper = scores.size() - 1, lower = 0, range = upper - lower;

	while (upper > lower)
	{
		range = upper - lower;
		index = lower + (range / 2);
		if (scoreIn > scores.at(index))
		{
			upper = index;
		}
		else if (scoreIn <= scores.at(index))
		{
			lower = index + 1;
		}
	}

	if (scoreIn > scores.at(upper))
	{
		return upper;
	}
	else
	{
		return upper + 1;
	}
}