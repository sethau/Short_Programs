//CashSale
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: CashSale represents a subclass of Sale,
//in which cash is used.
#include "CashSale.h"

CashSale::CashSale()
{
    //ctor
}
CashSale::~CashSale()
{
    //dtor
}
void CashSale::processPayment()
{
    stringstream ss;

    ss.setf(ios::fixed);
    ss.setf(ios::showpoint);
    ss.precision(2);
    ss << output;

    do
    {
        cout << "\r\nAmount received: $";
        cin >> amount;
    } while (amount < total);

    ss << "\r\n\tAmount received: $" << amount;

    change = amount - total;

    cout << "\r\nChange: $" << change << endl;
    ss << "\r\n\tChange: $" << change << flush;

    output = ss.str();
}
void CashSale::printPayment()
{
    cout << output << endl;
}
void CashSale::copy(Sale saleIn)
{
    setItems(saleIn.getItems());
    setPrices(saleIn.getPrices());
    setSalesTax(saleIn.getSalesTax());
    setSalesType(saleIn.getSalesType());
    setTotal(saleIn.getTotal());
    setOut(saleIn.getOut());

    processPayment();
}
