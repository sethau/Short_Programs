/* Seth Denney
Assignment 2b
1/30/2010
-----------------------------------------------------------------
Given a height in inches and a target BMI in kilograms per meter squared,
calculate and print the target weight in pounds to the screen.
------------------------------------------------------------------
*/
#include <stdio.h>
/*
 conversion constants shown below convert left to right
 as in the constant's title when multiplied by the left measurement
 ex. in * in_m will provide meters. 
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
   	
      printf("The BMI is %f kilograms per meter squared.\n\n", BMI) ;
   	
   	
   	//read data from user input
      printf("Enter the target BMI in kilograms per meter squared.\n") ;
      scanf("%lf", &BMI) ;
   
   
   	//calculate target weight
      lbs = BMI * (in * in_m * in * in_m) / lb_kg  ;
   		
      printf("The target weight is %f pounds for a BMI of %f.\n", lbs, BMI) ;
   	
      return 0 ;
   }
	

