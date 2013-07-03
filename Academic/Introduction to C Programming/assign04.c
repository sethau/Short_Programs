/* Seth Denney
Assignment 4
2/16/2010
-----------------------------------------------------------------
Input member information for some number of new members.
Then print a summary of each member's information to the screen.
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
      int num_mem, num ;
      double lbs, in, BMI, tgtBMI, tgtlbs, IBW ;
      char gender ;
         	
      printf("Enter the number of new members: ") ;
      scanf("%d", &num_mem) ;
      
      num = 1 ;
   
      while(num <= num_mem)
      {
      	//set acceptable values within ranges. Arbitrary.
         lbs = 100.0 ;
         in = 70.0 ;
      
      	//set unacceptable value outside range for BMI to facilitate the BMI range check loop. Arbitrary. 
         BMI = 50.0 ;
        
         printf("========Member %03d Info========\n", num) ;
      
         do
         {
            printf("Enter the gender, m for male or f for female: ") ;
            scanf(" %c", &gender) ;
         } while( gender != 'm' && gender != 'f' ) ;
         
            
         while(BMI < BMImin || BMI > BMImax)
         {      
         
         	//read data from user input
            printf("Weight: ") ;
            scanf("%lf", &lbs) ;
               
            while( lbs < lbsmin || lbs > lbsmax )
            {
               printf("weight outside acceptable range\nPlease enter weight in pounds between 90.00 and 350.00\n") ;
               printf("Weight: ") ;
               scanf("%lf", &lbs) ;
            
            }
         
            printf("Height: ") ;
            scanf("%lf", &in) ;
         
            while(in < inmin || in > inmax )
            {
               printf("height outside acceptable range\nPlease enter height in inches between 59.00 and 78.00.\n") ;
               printf("Height: ") ;
               scanf("%lf", &in) ;
            
            }
         
         	//calculate BMI
            BMI = (lbs * lb_kg)/(in * in_m * in * in_m) ;
         
            if(BMI < BMImin || BMI > BMImax)
            {
               printf("BMI outside acceptable range\nPlease check height and weight for accuracy.\n") ;
               printf("BMI = %f\n", BMI) ;
            
            }
         
         }
      
         printf("BMI: %.2f kg/m^2\n", BMI) ;
      
      	//set unacceptable value outside range for tgtBMI to facilitate the BMI range check loop. Arbitrary. 
         tgtBMI = 50.0 ;
      
      	//read data from user input
      
         while(tgtBMI < BMImin || tgtBMI > BMImax)
         {
            printf("Enter the target BMI in kilograms per meter squared: ") ;
            scanf("%lf", &tgtBMI) ;
         
            if(tgtBMI < BMImin || tgtBMI > BMImax)
            {
               printf("BMI outside acceptable range\nPlease enter target BMI between 10.5 and 30.0.\n") ;
            }
         }
       
      	//calculate target weight
         tgtlbs = tgtBMI * (in * in_m * in * in_m) / lb_kg  ;
      	
         printf("Target weight: %.2f pounds\n\n", tgtlbs, tgtBMI) ;
      
      	//decide between male and female
      
      
         if(gender == 'm') 
         {
            IBW = (50.0 + 2.3 * (in - 60)) / lb_kg ;
         }
         
         else if (gender == 'f')
         {
         
            IBW = (45.5 + 2.3 * (in - 60)) / lb_kg ;
         }
      
         printf("=============================\nSummary of Member %03d\n\nHeight:             %6.2f\nWeight:             %6.2f\nGender:                  %c\nBMI:                %6.2f\n", num, in, lbs, gender, BMI) ;
      	
      	
         if(BMI < 25.0)
         {
            printf("Classification:     normal\n") ;
         }
         
         else if(BMI >= 25.0 && BMI < 30.0)
         {
            printf("Classification:     overweight\n") ;
         }
         
         else if(BMI >= 30.0)
         {
            printf("Classification:     obese\n") ;
         }
      	
         printf("IBW:                %6.2f\nTarget BMI:         %6.2f\nTarget Weight:      %6.2f\n=============================\n\n\n", IBW, tgtBMI, tgtlbs) ; 
      	 
         num = num + 1 ;
      
      }
   	
      return 0 ;
   }
