//User Text Message Handler
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 9/3/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: Prompts user(s) for usernames and messages, and
//displays all usernames and corresponding messages after all data
//has been entered by users.

#include <iostream>
#include <string>
#include <queue>
using namespace std;

//create constants for buffer use
const string PRE = "<", POST = ">";

int main () {
	string messageBuffer = "";
	string username = "", message = "";
	string temp;
	//These queues store the lengths of each username and message in order
	//to remove the necessity of searching for buffer characters.
	queue<int> nameLength, messageLength;
	//This index variable acts as a pointer for the message printer.
	int currentIndex;
	
	//Print welcome message.
	cout << "===========================================================" << endl;
	cout << "              Welcome to the Message System!               " << endl;
	cout << "===========================================================" << endl << endl;
	
	//Get username and message, and repeat until there are no more users.
	do
	{
		//Prompt for username.
		cout << "Enter user name: ";
		getline(cin, username);
		
		//Prompt for message.
		cout << "Enter the message: ";
		//Read message lines from standard input until end delimiter character ('$') is read.
		message.clear();
		do
		{
			getline(cin, temp);
			if (temp.compare("$") != 0)
			{
				message += temp + "\n";
			}
		} while (temp.compare("$") != 0);
		
		//Store username and message in messageBuffer with appropriate formatting.
		messageBuffer += PRE + username + POST + message;
		
		//Push length information onto queues.
		nameLength.push(username.size());
		messageLength.push(message.size());
		
		//Prompt for next user (if any).
		cout << "\nAny more users? ";
		getline(cin, temp);
		cout << endl;
		
	} while (temp.compare("yes") == 0);
	
	//Print message announcement.
	cout << "The current messages are:" << endl << endl;
	
	//Initialize index pointer to beginning of first username.
	currentIndex = 1;
	//Print out all usernames and corresponding messages.
	while (!nameLength.empty() && currentIndex < messageBuffer.size())
	{
		//Read and print next username and increment index pointer to beginning of corresponding message.
		temp = messageBuffer.substr(currentIndex, nameLength.front());
		currentIndex += nameLength.front() + 1;
		nameLength.pop();
		cout << temp + " ~ ";
		
		//Read and print corresponding message and increment index pointer to beginning of next username.
		temp = messageBuffer.substr(currentIndex, messageLength.front());
		currentIndex += messageLength.front() + 1;
		messageLength.pop();
		cout << temp << endl;
	}
	
	return 0;
}
