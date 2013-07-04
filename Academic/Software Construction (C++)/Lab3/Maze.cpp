//Maze
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/6/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Maze class contains all high-level
//organization and gameplay functionality in
//the Chutes and Ladders application.

#include "Maze.h"

const int NORTH = 0;
const int EAST = 1;
const int SOUTH = 2;
const int WEST = 3;

const int NONE = 0;
const int LADDER = 1;
const int CHUTE = 2;

const int A = 0;
const int B = 1;
const int C = 2;
const int D = 3;
const int E = 4;
const int F = 5;
const int G = 6;
const int H = 7;

const string START = "A1";
const string FINISH = "H6";

Maze::Maze()
{
    //ctor
}
Maze::Maze(string fileIn)
{
    string fileErr = "\r\n\nInvalid File", line[6];
    ifstream in(fileIn.c_str());
    int count = 0;

    initArray();

    while (in.good() && count < 48)
    {
        in >> line[0];
        in >> line[1];
        in >> line[2];
        in >> line[3];
        in >> line[4];
        in >> line[5];

        createNode(line);
        count++;
    }

    in.close();

    playGame();
}
void Maze::createNode(string data[])
{
    Node *newNode;

    newNode = getNode(data[0]);

    for (int direction = NORTH; direction <= WEST; direction++)
    {
        if (data[direction + 1].compare("*") != 0)
        {
            newNode->attachNewNode(getNode(data[direction + 1]), direction);
        }
    }

    if (data[5].compare("*") != 0)
    {
        newNode->attachLadderChuteNode(getNode(data[5]));
    }

    placeNode(newNode);
}
void Maze::playGame()
{
    char opt;
    bool valid = false;
    string prompt = "Which option would you like to take? ",
        error = "\r\nInvalid direction.";
    currentNode = getNode(START);
    name = currentNode->getNodeName();
    history.push_back(currentNode->getNodeName());

    while (!valid || name.compare(FINISH) != 0)
    {
        checkLadChute();
        if (valid)
        {
            history.push_back(currentNode->getNodeName());
        }
        printOptions();
        cout << prompt;
        if (cin >> opt)
        {
            switch (opt)
            {
                case 'N':
                case 'n':
                    valid = move(NORTH);
                    break;
                case 'E':
                case 'e':
                    valid = move(EAST);
                    break;
                case 'S':
                case 's':
                    valid = move(SOUTH);
                    break;
                case 'W':
                case 'w':
                    valid = move(WEST);
                    break;
                default:
                    break;
            }
        }

        if (!valid)
        {
            cout << error;
        }
    }


    if (name.compare(FINISH) == 0)
    {
        victory();
    }
}
bool Maze::move(int direction)
{
    if (currentNode->hasNode(direction))
    {
        currentNode = currentNode->getAttachedNode(direction);
        name = currentNode->getNodeName();
        return true;
    }
    else
    {
        return false;
    }
}
void Maze::checkLadChute()
{
    if (currentNode->hasLadChute())
    {
        cout << "\r\n\nYou have taken a secret passageway to room ";
        cout << currentNode->getLadderChuteNode()->getNodeName();
        cout << "!\r\n";

        currentNode = currentNode->getLadderChuteNode();
    }
}
void Maze::victory()
{
    history.push_back(currentNode->getNodeName());

    cout << "\r\n\nCongratulations! You reached the end of the maze!";
    cout << "\r\nYou visited the following rooms:";

    for (vector<string>::iterator itr = history.begin(); itr < history.end(); itr++)
    {
        cout << " " << *itr;
    }

    cout << "\r\nIt took you " << history.size() - 1 << " moves to reach the end.\r\nThanks for playing!!!";
}
Node* Maze::getNode(string name)
{
    switch (name.at(0))
    {
        case 'A':
            return &mazeArray[A][atoi(name.substr(1).c_str()) - 1];
        case 'B':
            return &mazeArray[B][atoi(name.substr(1).c_str()) - 1];
        case 'C':
            return &mazeArray[C][atoi(name.substr(1).c_str()) - 1];
        case 'D':
            return &mazeArray[D][atoi(name.substr(1).c_str()) - 1];
        case 'E':
            return &mazeArray[E][atoi(name.substr(1).c_str()) - 1];
        case 'F':
            return &mazeArray[F][atoi(name.substr(1).c_str()) - 1];
        case 'G':
            return &mazeArray[G][atoi(name.substr(1).c_str()) - 1];
        case 'H':
            return &mazeArray[H][atoi(name.substr(1).c_str()) - 1];
        default:
            return NULL;
    }
}
void Maze::placeNode(Node *node)
{
    if (node != NULL)
    {
        string name = node->getNodeName();

        switch (name.at(0))
        {
            case 'A':
                mazeArray[A][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'B':
                mazeArray[B][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'C':
                mazeArray[C][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'D':
                mazeArray[D][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'E':
                mazeArray[E][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'F':
                mazeArray[F][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'G':
                mazeArray[G][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
            case 'H':
                mazeArray[H][atoi(name.substr(1).c_str()) - 1] = *node;
                return;
        }
    }
}
void Maze::initArray()
{
    int row, col;

    for (row = A; row <= H; row++)
    {
        for (col = 0; col < 6; col++)
        {
            mazeArray[row][col] = Node(row, col + 1);
        }
    }
}
void Maze::printOptions()
{
    cout << "\r\n\nYou are currently in room " << currentNode->getNodeName() << ".";
    cout << "\r\nYou can travel";
    if (currentNode->hasNode(NORTH))
    {
        cout << " North";
    }
    if (currentNode->hasNode(EAST))
    {
        cout << " East";
    }
    if (currentNode->hasNode(SOUTH))
    {
        cout << " South";
    }
    if (currentNode->hasNode(WEST))
    {
        cout << " West";
    }
    cout << ". ";
}
