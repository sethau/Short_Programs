//main.cpp
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/8/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: This is the driver file for HW2.
//To compile and run, use the following commands:
//g++ -o HW2 std0003_hw2.cpp InflationCalculator.h InflationCalculator.cpp
//./HW2
#include "InflationCalculator.h"

using namespace std;

int main()
{
    InflationCalculator app;

    //calls primary function
    app.getInfo();

    return 0;
}
