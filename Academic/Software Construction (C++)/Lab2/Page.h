//Page (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/17/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Page class stores data and functionality
//related to page-viewing. Messages and tweets are stored and accessed
//through an instance of the Page class via the Aubiebook class.
//Page is used by the Aubiebook class.

#include "User.h"
#include <string>
#include <vector>
#include <iostream>
#include <fstream>
#include <sstream>

using namespace std;

class Page
{
    public:
        void displayPage(User&, string);
        void addMessage(string);
        void tweet(string);
    private:
        struct NextMessage;
        string messageBuffer;
        int messageCount;
        int printMessages(User&, string, int, int);
        void printStruct(NextMessage, string);
        NextMessage getNext(User&, string, int);
        void loadMessages(string);
};
