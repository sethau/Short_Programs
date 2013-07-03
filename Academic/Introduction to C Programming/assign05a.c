/* Seth Denney
Assignment 5a
2/24/2010
-----------------------------------------------------------------
Create memberInfo file to hold body information for new members.
Get info from user.
Check to ensure accurate user input and feasible results.
Save file with sentinel value at end for file reader.
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
   const int sentinel = 0 ;


   int main () 
   {
      int num ;
      double lbs, in ;
      char gender ;
      
      FILE *info ; info = fopen("memberInfo.txt", "w") ;
         	
      num = 1 ;
   
      while(in != sentinel)
      {
      //set acceptable values within ranges. Arbitrary.
         lbs = 100.0 ;
         in = 70.0 ;
        
         do
         {      
         
            printf("\n========Member %03d Info========\n", num) ;
                  
         //read data from user input
            printf("Height: ") ;
            scanf("%lf", &in) ;
            
            if ( in != sentinel)
            {
               printf("Weight: ") ;
               scanf("%lf", &lbs) ;
               
            
               while(in < inmin || in > inmax )
               {
                  printf("height outside acceptable range\nPlease enter height in inches between 59.00 and 78.00.\n") ;
                  printf("Height: ") ;
                  scanf("%lf", &in) ;
               }
            
               while( lbs < lbsmin || lbs > lbsmax )
               {
                  printf("weight outside acceptable range\nPlease enter weight in pounds between 90.00 and 350.00\n") ;
                  printf("Weight: ") ;
                  scanf("%lf", &lbs) ;
               
               }
            
               do
               {
                  printf("Gender: ") ;
                  scanf(" %c", &gender) ;
               } while(gender != 'm' && gender != 'f' && gender != 'M' && gender != 'F') ;
            
               if( gender == 'm')
               {
                  gender = 'M' ;
               }
            	
               if( gender == 'f')
               {
                  gender = 'F' ;
               }
            
               fprintf(info, "%d %6.2f %6.2f %c\n", num, in, lbs, gender) ;  
               printf( "%d %6.2f %6.2f %c\n", num, in, lbs, gender) ;  	
            
               num = num + 1 ;
            }
         }  while(in != sentinel) ;
         
      	//print sentinel for part b
         fprintf(info, "0") ;
         fclose(info) ;
      }
   	
      return 0 ;
   }
