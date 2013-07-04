//main.cpp
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: This is the driver for for homework 3.
#include "Doctor.h"
#include "HeartSurgeon.h"
#include <iostream>
#include <string>
#include <stdlib.h>

//#define UNIT_TESTING

using namespace std;

int main()
{
    #ifdef UNIT_TESTING
        cout << "Unit testing!" << endl;
        Doctor doc;

        doc.setName("Doctor Bob");
        cout << "Doctor's name (Doctor Bob): " << doc.getName() << endl;

        string *patients = new string[2];
        patients[0] = "Jim";
        patients[1] = "Jane";
        doc.setPatientList(patients);
        doc.setNumPatients(2);
        cout << "Patient Number (2): " << doc.getNumPatients() << endl;
        cout << "Patients (Jim, Jane):\r\n";
        doc.displayInfo();

        doc.reset();
        cout << "RESET\r\nPatient Number (0): " << doc.getNumPatients() << endl;
        cout << "Patients (): ";
        doc.displayInfo();

        HeartSurgeon hDoc;

        hDoc.setName("HeartSurgeon Bob");
        cout << "HeartSurgeon's name (HeartSurgeon Bob): " << hDoc.getName() << endl;

        string *Hpatients = new string[2];
        Hpatients[0] = "Jim";
        Hpatients[1] = "Jane";
        hDoc.setPatientList(Hpatients);
        hDoc.setNumPatients(2);

        Surgery *surgeries =  new Surgery[1], surgery;
        surgery.setName("Jim");
        surgery.setType("Heart Translpant");
        surgeries[0] = surgery;
        hDoc.setSurgerySchedule(surgeries);
        hDoc.setNumSurgeriesScheduled(1);

        cout << "Patient Number (2): " << hDoc.getNumPatients() << endl;
        cout << "Patients/Surgeries (Jim, Jane)(Jim - Heart Transplant):\r\n";
        hDoc.displayInfo();

        hDoc.reset();
        cout << "RESET\r\nPatient Number (0): " << hDoc.getNumPatients() << endl;
        cout << "Patients/Surgeries ()(): ";
        hDoc.displayInfo();
    #else
        Doctor doc;
        doc.getInfo();
        doc.displayInfo();

        HeartSurgeon hDoc;
        hDoc.getInfo();
        hDoc.displayInfo();
    #endif

    exit(EXIT_SUCCESS);
    return 0;
}
