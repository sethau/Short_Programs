//User
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
    string file = nameIn + "_friends.txt", line;
    ifstream in;
    ofstream out;

    out.open(file.c_str(), ios::app);
    out.close();

    in.open(file.c_str());

    if (in.is_open())
    {
        while(in.good())
        {
            getline(in, line);
            if (line.size() > 0)
            {
                friendsList.push_back(line);
            }
        }
    }
    name = nameIn;
    //add self to friends
    friendsList.push_back(nameIn);

    file = nameIn + ".txt";
    out.open(file.c_str(), ios::app);
    out.close();
}
//adds a friend to friend list of user
void User::addFriend(string nameIn)//
{
    ofstream out;
    string filename = name + "_friends.txt";

    //add friend IFF friend is not already in friendsList
    if (!isFriend(nameIn))
    {
        friendsList.push_back(nameIn);
        out.open(filename.c_str(), ios::app);
        if (friendsList.size() > 2)
        {
            out << out << "\n" << nameIn;
        }
        else
        {
            nameIn : out << nameIn;
        }
        //friendsList.size() > 1 ? out << "\n" << nameIn : out << nameIn;
        out.close();
    }
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
vector<string> User::getFriends()
{
    return friendsList;
}
