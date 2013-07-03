/* Seth Denney
Assignment 3b
2/5/2010
-----------------------------------------------------------------
Given a weight in pounds and a height in feet, output the BMI in kg/m^2.

Check to ensure accurate user input and feasible results.

Then, using the previously given height in inches and a target BMI in kilograms per meter squared,
calculate and print the target weight in pounds to the screen.

Then, for a given gender, calculate IBW and print to the screen.
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
   const double inmin = 59.0 ;
   const double inmax = 78.0 ;
   const double lbsmin = 90.0 ;
   const double lbsmax = 350.0 ;
   const double BMImin = 10.5 ;
   const double BMImax = 30.0 ;



   int main () 
   {
      double lbs, in, BMI, IBW ;
      char gender ;
   	
   	//set acceptable values within ranges. Arbitrary.
      lbs = 100.0 ;
      in = 70.0 ;
   	
   	//set unacceptable value outside range for BMI to facilitate the BMI range check loop. Arbitrary. 
      BMI = 50.0 ;
      
      do
      {
         printf("Enter your gender, m for male or f for female.\n") ;
         scanf("%c", &gender) ;
         
         if( (gender != 'm' && gender != 'f' ))
         {
            printf("Enter your gender, m for male or f for female.\n") ;
            scanf("%c", &gender) ;
         }
         
      } while( (gender != 'm' && gender != 'f' )) ;   
       
      while(BMI < BMImin || BMI > BMImax)
      {      
      	//read data from user input
         printf("Enter your weight in lbs and your height in inches, separated by a space.\n") ;
         scanf("%lf %lf", &lbs, &in) ;
      
         while(lbs < lbsmin || lbs > lbsmax )
         {
            printf("weight outside acceptable range\nPlease enter weight in pounds between 90.00 and 350.00\n") ;
            scanf("%lf", &lbs) ;
         }
      
         while(in < inmin || in > inmax )
         {
            printf("height outside acceptable range\nPlease enter height in inches between 59.00 and 78.00.\n") ;
            scanf("%lf", &in) ;
         }
      
      	//calculate BMI
         BMI = (lbs * lb_kg)/(in * in_m * in * in_m) ;
      	
         if(BMI < BMImin || BMI > BMImax)
         {
            printf("BMI outside acceptable range\nPlease check height and weight for accuracy.\n") ;
         
         }
      	
      }
      
      printf("The BMI is %.2f kilograms per meter squared.\n\n", BMI) ;
   	
   	
   	//read data from user input
     
      printf("Enter the target BMI in kilograms per meter squared.\n") ;
      scanf("%lf", &BMI) ;
       
   	//calculate target weight
      lbs = BMI * (in * in_m * in * in_m) / lb_kg  ;
   		
      printf("The target weight is %.2f pounds for a BMI of %.2f.\n\n", lbs, BMI) ;
   	
   	//decide between male and female
     
      
      if(gender == 'm') 
      {
         IBW = (50.0 + 2.3 * (in - 60)) / lb_kg ;
      }
         
      else if (gender == 'f')
      {
         
         IBW = (45.5 + 2.3 * (in - 60)) / lb_kg ;
      }
      
      printf("Your IBW is %.2f pounds.\n", IBW) ;	 
   	
   	
      return 0 ;
   }
