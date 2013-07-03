/*Seth Denney
Assignment 09
4/8/2010
===========================================
Read season data from file, print organized 
report, and calculate averages and percent
wins.
===========================================
*/

#include <stdio.h>
#include <math.h>
#define MAX_GAMES 20
#define INFILE "wbb2010sec.txt"

   int readStats( int month[], int day[], int AUscore[], int OPscore[] ) ;
   void printReport( int month[], int day[], int AUscore[], int OPscore[], int nGames ) ;
   int printDetails( int month[], int day[], int AUscore[], int OPscore[], int nGames ) ;
   void printHeaders() ;
   void printSummary( int auburn[], int opp[], int nGames, int nWin );
   double mean( int array[], int nElements );
	

   int main ()
   {
      int month[MAX_GAMES], day[MAX_GAMES], AUscore[MAX_GAMES], OPscore[MAX_GAMES], nGames = 0, nWin ;
   	
      nGames = readStats( month, day, AUscore, OPscore ) ;
     
      if(nGames != 0) 
      {
         nGames += 1 ;
      
         printReport( month, day, AUscore, OPscore, nGames ) ;
      }
   	
      return 0 ;
   }
   
	
   int readStats( int month[], int day[], int AUscore[], int OPscore[] )
   {
      int nGames = 0, count = 0;
   
      FILE *stats ; stats = fopen(INFILE, "r") ;
   
      if( stats == NULL)
      {
         printf("open error") ;
      }
      
      else 
      {
         while( fscanf(stats, "%d %d %d %d", &month[count], &day[count], &AUscore[count], &OPscore[count]) != EOF)
         {
            nGames += 1 ;
            count += 1 ;
         }
         
         nGames -= 1 ;
         
      }
      
      return nGames ;
   }
	
	


   void printReport( int month[], int day[], int AUscore[], int OPscore[], int nGames )
   {
      int count, nWin ;
   
      printHeaders() ;
   			
      nWin = printDetails( month, day, AUscore, OPscore, nGames ) ;
      
      printSummary( AUscore, OPscore, nGames, nWin ) ;
   }
	
	
	

   void printHeaders() 
   {
      printf("Auburn Women's BB\n") ;
      printf("2010 Season\n\n") ;
      printf("DATE SCORE W/L\n") ;
      printf("----- ----- ---\n") ;
   }
	
	
	
   int printDetails( int month[], int day[], int AUscore[], int OPscore[], int nGames )
   {
      int count, nWin = 0 ;
   
   //print dates and scores
      for(count = 0 ; count <= (nGames - 1) ; count++)
      {
      
         if(AUscore[count] > OPscore[count])
         {
            printf("%02d/%02d %02d-%02d  W\n", month[count], day[count], AUscore[count], OPscore[count]) ;
         	
            nWin += 1 ;
         }
         
         else if(AUscore[count] < OPscore[count])
         {
            printf("%02d/%02d %02d-%02d  L\n", month[count], day[count], AUscore[count], OPscore[count]) ;
         }
         
         else if(AUscore[count] == OPscore[count])
         {
            printf("%02d/%02d %02d-%02d  T\n", month[count], day[count], AUscore[count], OPscore[count]) ;
         }
      
      }
   	
      printf("\n\n") ;
   	
      return nWin ;
   
   }




   void printSummary( int auburn[], int opp[], int nGames, int nWin )
   {
      int count ;
      double win, AUscore_avg, OPscore_avg ;
   
      win = 100 * (double) nWin /(double) nGames ;	
   	
      AUscore_avg = mean(auburn, nGames) ;
      OPscore_avg = mean(opp, nGames) ;
   
      printf("Auburn has won %4.1f%%", win) ;
      printf(" of its %d games.\n", nGames) ;
      printf("Auburn's average score is %4.1f.\n", AUscore_avg) ;
      printf("The opponents' average score is %4.1f.\n", OPscore_avg) ;
   }



   double mean( int array[], int nElements )
   {
      int  count ;
      double total = 0, mean ;
   	
      for(count = 0 ; count < nElements ; count++)
      {
         total = total + array[count] ;
      }
   		
      mean = total / (nElements) ;
   	
      return mean ;
   }



