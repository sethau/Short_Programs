//AubieBook
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

#include "AubieBook.h"
#include <iostream>
#include <string>

//kicks off the menu display and option selection sequence
void AubieBook::run()
{
    currentUser = User();
    loggedIn = false;

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

    //display menu for first time
    displayMenu();
}
//displays the menu and performs selected option
void AubieBook::displayMenu()
{
    string menuOptions, prompt, inval, sOpt, dummy;
    char option;
    bool valid = false;

    menuOptions = "\r\n\n";
    menuOptions += "1) Create a new User\r\n";
    menuOptions += "2) Post a message\r\n";
    menuOptions += "3) Display Wall Page\r\n";
    menuOptions += "4) Display Home Page\r\n";
    menuOptions += "5) Add a Friend\r\n";
    menuOptions += "6) Switch User\r\n";
    menuOptions += "7) Quit AubieBook";

    prompt = "\r\n\n\t\tPlease choose an option: ";

    inval = "\r\n\n\t\tPlease enter an integer 0<x<8\r\n\n";

    //prompt until a valid option is selected
    while (!valid)
    {
        cout << menuOptions;
        cout << prompt;
        cin >> sOpt;
        //clear rest of line, if more than one word was entered
        getline(cin, dummy);

        //check for potentially invalid input
        if (sOpt.length() == 1 && isdigit(sOpt.at(0)))
        {
            option = sOpt.at(0);
            switch (option)
            {
                case '1':
                    createUser();
                    valid = true;
                    break;
                case '2':
                    postMessage();
                    valid = true;
                    break;
                case '3':
                    displayWall();
                    valid = true;
                    break;
                case '4':
                    displayHome();
                    valid = true;
                    break;
                case '5':
                    addFriend();
                    valid = true;
                    break;
                case '6':
                    switchUser();
                    valid = true;
                    break;
                case '7':
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
            error = "\r\n\n\t\tUser already created.",
            //formErr = "\r\n\n\t\tUser name must be at least one character and contain no whitespace.",
            welcome;
    bool valid = false;
    User user;

    //prompt until a new user name is entered
    while (!valid)
    {
        cout << prompt;
        cin >> name;

        if (findUser(name) == -1)
        {
            //if (name.length() > 0
            //&& name.find(" ") == string::npos)
            //{
            user = User(name);

            validUsers.push_back(user);

            currentUser = user;

            loggedIn = true;

            valid = true;
            //}
            //else
            //{
            //    cout << formErr;
            //}
        }
        else
        {
            cout << error;
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
    string error = "\r\n\n\t\tPlease log in first.";

    //ensure that a user has logged in
    if (loggedIn)
    {
        page.addMessage(currentUser.getName());
    }
    else
    {
        cout << error;
    }

    //return to menu
    displayMenu();
}
//display only the current user's posted messages
void AubieBook::displayWall()
{
    string error = "\r\n\n\t\tPlease log in first.";

    //ensure that a user has logged in
    if (loggedIn)
    {
        page.displayPage(currentUser, "Wall");
    }
    else
    {
        cout << error;
    }

    //return to menu
    displayMenu();
}
//displays only the posted messages of the current user's friends
void AubieBook::displayHome()
{
    string error = "\r\n\n\t\tPlease log in first.";

    //ensure that a user has logged in
    if (loggedIn)
    {
        page.displayPage(currentUser, "Home");
    }
    else
    {
        cout << error;
    }

    //return to menu
    displayMenu();
}
//adds another user to the current user's friends list
void AubieBook::addFriend()
{
    string prompt = "\r\n\n\t\tPlease enter friend user name: ",
        error = "\r\n\n\t\tNo such user found.",
        logInError = "\r\n\n\t\tPlease log in first.",
        userNumErr = "\r\n\n\t\tNo other users created.",
        sameUserErr = "\r\n\n\t\tThat's you! Add someone else.", name;
    bool valid  = false;

    //ensure that a user has logged in
    if (loggedIn)
    {
        //ensure that there exists at least one other user
        if (validUsers.size() > 1)
        {
            while (!valid)
            {
                cout << prompt;
                cin >> name;

                //ensure that the chosen user has been created
                if (findUser(name) > -1)
                {
                    //ensure that the chosen user is not the current user
                    if (name.compare(currentUser.getName()) != 0)
                    {
                        currentUser.addFriend(name);
                        valid = true;
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
            }
        }
        else
        {
            cout << userNumErr;
        }
    }
    else
    {
        cout << logInError;
    }

    //return to menu
    displayMenu();
}
//switches current user to a different user
void AubieBook::switchUser()
{
    string prompt = "\r\n\n\t\tPlease enter user name: ",
        error = "\r\n\n\t\tNo such user found.",
        logInError = "\r\n\n\t\tPlease log in first.",
        userNumErr = "\r\n\n\t\tNo other users created.",
        sameUserErr = "\r\n\n\t\tThat's you! Add someone else.",
        name, welcome;
    bool valid  = false;
    int index;

    //ensure that a user has logged in
    if (loggedIn)
    {
        //ensure that there exists at least one other user
        if (validUsers.size() > 1)
        {
            while (!valid)
            {
                cout << prompt;
                cin >> name;

                //ensure that the chosen user has been created
                index = findUser(name);
                if (index > -1)
                {
                    //ensure that the chosen user is not the current user
                    if (name.compare(currentUser.getName()) != 0)
                    {
                        currentUser = validUsers.at(index);
                        valid = true;
                    }
                }
                else
                {
                    cout << error;
                }
            }

            welcome = "\r\n\n=====================================================";
            welcome += "\r\n              Welcome back, " + name + "!";
            welcome += "\r\n=====================================================";

            //print welcome back message
            cout << welcome;
        }
        else
        {
            cout << userNumErr;
        }
    }
    else
    {
        cout << logInError;
    }

    //return to menu
    displayMenu();
}
//quits AubieBook
void AubieBook::quitApp()
{
    cout << "Good Bye!";
}
//searches validUsers for a specific user
//and returns the index if found
//else return -1
int AubieBook::findUser(string name)
{
    int i;

    for (i = 0; i < validUsers.size(); i++)
    {
        //check each user's user name against name
        if (validUsers.at(i).getName().compare(name) == 0)
        {
            return i;
        }
    }

    return -1;
}
