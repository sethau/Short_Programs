/* Seth Denney
COMP-1200
Spring 2010
Assignment 1b
Program Student
-----------------------------------------------------------------
Given the number of classes a student has taken and
the grades that they earned, this program will compute
a student's GPA and indicate whether the student is on
the Dean's list or the Failure list.
GPA - the student's GPA
GPT - the student's grade point total
Num - the number of classes the student took
Count - the course counter
Grade - the student's grade in one course
------------------------------------------------------------------
*/
#include <stdio.h>
   int main()
   {
      double GPA, GPT;
      int Num, Count;
      char Grade;
      
      printf("Enter the number of classes the student took.\n");
      scanf("%d", &Num);
      
      printf("Enter student grades, one per line.\n");
      
      GPT = 0.0;
      Count = 0;
      
      while (Count < Num)
      {
         scanf("\n%c", &Grade);
         
         if ((Grade == 'A') || (Grade == 'a'))
            GPT = GPT + 4.0;
            
         else if ((Grade == 'B') || (Grade == 'b'))
            GPT = GPT + 3.0;
            
         else if ((Grade == 'C') || (Grade == 'c'))
            GPT = GPT + 2.0;
            
         else if ((Grade == 'D') || (Grade == 'd'))
            GPT = GPT + 1.0;
            
         Count = Count + 1;
      }
      
      GPA = GPT / (double)( Num );
      printf(" GPA is %5.2f\n", GPA);
      
      if ( GPA >= 3.50 ) printf(" Dean's list\n");
      
      if ( GPA < 1.00 ) printf(" Failure list\n");
      
      return 0;
   }

