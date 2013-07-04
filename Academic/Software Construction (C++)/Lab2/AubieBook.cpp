//AubieBook
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

#include "AubieBook.h"
#include <iostream>
#include <string>

//kicks off the menu display and option selection sequence
void AubieBook::run()
{
    currentUser = User();

    string welcome;

    welcome = "\r\n\n=====================================================";
    welcome += "\r\n              Welcome to AubieBook!";
    welcome += "\r\n=====================================================";
    welcome += "\r\n                  _______\n";
    welcome += "               (o)=======(o)\n";
    welcome += "              /= ~      ~ =\\\n";
    welcome += "              |  (@)| |(@)  |\n";
    welcome += "              |==== / \\ ====|\n";
    welcome += "              ~~~~: _*_ :~~~~\n";
    welcome += "               \\====(_)====/\n";
    welcome += "                \\_________/         __\n";
    welcome += "              __(_________)__      |==|\n";
    welcome += "             /               \\     |==|\n";
    welcome += "            /                 \\    /==/\n";
    welcome += "           /__/|   AUBIE   |\\__\\  /==/\n";
    welcome += "          /==/ |           | \\==\\|==|\n";

    cout << welcome;

    //check for needed files
    createFiles();

    //log in/create new user
    createUser();
}
//displays the menu and performs selected option
void AubieBook::displayMenu()
{
    string menuOptions, prompt, inval, sOpt, dummy;
    char option;
    bool valid = false;

    menuOptions = "\r\n\n";
    menuOptions += "Add Friend (f), ";
    menuOptions += "Post (p), ";
    menuOptions += "Tweet (t), ";
    menuOptions += "Wall (w), ";
    menuOptions += "Home (h), ";
    menuOptions += "Quit (q)\r\n";

    prompt = "Please choose an option: ";

    inval = "\r\n\n\t\tPlease enter a valid option\r\n\n";

    //prompt until a valid option is selected
    while (!valid)
    {
        cout << menuOptions;
        cout << prompt;
        cin >> sOpt;
        //clear rest of line, if more than one word was entered
        getline(cin, dummy);

        //check for potentially invalid input
        if (sOpt.length() == 1)
        {
            option = sOpt.at(0);
            switch (option)
            {
                case 'F':
                case 'f':
                    addFriend();
                    valid = true;
                    break;
                case 'P':
                case 'p':
                    postMessage();
                    valid = true;
                    break;
                case 'T':
                case 't':
                    tweet();
                    valid = true;
                    break;
                case 'W':
                case 'w':
                    displayWall();
                    valid = true;
                    break;
                case 'H':
                case 'h':
                    displayHome();
                    valid = true;
                    break;
                case 'Q':
                case 'q':
                    quitApp();
                    valid = true;
                    break;
                default:
                    cout << inval;
                    break;
            }
        }
        else cout << inval;
    }
}
//creates a new user who becomes the new current user
void AubieBook::createUser()
{
    string name, prompt = "\r\n\n\t\tPlease enter user name: ",
            formErr = "\r\n\n\t\tUsername must not contain any spaces and be alphanumeric\r\n\n",
            welcome;
    bool valid = false;
    User user;

    //prompt until a new user name is entered
    while (!valid)
    {
        cout << prompt;
        cin >> name;

        if (name.length() > 0
        && name.find(" ") == string::npos)
        {
            currentUser = User(name);

            valid = true;
        }
        else
        {
            cout << formErr;
        }
    }

    welcome = "\r\n\n=====================================================";
    welcome += "\r\n              Welcome, " + name + "!";
    welcome += "\r\n=====================================================";

    cout << welcome;

    //return to menu
    displayMenu();
}
//posts a message
void AubieBook::postMessage()
{
    page.addMessage(currentUser.getName());

    //return to menu
    displayMenu();
}
//tweet a message
void AubieBook::tweet()
{
    page.tweet(currentUser.getName());

    //return to menu
    displayMenu();
}
//display only the current user's posted messages
void AubieBook::displayWall()
{
    page.displayPage(currentUser, "wall");

    //return to menu
    displayMenu();
}
//displays only the posted messages of the current user's friends
void AubieBook::displayHome()
{
    page.displayPage(currentUser, "home");

    //return to menu
    displayMenu();
}
//adds another user to the current user's friends list
void AubieBook::addFriend()
{
    string prompt = "\r\n\n\t\tPlease enter friend user name: ",
        error = "\r\n\n\t\tNo such user found.",
        sameUserErr = "\r\n\n\t\tThat's you! Add someone else.",
        friendErr = " is already your friend.", name;

    cout << prompt;
    cin >> name;

    //ensure that the chosen user has been created
    if (findUser(name))
    {
        //ensure that the chosen user is not the current user
        if (name.compare(currentUser.getName()) != 0)
        {
            if (currentUser.isFriend(name))
            {
                cout << "\r\n\n\t\t" << name << friendErr;
            }
            else
            {
                currentUser.addFriend(name);
            }
        }
        else
        {
            cout << sameUserErr;
        }
    }
    else
    {
        cout << error;
    }


    //return to menu
    displayMenu();
}
//quits AubieBook
void AubieBook::quitApp()
{
    cout << "Good Bye!";
}
//creates tweet and timestamp files if not found
void AubieBook::createFiles()
{
    ofstream out;
    ifstream in;

    //iff tweet.txt does not exist, create new file
    out.open("tweet.txt", ios::app);
    out.close();

    in.open("timestamp.txt");

    //iff timestamp.txt does not exist, create new file and initialize to 0
    if (!in.is_open())
    {
        out.open("timestamp.txt", ios::out);
        out << "0";
        out.close();
    }
    else
    {
        in.close();
    }
}
//searches files for specified user
bool AubieBook::findUser(string name)
{
    string filename = name + ".txt";
    bool found;

    ifstream file(filename.c_str());

    //iff user file is found, set found to true
    found = file.is_open();

    return found;
}
