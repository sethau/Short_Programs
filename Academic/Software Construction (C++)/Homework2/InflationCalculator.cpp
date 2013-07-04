//InflationCalculator.cpp
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 10/8/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: The InflationCalculator class provides
//functionality to read in and use item data to
//calculate inflation.
#include "InflationCalculator.h"

//primary run function
void InflationCalculator::getInfo()
{
    string name, dummy, error = "Invalid Input\r\n";
    char opt = 'n';
    double preCost, postCost;
    bool valid;

    cout << "*** Welcome to Seth's inflation rate calculator ***\r\n";

    do
    {
        //prompt for item name
        cout << "Your item: ";
        cin >> name;
        getline(cin, dummy);

        //repeat prompt sequence until valid data is entered
        valid = false;
        while (!valid)
        {
            //prompt for item price one year ago
            cout << "What is the price of " << name << " one year ago? ";
            if (!(cin >> preCost))
            {
                cin.clear();
                cout << error;
                getline(cin, dummy);
            }
            else
            {
                valid = true;
                getline(cin, dummy);
            }
        }

        //repeat prompt sequence until valid data is entered
        valid = false;
        while (!valid)
        {
            //prompt for item price now
            cout << "What is the price of " << name << " today? ";
            if (!(cin >> postCost))
            {
                cin.clear();
                cout << error;
                getline(cin, dummy);
            }
            else
            {
                valid = true;
                getline(cin, dummy);
            }
        }

        //display formatted inflation result
        cout.setf(ios::fixed);
        cout.setf(ios::showpoint);
        cout.precision(1);
        //call calculateInflation() with appropriate parameters
        cout << "The inflation rate of " << name << " is: " << calculateInflation(preCost, postCost) << "%";

        //conditional continue from prompt
        cout << "\r\n\nContinue ...... (Y/N)? ";
        cin >> opt;
        getline(cin, dummy);
    } while (opt == 'Y' || opt == 'y');

    //exit
    cout << "*** Goodbye ***\r\n";
}
//calculates and returns %difference between two double values
double InflationCalculator::calculateInflation(double preCost, double postCost)
{
    double inflation;

    inflation = (postCost - preCost) / preCost;

    return inflation * 100;
}
