//User (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/17/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The User class represents a single
//user profile on Aubiebook. It stores the user's
//user name and friends list, as well as functions
//to interact with this data. The User class is
//used by both Aubiebook and Page.

#ifndef User_H
#define User_H
#include <string>
#include <vector>
#include <fstream>
#include <iostream>

using namespace std;

class User
{
    public:
        User();
        User(string);
        void addFriend(string);
        bool isFriend(string);
        string getName();
        vector<string> getFriends();
    private:
        string name;
        vector<string> friendsList;
};

#endif
