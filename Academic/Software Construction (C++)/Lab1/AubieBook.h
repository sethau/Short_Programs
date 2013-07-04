//AubieBook (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 9/23/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Aubiebook class holds all system-level
//functionality in the Aubiebook application. It contains
//a main()method that will be run as the primary driver
//function for Aubiebook. It uses the User class and the
//Page class to storemessage data and perform object-specific functions.

#include "User.h"
#include "Page.h"

using namespace std;

class AubieBook
{
    public:
        void run();
    private:
        User currentUser;
        Page page;
        vector<User> validUsers;
        bool loggedIn;

        void displayMenu();
        void createUser();
        void postMessage();
        void displayWall();
        void displayHome();
        void addFriend();
        void switchUser();
        void quitApp();
        int findUser(string);
};
