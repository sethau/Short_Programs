//HeartSurgeon
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/13/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The HeartSurgeon class extends the Doctor class
//to include surgery scheduling.
#ifndef HEARTSURGEON_H
#define HEARTSURGEON_H

#include "Doctor.h"
#include "Surgery.h"

class HeartSurgeon : public Doctor
{
    public:
        HeartSurgeon();
        HeartSurgeon(const HeartSurgeon&);
        virtual ~HeartSurgeon();
        int getNumSurgeriesScheduled();
        void setNumSurgeriesScheduled(int);
        Surgery* getSurgerySchedule();
        void setSurgerySchedule(Surgery*);
        void getInfo();
        void displayInfo();
        void reset();
        HeartSurgeon& operator=(const HeartSurgeon&);
    private:
        int numSurgeriesScheduled;
        Surgery *surgerySchedule;
};

#endif // HEARTSURGEON_H
