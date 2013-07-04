//Node
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/6/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Node class represents a single room
//with connections to other roomsin the Chutes and
//Ladders application.

#ifndef NODE_H
#define NODE_H

#include <string>
#include <sstream>

using namespace std;

class Node
{
    public:
        Node();
        Node(string);
        Node(int, int);
        void setNodeName(string);
        string getNodeName();
        void attachNewNode(Node*, int);
        Node* getAttachedNode(int);
        void attachLadderChuteNode(Node*);
        Node* getLadderChuteNode();
        bool hasLadChute();
        bool hasNode(int);
    private:
        string name;
        Node* attachedNodes[4];
        Node *ladderChuteNode;
        int ladChute;
};

#endif // NODE_H
