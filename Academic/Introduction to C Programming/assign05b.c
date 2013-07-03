/* Seth Denney
Assignment 5b
2/24/2010
-----------------------------------------------------------------
Read memberInfo.txt
Calculate BMI, IBW, and tgtlbs for tgtBMI of 25.0
Print summary to screen
stop when sentinel value is read
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
   const double tgtBMI = 25.0 ;
   const int sentinel = 0 ;


    int main () 
   {
      int num_mem, num ;
      double lbs, in, BMI, tgtlbs, IBW ;
      char gender ;
      
      //FILE *inout ; inout = fopen("inout.txt", "w") ;
      FILE *info ; info = fopen("memberInfo.txt", "r") ;
      if( info == NULL)
      {
         printf("open error\n") ;
      }
      
      else
      {
         	
         num = 1 ;
      
         printf("Member# Height Weight Gender    BMI  TgtWeight  Classification\n") ;
         //fprintf(inout,"Member# Height Weight Gender    BMI  TgtWeight  Classification\n") ;
      
         while(num != sentinel)
         {
         
            fscanf(info, "%d %lf %lf %c", &num, &in, &lbs, &gender) ;
            if(num != sentinel)
            {
            
            //calculate BMI
               BMI = (lbs * lb_kg)/(in * in_m * in * in_m) ;
            
            //calculate target weight
               tgtlbs = tgtBMI * (in * in_m * in * in_m) / lb_kg  ;
            
            //calculate IBW
               if(gender == 'M') 
               {
                  IBW = (50.0 + 2.3 * (in - 60)) / lb_kg ;
               }
               
               else if (gender == 'F')
               {
               
                  IBW = (45.5 + 2.3 * (in - 60)) / lb_kg ;
               }
            
            
            //determine classification
               if(BMI < 25.0)
               {
                  printf("    %03d %5.1f %7.1f %6c %6.2f %10.2f  normal\n", num, in, lbs, gender, BMI, tgtlbs) ; 
                  //fprintf(inout,"    %03d %5.1f %7.1f %6c %6.2f %10.2f  normal\n", num, in, lbs, gender, BMI, tgtlbs) ;
               }
               
               else if(BMI >= 25.0 && BMI < 30.0)
               {
                  printf("    %03d %5.1f %7.1f %6c %6.2f %10.2f  overweight\n", num, in, lbs, gender, BMI, tgtlbs) ;
                  //fprintf(inout,"    %03d %5.1f %7.1f %6c %6.2f %10.2f  overweight\n", num, in, lbs, gender, BMI, tgtlbs) ;
               }
               
               else if(BMI >= 30.0)
               {
                  printf("    %03d %5.1f %7.1f %6c %6.2f %10.2f  obese\n", num, in, lbs, gender, BMI, tgtlbs) ;
                  //fprintf(inout,"    %03d %5.1f %7.1f %6c %6.2f %10.2f  obese\n", num, in, lbs, gender, BMI, tgtlbs) ;
               }
            }
         }
      
         fclose(info) ;
      
         return 0 ;
      }
   }
