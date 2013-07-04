//User
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 9/23/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The User class represents a single
//user profile on Aubiebook. It stores the user's
//user name and friends list, as well as functions
//to interact with this data. The User class is
//used by both Aubiebook and Page.

#include "User.h"

string name;
vector<string> friendsList;

//parameterless constructor
User::User()
{
}
//parametered constructor that sets name
User::User(string nameIn)
{
    name = nameIn;
    //add self to friends
    friendsList.push_back(nameIn);
}
//adds a friend to friend list of user
void User::addFriend(string nameIn)//
{
    //add friend IFF friend is not already in friendsList
    if (!isFriend(nameIn))
    friendsList.push_back(nameIn);
}
//check friendsList for existence of nameIn
bool User::isFriend(string nameIn)
{
    int i;

    for (i = 0; i < friendsList.size(); i++)
    {
        //check each element against nameIn
        if (friendsList.at(i).compare(nameIn) == 0)
        {
            return true;
        }
    }

    return false;
}
//getter for name
string User::getName()
{
    return name;
}
