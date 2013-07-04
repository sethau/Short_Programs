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
using namespace std;

//create constants for buffer use
const string PRE = "<", POST = ">";

int main () {
    string messageBuffer = "";
    string username = "", message = "";
    string temp;
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

            //Prompt for next user (if any).
            cout << "\nAny more users? ";
            getline(cin, temp);
            cout << endl;

    } while (temp.compare("yes") == 0);

    //Print message announcement.
    cout << "The current messages are:" << endl << endl;

    //Initialize index pointer to beginning of first username.
    currentIndex = 0;
    messageBuffer = messageBuffer.substr(1, string::npos);
    //Print out all usernames and corresponding messages.
    while (currentIndex < messageBuffer.size())
    {
        //Read and print next username and increment index pointer to beginning of corresponding message.
        temp = messageBuffer.substr(currentIndex, messageBuffer.find(">"));
        currentIndex += temp.size() + 1;
        cout << temp + " ~ ";

        //Read and print corresponding message and increment index pointer to beginning of next username.
        temp = messageBuffer.substr(currentIndex, messageBuffer.find("<") - currentIndex);
        currentIndex += temp.size() + 1;
        cout << temp << endl;
    }

    return 0;
}
