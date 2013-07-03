/*Seth Denney
Assignment 6a
3/10/2010
===========================================
Using the coefficients of a quadratic function, 
compute roots or print "No real roots" to screen.
===========================================
*/

#include <stdio.h>
#include <math.h>

   int main ()
   {
      double a, b, c, D, root1, root2 ;
   
   	//get coefficients and check that the equation is quadratic
      do{
      
         printf("Enter coefficients a, b, and c: ") ;
         scanf("%lf %lf %lf", &a, &b, &c) ;
         
         if(a == 0)
         {
            printf("Equation is not quadratic.\n") ;
         }
      
      }while(a == 0) ;
   
      D = sqrt(pow(b,2.0) - (4 * a * c)) ;
   
   	//compute roots
      if(D == 0)
      {
         root1 = -1.0 * b / (2 * a) ;
         
         printf("The root is %.1f\n", root1) ;
      }
      
      else if(D > 0)
      {
         root1 = (-1.0 * b + D) / (2.0 * a) ;
         
         root2 = (-1.0 * b - D) / (2.0 * a) ;
         
         printf("The roots are %.1f and %.1f\n", root1, root2) ;
      }
      
      else 
      {
         printf("No real roots\n") ;
      }
      
      return 0 ;
   }
   
	
