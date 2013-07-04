//AubieBook (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/17/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Aubiebook class holds all system-level
//functionality in the Aubiebook application. It contains
//a run() method that will be run as the primary driver
//function for Aubiebook. It uses the User class and the
//Page class to store/access message data and perform
//object-specific functions.

#include "User.h"
#include "Page.h"
#include <iostream>
#include <fstream>

using namespace std;

class AubieBook
{
    public:
        void run();
    private:
        User currentUser;
        Page page;

        void displayMenu();
        void createUser();
        void postMessage();
        void tweet();
        void displayWall();
        void displayHome();
        void addFriend();
        void quitApp();
        void createFiles();
        bool findUser(string);
};
