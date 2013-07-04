//Page
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 9/23/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Page class stores data and functionality
//related to page-viewing. The messageBuffer string is stored
//within an instance of the Page class via the Aubiebook class.
//Page is used by the Aubiebook class.

#include "Page.h"
#include <iostream>

//create constants
const string PRE = "<", POST = ">";
const int DEFAULT_LIM = 3;

string messageBuffer;
int messageCount, currentIndex;

//displays either the wall page or the home page for the specified user
void Page::displayPage(User& user, string pageType)
{
    string welcome, prompt = "\r\n\n\t\tView all messages? (y/n): ",
        error = "Invalid option. Please choose 'y' or 'n'.", choice;
    bool valid = false;

    //set welcome message text
    welcome = "\r\n\n=====================================================";
    welcome += "\r\n              " + user.getName() + "'s " + pageType + " Page";
    welcome += "\r\n=====================================================";

    //print welcome message
    cout << welcome;

    //Initialize message display counter to zero
    messageCount = 0;
    //Initialize index pointer to beginning of first username.
    currentIndex = 1;

    //print up to DEFAULT_LIM messages
    printMessages(user, pageType, DEFAULT_LIM);

    //if more messages exist, print prompt for
    //printing remaining messages
    if (messageCount == DEFAULT_LIM
      && currentIndex < messageBuffer.size())
    {
        //prompt until user enters valid response
        while (!valid)
        {
            cout << prompt;
            cin >> choice;

            switch (choice.at(0))
            {
                //accept capital or lowercase
                case 'Y':
                case 'y':
                    valid = true;
                    choice = "y";
                    break;
                case 'N':
                case 'n':
                    valid = true;
                    break;
                default:
                    cout << error;
                    break;
            }
        }
        //if yes, print remaining messages
        if (choice.compare("y") == 0)
        {
            //pass 0 as new limit, so that the counter will
            //not stop the printing by hitting the limit
            printMessages(user, pageType, 0);
        }
    }
}
//adds a message to messageBuffer
void Page::addMessage(string username)
{
    string prompt = "\r\n\n\t\tPlease enter message:\r\n",
        message = "", temp;

    cout << prompt;

    //read in lines until '$' is read on separate line
    do
    {
        getline(cin, temp);
        if (temp.compare("$") != 0)
        {
            message += temp + "\n";
        }
    } while (temp.compare("$") != 0);

    //Store username and message in front of messageBuffer with appropriate formatting.
    messageBuffer = PRE + username + POST + message + messageBuffer;
}
//prints messages up until 'limit' messages have been displayed
void Page::printMessages(User& user, string pageType, int limit)
{
    string temp;
    bool valid;

    cout << "\r\n\r\n";

    //Print out all usernames and corresponding messages.
    while (currentIndex < messageBuffer.size()
         && messageCount != limit)
    {
      valid = false;
    //Read and print next username and increment index pointer to beginning of corresponding message.
     temp = messageBuffer.substr(currentIndex);
     temp = temp.substr(0, temp.find(">"));
     currentIndex += temp.size() + 1;
     //check username for compatibility with user and pageType
     if ((pageType.compare("Wall") == 0
         && temp.compare(user.getName()) == 0)
         || (pageType.compare("Home") == 0
         && user.isFriend(temp)))
     {
         cout << temp + " ~ ";
         valid = true;
     }

    //Read and print corresponding message and increment index pointer to beginning of next username.
     temp = messageBuffer.substr(currentIndex);
     temp = temp.substr(0, temp.find("<"));
     currentIndex += temp.size() + 1;
     //check username for compatibility with user and pageType
     if (valid)
     {
         cout << "\t" + temp << endl;
         messageCount++;
     }
    }
}
