//main
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/6/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: Kicks off the Chutes and Ladders application.

#include "Maze.h"
#include <string>
#include <fstream>
#include <iostream>

using namespace std;

int main()
{
    string prompt = "Please enter the desired configuration file: ",
        fileErr = "Invalid Filename. Please Try again: ", filename;
    bool valid = false;
    ifstream in;
    Maze maze;

    cout << prompt;

    while (!valid)
    {
        getline(cin, filename);
        in.open(filename.c_str());
        if (in.good())
        {
            valid = true;
        }
        else
        {
            cout << "\r\n" << fileErr;
        }
        in.close();
    }

    maze = Maze(filename);

    return 0;
}































