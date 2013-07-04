//Surgery
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Surgery class represents one scheduled surgery.
#ifndef SURGERY_H
#define SURGERY_H

#include <string>
#include <iostream>

using namespace std;

class Surgery
{
    public:
        Surgery();
        Surgery(string);
        virtual ~Surgery();
        string getName();
        void setName(string);
        string getType();
        void setType(string);
        void print();
    private:
        string patientName;
        string type;
};

#endif // SURGERY_H
