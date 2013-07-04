//CreditCardSale (Header)
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: CreditCardSale represents a subclass of Sale,
//in which a credit card is used.
#ifndef CREDITCARDSALE_H
#define CREDITCARDSALE_H

#include "Sale.h"


class CreditCardSale : public Sale
{
    public:
        CreditCardSale();
        virtual ~CreditCardSale();
        void copy(Sale);
    private:
        string name;
        string ccNum;
        string expDate;
        virtual void processPayment();
        virtual void printPayment();
};

#endif // CREDITCARDSALE_H
