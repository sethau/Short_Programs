//Page (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 9/23/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Page class stores data and functionality
//related to page-viewing. The messageBuffer string is stored
//within an instance of the Page class via the Aubiebook class.
//Page is used by the Aubiebook class.

#include "User.h"
#include <string>

using namespace std;

class Page
{
    public:
        void displayPage(User&, string);
        void addMessage(string);
    private:
        string messageBuffer;
        void printMessages(User&, string, int);
};
