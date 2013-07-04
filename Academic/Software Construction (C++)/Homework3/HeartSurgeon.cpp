//HeartSurgeon
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The HeartSurgeon class extends the Doctor class
//to include surgery scheduling.
#include "HeartSurgeon.h"

HeartSurgeon::HeartSurgeon()
{
    Doctor::Doctor();
    surgerySchedule = new Surgery[1];
    surgerySchedule[0] = Surgery();
    numSurgeriesScheduled = 0;
}
HeartSurgeon::HeartSurgeon(const HeartSurgeon &docIn)
{
    setName(docIn.name);
    setNumPatients(docIn.numPatients);
    setPatientList(docIn.patientList);
    setNumSurgeriesScheduled(docIn.numSurgeriesScheduled);
    setSurgerySchedule(docIn.surgerySchedule);
}
HeartSurgeon& HeartSurgeon::operator= (const HeartSurgeon& docIn)
{
    setName(docIn.name);
    setNumPatients(docIn.numPatients);
    setPatientList(docIn.patientList);
    setNumSurgeriesScheduled(docIn.numSurgeriesScheduled);
    setSurgerySchedule(docIn.surgerySchedule);

    return *this;
}
HeartSurgeon::~HeartSurgeon()
{
    delete &name;
    delete &numPatients;
    delete [] patientList;
    patientList = NULL;
    delete [] surgerySchedule;
    surgerySchedule = NULL;
}
void HeartSurgeon::getInfo()
{
    vector<Surgery> surgeries;
    vector<Surgery>::iterator surItr;
    string in = "";
    int i;
    Surgery surgery;

    cout << "\r\nEnter Scheduled Surgeries, by patient name (enter '$' when finished): ";
    getline(cin, in);

    while (in.compare("$") != 0)
    {
        surgery.setName(in);

        cout << "\tEnter Surgery Type: ";
        getline(cin, in);
        surgery.setType(in);

        surgeries.push_back(surgery);
        cout << "\r\nEnter Next Patient: ";
        getline(cin, in);
    }

    numSurgeriesScheduled = surgeries.size();
    delete [] surgerySchedule;
    surgerySchedule = new Surgery[numSurgeriesScheduled];
    i = 0;
    for (surItr = surgeries.begin(); surItr < surgeries.end(); surItr++)
    {
        surgerySchedule[i] = *surItr;
        i++;
    }
}
void HeartSurgeon::displayInfo()
{
    int i;

    cout << "Patients:";
    for (i = 0; i < numPatients; i++)
    {
        cout << endl << patientList[i];
    }

    cout << "Surgeries:";
    for (i = 0; i < numSurgeriesScheduled; i++)
    {
        surgerySchedule[i].print();
    }
    cout << endl;
}
void HeartSurgeon::reset()
{
    numPatients = 0;
    delete [] patientList;
    patientList = NULL;
    numSurgeriesScheduled = 0;
    delete [] surgerySchedule;
    surgerySchedule = NULL;
}
int HeartSurgeon::getNumSurgeriesScheduled()
{
    return numSurgeriesScheduled;
}
void HeartSurgeon::setNumSurgeriesScheduled(int numIn)
{
    numSurgeriesScheduled = numIn;
}
Surgery* HeartSurgeon::getSurgerySchedule()
{
    return surgerySchedule;
}
void HeartSurgeon::setSurgerySchedule(Surgery* scheduleIn)
{
    surgerySchedule = scheduleIn;
}
