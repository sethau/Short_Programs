/* Seth Denney
Assignment 2a
1/30/2010
-----------------------------------------------------------------
Given a weight in pounds and a height in feet, output the BMI in kg/m^2.
------------------------------------------------------------------
*/
#include <stdio.h>
/*
 conversion constants shown below convert left to right
 as in the constant's title when multiplied by the left measurement
 ex. in * in_m will provide meters and m / in_m will provide inches. 
*/
   const double in_m = 0.0254 ;
   const double lb_kg = 0.453597 ;


   int main () 
   {
      double lbs, in, BMI ;
   	
   	//read data from user input
      printf("Enter the weight in lbs and the height in inches, separated by a space.\n") ;
      scanf("%lf %lf", &lbs, &in) ;
   	
   	//calculate BMI
      BMI = (lbs * lb_kg)/(in * in_m * in * in_m) ;
   	
      printf("The BMI is %f kilograms per meter squared.\n", BMI) ;
   	
      return 0 ;
   }
	

