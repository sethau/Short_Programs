//Maze
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/6/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Maze class contains all high-level
//organization and gameplay functionality in
//the Chutes and Ladders application.

#ifndef MAZE_H
#define MAZE_H

#include <stdlib.h>
#include <vector>
#include <string>
#include <iostream>
#include <fstream>
#include "Node.h"

using namespace std;

class Maze
{
    public:
        Maze();
        Maze(string);
    private:
        void initArray();
        void createNode(string[]);
        void playGame();
        bool move(int);
        void checkLadChute();
        void victory();
        void printOptions();
        Node* getNode(string);
        void placeNode(Node*);
        Node *currentNode;
        Node mazeArray[8][6];
        vector<string> history;
        string name;
};

#endif // MAZE_H
