//Surgery
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Surgery class represents one scheduled surgery.
#include "Surgery.h"

Surgery::Surgery()
{
    //ctor
}
Surgery::Surgery(string nameIn)
{
    setName(nameIn);
}
Surgery::~Surgery()
{
    delete &patientName;
    delete &type;
}
string Surgery::getName()
{
    return patientName;
}
void Surgery::setName(string nameIn)
{
    patientName = nameIn;
}
string Surgery::getType()
{
    return type;
}
void Surgery::setType(string typeIn)
{
    type = typeIn;
}
void Surgery::print()
{
    cout <<"\r\nPatient: " << patientName;
    cout << "\r\nSurgery Type: " << type;
}
