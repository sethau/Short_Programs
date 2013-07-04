//CashSale (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: CashSale represents a subclass of Sale,
//in which cash is used.
#ifndef CASHSALE_H
#define CASHSALE_H

#include "Sale.h"


class CashSale : public Sale
{
    public:
        CashSale();
        virtual ~CashSale();
        void copy(Sale);
    private:
        double amount;
        double change;
        virtual void processPayment();
        virtual void printPayment();
};

#endif // CASHSALE_H
