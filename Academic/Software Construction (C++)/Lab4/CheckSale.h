//CheckSale (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: CheckSale represents a subclass of Sale,
//in which a check is used.
#ifndef CHECKSALE_H
#define CHECKSALE_H

#include "Sale.h"


class CheckSale : public Sale
{
    public:
        CheckSale();
        virtual ~CheckSale();
        void copy(Sale);
    private:
        string name;
        long dlNum;
        virtual void processPayment();
        virtual void printPayment();
};

#endif // CHECKSALE_H
