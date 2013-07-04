//Page
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/17/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Page class stores data and functionality
//related to page-viewing. Messages and tweets are stored and accessed
//through an instance of the Page class via the Aubiebook class.
//Page is used by the Aubiebook class.

#include "Page.h"

//create constants
const string PRE = "<", POST = ">";
const int DEFAULT_LIM = 3;
const int DEFAULT_TIME = -1;

struct Page::NextMessage
{
    int time;
    string name, message;
};
//displays either the wall page or the home page for the specified user
void Page::displayPage(User& user, string pageType)
{
    ifstream timeIn;
    string welcome, prompt = "\r\n\n\t\tView all messages? (y/n): ",
        error = "Invalid option. Please choose 'y' or 'n'.", choice;
    bool valid = false;
    int prevTime;

    timeIn.open("timestamp.txt");
    timeIn >> prevTime;
    timeIn.close();

    //set welcome message text
    welcome = "\r\n\n=====================================================";
    welcome += "\r\n              " + user.getName() + "'s " + pageType + " Page";
    welcome += "\r\n=====================================================";

    //print welcome message
    cout << welcome;

    //Initialize message display counter to zero
    messageCount = 0;

    //print up to DEFAULT_LIM messages
    prevTime = printMessages(user, pageType, DEFAULT_LIM, prevTime);

    //if more messages exist, print prompt for
    //printing remaining messages
    if (messageCount == DEFAULT_LIM
        && getNext(user, pageType, prevTime).time != DEFAULT_TIME)
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
            printMessages(user, pageType, -1, prevTime);
        }
    }
}
//adds a message to messageBuffer
void Page::addMessage(string username)
{
    ifstream timeIn;
    ofstream timeOut, out;
    string prompt = "\r\n\n\t\tPlease enter message:\r\n",
        message = "", temp, filename = username + ".txt";
    int time;

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

    timeIn.open("timestamp.txt");
    timeIn >> time;
    timeIn.close();

    loadMessages(username + ".txt");

    //Store username and message in front of messageBuffer with appropriate formatting.
    messageBuffer = POST + message + messageBuffer;

    out.open(filename.c_str());
    out << PRE << time << messageBuffer;
    out.close();

    timeOut.open("timestamp.txt");
    timeOut << ++time;
    timeOut.close();
}
void Page::tweet(string username)
{
    ifstream timeIn, in;
    ofstream timeOut, out;
    string prompt = "\r\n\n\t\tPlease enter tweet:\r\n",
        tweet = "", temp, filename = "tweet.txt";
    int time;

    cout << prompt;

    //read in lines until '$' is read on separate line
    do
    {
        getline(cin, temp);
        if (temp.compare("$") != 0)
        {
            tweet += temp + "\n";
        }
    } while (temp.compare("$") != 0);

    timeIn.open("timestamp.txt");
    timeIn >> time;
    timeIn.close();

    //Store username and message in front of tweet.txt with appropriate formatting.
    in.open(filename.c_str());
    temp = "";
    while (in.good())
    {
        getline(in, temp);
        temp += "\n";
    }

    in.close();

    loadMessages("tweet.txt");

    //Store username and message in front of messageBuffer with appropriate formatting.
    messageBuffer = POST + tweet + messageBuffer;

    out.open(filename.c_str());
    out << PRE << time << POST << PRE << username << messageBuffer;
    out.close();

    timeOut.open("timestamp.txt");
    timeOut << ++time;
    timeOut.close();
}
//prints messages up until 'limit' messages have been displayed
int Page::printMessages(User& user, string pageType, int limit, int prevTime)
{
    NextMessage nextStruct;
    string temp;
    bool valid;

    cout << "\r\n\n";

    //Print out all usernames and corresponding messages.
    for (int i = 0; i != limit && prevTime != DEFAULT_TIME; i++)
    {
        nextStruct = getNext(user, pageType, prevTime);
        if (nextStruct.time != DEFAULT_TIME)
        {
            printStruct(nextStruct, pageType);
            messageCount++;
        }
        prevTime = nextStruct.time;
    }

    return prevTime;
}
void Page::loadMessages(string filename)
{
    ifstream in;
    string temp = "";

    messageBuffer = "";

    in.open(filename.c_str());
    while (in.good())
    {
        getline(in, temp);
        messageBuffer += temp + "\n";
    }

    in.close();
}
Page::NextMessage Page::getNext(User& user, string type, int prevTime)
{
    ifstream in;
    vector<string> friends = user.getFriends();
    NextMessage nextStruct;
    stringstream ss;
    string temp, filename, name;
    int time, dummy;
    bool validName;

    nextStruct.time = DEFAULT_TIME;
    nextStruct.name = "";
    nextStruct.message = "";

    if (type.compare("home") == 0)
    {
        for (int i = 0; i < friends.size(); i++)
        {
            filename = friends.at(i) + ".txt";
            in.open(filename.c_str());

            if (in.good())
            {
                getline(in, temp, '<');
            }

            if (in.peek() != ifstream::traits_type::eof())
            {
                do
                {
                    getline(in, temp, '>');
                    ss.clear();
                    ss << temp;
                    ss >> time;
                    getline(in, temp, '<');

                    if (time > nextStruct.time && time < prevTime)
                    {
                        nextStruct.time = time;
                        nextStruct.message = temp;
                        nextStruct.name = friends.at(i);
                    }
                } while (time >= prevTime && in.good());
            }

            in.close();
        }

        filename = "tweet.txt";
        in.open(filename.c_str());

        if (in.good())
        {
            getline(in, temp, '<');
        }

        if (in.peek() != ifstream::traits_type::eof())
        {
            do
            {
                getline(in, temp, '>');
                ss >> dummy;
                ss.clear();
                ss << temp;
                getline(in, name, '>');
                name = name.substr(1);
                getline(in, temp, '<');
                ss >> time;
                if (time > nextStruct.time && time < prevTime)
                {
                    nextStruct.time = time;
                    nextStruct.message = temp;
                    nextStruct.name = name;
                }
            } while (time >= prevTime && in.good());
        }

        in.close();
    }
    else if (type.compare("wall") == 0)
    {
        filename = user.getName() + ".txt";
        in.open(filename.c_str());

        if (in.good())
        {
            getline(in, temp, '<');
        }

        if (in.peek() != ifstream::traits_type::eof())
        {
            do
            {
                ss.clear();
                getline(in, temp, '>');
                ss << temp;
                ss >> time;
                getline(in, temp, '<');

                if (time > nextStruct.time && time < prevTime)
                {
                    nextStruct.time = time;
                    nextStruct.message = temp;
                    nextStruct.name = user.getName();
                }
            } while (time >= prevTime && in.good());
        }

        in.close();

        filename = "tweet.txt";
        in.open(filename.c_str());

        if (in.good())
        {
            getline(in, temp, '<');
        }

        if (in.peek() != ifstream::traits_type::eof())
        {
            do
            {
                getline(in, temp, '>');
                ss >> dummy;
                ss.clear();
                ss << temp;
                getline(in, name, '>');
                name = name.substr(1);
                getline(in, temp, '<');
                validName = false;
                if (user.getName().compare(name) == 0)
                {
                    ss >> time;
                    if (time > nextStruct.time && time < prevTime)
                    {
                        nextStruct.time = time;
                        nextStruct.message = temp;
                        nextStruct.name = name;
                    }
                    validName = true;
                }
            } while ((time >= prevTime || !validName) && in.good());
        }

        in.close();
    }
    return nextStruct;
}
void Page::printStruct(NextMessage next, string pageType)
{
    if (next.time != DEFAULT_TIME)
    {
        if (pageType.compare("wall") == 0)
        {
            cout << "\r\n" << next.message << "\r\n";
        }
        else
        {
            cout << "\r\n" << next.name << ":\r\n~ ";
            cout << next.message << "\r\n";
        }
    }
}
