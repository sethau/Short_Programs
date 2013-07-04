//Sale
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: Sale represents a sale, containing
//some number of items and specific sale and payment types.
#include "Sale.h"

Sale::Sale()
{
    //ctor
}
Sale::~Sale()
{
    //dtor
}
Sale& Sale::operator= (const Sale& saleIn)
{
    setItems(saleIn.items);
    setPrices(saleIn.prices);
    setSalesTax(saleIn.salesTax);
    setSalesType(saleIn.salesType);
    setTotal(saleIn.total);

    return *this;
}
void Sale::printPayment()
{
    cout << "Hmmmmm......";
}
void Sale::printSale()
{

}
void Sale::getSalesInfo()
{
    stringstream ss;
    string in = "";
    char type;
    bool valid;
    double priceIn = 0;

    total = 0;
    ss.setf(ios::fixed);
    ss.setf(ios::showpoint);
    ss.precision(2);
    do
    {
        cout << "\r\nEnter item: ";
        getline(cin, in);
        getline(cin, in);

        if (in.compare("*") != 0)
        {
            items.push_back(in);
            ss << "\r\n\t" << items.size() << ". " << in;

            priceIn = 0;
            do
            {
                if (priceIn < 0)
                {
                    cout << "\r\n\t\tPlease enter a positive value.";
                    priceIn = 0;
                }

                cout << "\r\nEnter amount: $";
            } while (!(cin >> priceIn) || priceIn < 0);

            prices.push_back(priceIn);
            ss << " $" << priceIn;
            total += priceIn;
        }
    } while (in.compare("*") != 0);

    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(2);
    cout << "\r\nSubtotal: $" << total;

    ss << "\r\n\tSubtotal: $" << total << flush;
    output = ss.str();

    valid = false;
    while (!valid)
    {
        cout << "\r\n\nEnter Type of Sale; regular(r), discount(d), or mail-order(m): ";

        cin >> type;

        if (type == 'r' || type == 'd' || type == 'm')
        {
            calculateTax(type);
            valid = true;
        }
        else
        {
            valid = false;
        }
    }
}
void Sale::calculateTax(char type)
{
    stringstream ss;


    ss.setf(ios::fixed);
    ss.setf(ios::showpoint);
    ss.precision(2);

    ss << output;

    switch (type)
    {
        case 'r':
            salesTax = 0.07 * total;
            cout << "\r\nTax: $" << salesTax;
            ss << "\r\n\tTax: $" << salesTax;
            total += salesTax;
            cout << "\r\n\nTotal: $" << total;
            ss << "\r\n\tTotal: $" << total << flush;
            break;
        case 'd':
            salesTax = 0.1 * total;
            cout << "\r\nDiscount: $" << salesTax;
            ss << "\r\n\tDiscount: $" << salesTax;
            total -= salesTax;
            salesTax = 0.07 * total;
            cout << "\r\n\nTax: $" << salesTax;
            ss << "\r\n\tTax: $" << salesTax;
            total += salesTax;
            cout << "\r\n\nTotal: $" << total;
            ss << "\r\n\tTotal: $" << total << flush;
            break;
        case 'm':
            salesTax = 3.5 * items.size();
            cout << "\r\nShipping and Handling: $" << salesTax;
            ss << "\r\n\tShipping and Handling: $" << salesTax;
            total += salesTax;
            salesTax = 0.07 * total;
            cout << "\r\n\nTax: $" << salesTax;
            ss << "\r\n\tTax: $" << salesTax;
            total += salesTax;
            cout << "\r\n\nTotal: $" << total;
            ss << "\r\n\tTotal: $" << total << flush;
            break;
    }

    output = ss.str();
}
void Sale::processPayment()
{
    //dummy
    cout << "\r\n\n\t\tWell, something is messed up...\r\n";
}
vector<string> Sale::getItems()
{
    return items;
}
void Sale::setItems(vector<string> itemsIn)
{
    items = itemsIn;
}
vector<double> Sale::getPrices()
{
    return prices;
}
void Sale::setPrices(vector<double> pricesIn)
{
    prices = pricesIn;
}
double Sale::getSalesTax()
{
    return salesTax;
}
void Sale::setSalesTax(double taxIn)
{
    salesTax = taxIn;
}
int Sale::getSalesType()
{
    return salesType;
}
void Sale::setSalesType(int typeIn)
{
    salesType = typeIn;
}
double Sale::getTotal()
{
    return total;
}
void Sale::setTotal(double totalIn)
{
    total = totalIn;
}
void Sale::reset()
{
    items.clear();
    prices.clear();
    salesTax = 0;
    salesType = 0;
    total = 0;
    output = "";
}
void Sale::setOut(string stringIn)
{
    output = stringIn;
}
string Sale::getOut()
{
    return output;
}
