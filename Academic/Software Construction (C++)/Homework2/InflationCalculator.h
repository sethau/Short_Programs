//InflationCalculator.h
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/8/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: This is the header file for InflationCalculator.
#ifndef INFLATIONCALCULATOR_H
#define INFLATIONCALCULATOR_H
#include <iostream>
#include <string>

using namespace std;

class InflationCalculator
{
    public:
        void getInfo();
    private:
        double calculateInflation(double, double);
};

#endif // INFLATIONCALCULATOR_H
