/*Seth Denney
Assignment 7
3/31/2010
===========================================
Using the coefficients of a quadratic function, 
compute roots or print "No real roots" to screen.
===========================================
*/

#include <stdio.h>
#include <math.h>

   void get_coefs(double *a, double *b, double *c) ;
   void get_roots(double a, double b, double D, double *x1, double *x2) ;
   double get_a() ;
   double get_b() ;
   double get_c() ;
   double comp_D(double a, double b, double c) ;
   double comp_x1(double D, double a, double b) ;
   double comp_x2(double D, double a, double b) ;
   void print_values(double x1, double x2, double ) ;

   int main ()
   {
   
      double a, b, c, x1, x2, D = -1.0 ;
   
      printf("For equation 0 = ax^2 + bx + c\n") ;
      
      while( D < 0 )
      {
      
      //get coefficients
         get_coefs(&a, &b, &c) ;
      
      //compute determinant
         D = comp_D(a, b, c) ;
      
      //compute roots
         get_roots(a, b, D, &x1, &x2) ;
      
      //print values
         print_values(x1, x2, D) ;
      
      } 
   	
   }
   
   void get_coefs(double *a, double *b, double *c) 
   {
   
      *a = get_a() ;
      
      *b = get_b() ;
      
      *c = get_c() ;
      
   }   
   
	
   void get_roots(double a, double b, double D, double *x1, double *x2)
   {
      *x1 = comp_x1(D, a, b) ;
      
      *x2 = comp_x2(D, a, b) ;   
   }
   
	
   double get_a ()
   {
      double a ;
   	
      do{
      
         printf("Enter coefficient a: ") ;
         scanf("%lf", &a) ;
         
         if(a == 0)
         {
            printf("Equation is not quadratic.\n") ;
         }
      
      }while(a == 0) ;
       
      return a ;
   }
    
   
   double get_b ()
   {
      double b ;
   	
      printf("Enter coefficient b: ") ;
      scanf("%lf", &b) ;
     
      return b ;
   }
    
    
   double get_c ()
   {
      double c ;
   	
      printf("Enter coefficient c: ") ;
      scanf("%lf", &c) ;
    
      return c ;
   }
    
    
   double comp_D (double a, double b, double c)
   {
      double D ;
   	
      D = pow(b, 2.0) - (4 * a * c) ;
      
      return D ;
   }
   
   
   double comp_x1 (double D, double a, double b)
   {
      double x1 ;
   	
      x1 = (-1.0 * b + sqrt(D)) / (2.0 * a) ;
      
      return x1 ;
   }
   
   
   double comp_x2(double D, double a, double b) 
   {
      double x2 ;
   	
      x2 = (-1.0 * b - sqrt(D)) / (2.0 * a) ;
   
      return x2 ;
   }
   
   
   void print_values(double x1, double x2, double D) 
   {
   	
      if(D == 0)
      {
         printf("roots: x1=%.1f x2=%.1f\n", x1, x1) ;
      }
      
      else if(D > 0)
      {
         printf("roots: x1=%.1f x2=%.1f\n", x1, x2) ;
      }
      
      else if(D < 0) 
      {
         printf("No real roots\n\n") ;
      }
      
      else
      {
         printf("Seth should probably quit programming and do something else.\n") ;
      }
      
   }
   
	
	
