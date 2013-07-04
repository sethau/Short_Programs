//CheckSale
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: CheckSale represents a subclass of Sale,
//in which a check is used.
#include "CheckSale.h"

CheckSale::CheckSale()
{
   dlNum = 0;
}
CheckSale::~CheckSale()
{
    //dtor
}
void CheckSale::processPayment()
{
    stringstream ss;

    ss.setf(ios::fixed);
    ss.setf(ios::showpoint);
    ss.precision(2);
    ss << output;

    cout << "\r\nEnter name on the check: ";
    getline(cin, name);
    getline(cin, name);

    do
    {
        cout << "\r\nEnter driver's license number: ";
        cin >> dlNum;
    } while (dlNum < 0);

    ss << "\r\n\tCHECK: " << name << " - " << dlNum << flush;
    output = ss.str();
}
void CheckSale::printPayment()
{
    cout << output << endl;
}
void CheckSale::copy(Sale saleIn)
{
    setItems(saleIn.getItems());
    setPrices(saleIn.getPrices());
    setSalesTax(saleIn.getSalesTax());
    setSalesType(saleIn.getSalesType());
    setTotal(saleIn.getTotal());
    setOut(saleIn.getOut());

    processPayment();
}
