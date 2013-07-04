//HeartSurgeon
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The Doctor class represents a single
//Doctor, and includes a list of patients.
#ifndef DOCTOR_H
#define DOCTOR_H
#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Doctor
{
    public:
        Doctor();
        virtual ~Doctor();
        Doctor(const Doctor&);
        string getName();
        void setName(string);
        int getNumPatients();
        void setNumPatients(int);
        string* getPatientList();
        void setPatientList(string*);
        void getInfo();
        void displayInfo();
        void reset();
        Doctor& operator= (const Doctor&);
    protected:
        string name;
        int numPatients;
        string *patientList;
};

#endif // DOCTOR_H
