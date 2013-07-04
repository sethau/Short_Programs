//main
//Author: Seth Denney
//Class: COMP 2710 - Software Construction
//Date: 11/28/2012
//Email: STD0003@tigermail.auburn.edu
//
//Description: This is the main driver for the Simple Cash Register Application.
#include "Sale.h"
#include "CashSale.h"
#include "CheckSale.h"
#include "CreditCardSale.h"
#include <iostream>
#include <vector>

using namespace std;

int main()
{
    bool valid;
    char in;
    vector<Sale*> sales;

    Sale sale;
    CashSale cshs;
    CheckSale chks;
    CreditCardSale ccds;

    do
    {
        valid = false;

        cout << "\r\n=============================================================";
        cout << "\r\n\t\tWelcome to the Cash Register App!";
        cout << "\r\n=============================================================";

        while (!valid)
        {
            cout << "\r\nEnter payment(p), print sales(s), or exit(x): ";

            cin >> in;

            if (in == 'p' || in == 's' || in == 'x')
            {
                valid = true;
            }
            else
            {
                valid = false;
            }
        }

        if (in == 'p')
        {
            sale.getSalesInfo();

            valid = false;
            while (!valid)
            {
                cout << "\r\n\nEnter payment type; cash(c), check(k), or credit card(d): ";

                cin >> in;

                switch (in)
                {
                    case 'c':
                        valid = true;
                        cshs.copy(sale);
                        sales.push_back(&cshs);
                        sale.reset();
                        break;
                    case 'k':
                        valid = true;
                        chks.copy(sale);
                        sales.push_back(&chks);
                        sale.reset();
                        break;
                    case 'd':
                        valid = true;
                        ccds.copy(sale);
                        sales.push_back(&ccds);
                        sale.reset();
                        break;
                }
            }
        }
        else if (in == 's')
        {
            for (int i = 0; i < sales.size(); i++)
            {
                cout << "Sale #" << i + 1 << ":";
                sales.at(i)->printPayment();
            }

            cout << "\r\n\nEnd";
        }
    } while (in != 'x');

    return 0;
}
