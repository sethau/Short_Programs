#ifndef SALE_H
//Sale (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: Sale represents a sale, containing
//some number of items and specific sale and payment types.
#define SALE_H

#include <vector>
#include <string>
#include <iostream>
#include <sstream>

using namespace std;

class Sale
{
    public:
        Sale();
        virtual ~Sale();
        Sale& operator=(const Sale&);
        virtual void printPayment();
        void printSale();
        void getSalesInfo();
        vector<string> getItems();
        void setItems(vector<string>);
        vector<double> getPrices();
        void setPrices(vector<double>);
        double getSalesTax();
        void setSalesTax(double);
        int getSalesType();
        void setSalesType(int);
        double getTotal();
        void setTotal(double);
        void setOut(string);
        string getOut();
        void reset();
    protected:
        vector<string> items;
        vector<double> prices;
        string output;
        double salesTax;
        int salesType;
        double total;
        void calculateTax(char);
        virtual void processPayment();
};

#endif // SALE_H
