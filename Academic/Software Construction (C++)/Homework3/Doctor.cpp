//HeartSurgeon
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Doctor class represents a single
//Doctor, and includes a list of patients.
#include "Doctor.h"

Doctor::Doctor()
{
    patientList = new string[1];
    numPatients = 0;
}
Doctor::Doctor(const Doctor &docIn)
{
    setName(docIn.name);
    setNumPatients(docIn.numPatients);
    setPatientList(docIn.patientList);
}
Doctor& Doctor::operator= (const Doctor& docIn)
{
    setName(docIn.name);
    setNumPatients(docIn.numPatients);
    setPatientList(docIn.patientList);

    return *this;
}
Doctor::~Doctor()
{
    delete &name;
    delete &numPatients;
    delete [] patientList;
    patientList = NULL;
}
void Doctor::getInfo()
{
    vector<string> patients;
    vector<string>::iterator itr;
    string in = "";
    int i;

    cout << "\r\nEnter Doctor name: ";
    getline(cin, name);

    cout << "\r\nEnter Patient Names, one at a time (enter '$' when finished): ";
    getline(cin, in);

    while (in.compare("$") != 0)
    {
        patients.push_back(in);
        getline(cin, in);
    }

    numPatients = patients.size();
    delete [] patientList;
    patientList = new string[numPatients];
    i = 0;
    for (itr = patients.begin(); itr < patients.end(); itr++)
    {
        patientList[i] = *itr;
        i++;
    }
}
void Doctor::displayInfo()
{
    cout << "Patients:";
    for (int i = 0; i < numPatients; i++)
    {
        cout << endl << patientList[i];
    }

    cout << endl;
}
void Doctor::reset()
{
    if (numPatients > 0)
    {
        numPatients = 0;
        delete [] patientList;
        patientList = NULL;
    }
}
string Doctor::getName()
{
    return name;
}
void Doctor::setName(string nameIn)
{
    name = nameIn;
}
int Doctor::getNumPatients()
{
    return numPatients;
}
void Doctor::setNumPatients(int numIn)
{
    numPatients = numIn;
}
string* Doctor::getPatientList()
{
    return patientList;
}
void Doctor::setPatientList(string* listIn)
{
    patientList = listIn;
}
