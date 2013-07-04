//Node
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/6/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Node class represents a single room
//with connections to other roomsin the Chutes and
//Ladders application.

#include "Node.h"

const int NORTH = 0;
const int EAST = 1;
const int SOUTH = 2;
const int WEST = 3;

const int NONE = 0;
const int WITHLADCHUTE = 1;

const int A = 0;
const int B = 1;
const int C = 2;
const int D = 3;
const int E = 4;
const int F = 5;
const int G = 6;
const int H = 7;

Node::Node()
{
    ladChute = NONE;

    attachedNodes[NORTH] = NULL;
    attachedNodes[EAST] = NULL;
    attachedNodes[SOUTH] = NULL;
    attachedNodes[WEST] = NULL;
}
Node::Node(string newName)
{
    setNodeName(newName);
    ladChute = NONE;

    attachedNodes[NORTH] = NULL;
    attachedNodes[EAST] = NULL;
    attachedNodes[SOUTH] = NULL;
    attachedNodes[WEST] = NULL;
}
Node::Node(int row, int col)
{
    stringstream ss;
    switch (row)
    {
        case A:
            ss << "A" << col;
            ss >> name;
            break;
        case B:
            ss << "B" << col;
            ss >> name;
            break;
        case C:
            ss << "C" << col;
            ss >> name;
            break;
        case D:
            ss << "D" << col;
            ss >> name;
            break;
        case E:
            ss << "E" << col;
            ss >> name;
            break;
        case F:
            ss << "F" << col;
            ss >> name;
            break;
        case G:
            ss << "G" << col;
            ss >> name;
            break;
        case H:
            ss << "H" << col;
            ss >> name;
            break;
    }

    ladChute = NONE;

    attachedNodes[NORTH] = NULL;
    attachedNodes[EAST] = NULL;
    attachedNodes[SOUTH] = NULL;
    attachedNodes[WEST] = NULL;
}
void Node::setNodeName(string newName)
{
    name = newName;
}
string Node::getNodeName()
{
    return name;
}
void Node::attachNewNode(Node *newNode, int direction)
{
    attachedNodes[direction] = newNode;
}
Node* Node::getAttachedNode(int direction)
{
    return attachedNodes[direction];
}
void Node::attachLadderChuteNode(Node *newNode)
{
    ladderChuteNode = newNode;
    ladChute = WITHLADCHUTE;
}
Node* Node::getLadderChuteNode()
{
    return ladderChuteNode;
}
bool Node::hasLadChute()
{
    return ladChute == WITHLADCHUTE;
}
bool Node::hasNode(int direction)
{
    return attachedNodes[direction] != NULL;
}
