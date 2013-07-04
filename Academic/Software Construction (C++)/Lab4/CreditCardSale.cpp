//CreditCardSale
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: CreditCardSale represents a subclass of Sale,
//in which a credit card is used.
#include "CreditCardSale.h"

CreditCardSale::CreditCardSale()
{
    //ctor
}
CreditCardSale::~CreditCardSale()
{
    //dtor
}
void CreditCardSale::processPayment()
{
    stringstream ss;

    ss.setf(ios::fixed);
    ss.setf(ios::showpoint);
    ss.precision(2);
    ss << output;

    cout << "\r\nEnter name on the credit card: ";
    getline(cin, name);
    getline(cin, name);

    cout << "\r\nEnter credit card number: ";
    cin >> ccNum;

    cout << "\r\nEnter expiration date: ";
    getline(cin, expDate);
    getline(cin, expDate);

    ss << "\r\n\tCREDIT: " << name << " - " << ccNum << " - " << expDate << flush;
    output = ss.str();
}
void CreditCardSale::printPayment()
{
    cout << output << endl;
}
void CreditCardSale::copy(Sale saleIn)
{
    setItems(saleIn.getItems());
    setPrices(saleIn.getPrices());
    setSalesTax(saleIn.getSalesTax());
    setSalesType(saleIn.getSalesType());
    setTotal(saleIn.getTotal());
    setOut(saleIn.getOut());

    processPayment();
}
