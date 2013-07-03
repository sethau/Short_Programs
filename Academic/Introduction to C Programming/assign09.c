/*Seth Denney
Assignment 09
4/15/2010
===========================================
Read season data from file, print organized 
report, and calculate averages and percent
wins.
===========================================
*/

#include <stdio.h>
#include <math.h>
#define NUMCOLS 5
#define MAXPLYRS 20
#define INFILE "wbb2010score.txt"

   int readStats( int plyrInfo[][NUMCOLS] );   
   void printPlayerPts( int pInfo[][NUMCOLS], int numPlyrs );
   void printTeamPts( int pInfo[][NUMCOLS], int numPlyrs );
   void printHeaders() ;	

   int main ()
   {
   	//call functions
      int numPlyrs;
      int plyrInfo[MAXPLYRS][NUMCOLS] ;
      
      numPlyrs = readStats(plyrInfo) ;	
      
   	//check for successful read   
      if(numPlyrs != 0)
      {
         printHeaders() ;
         printPlayerPts(plyrInfo, numPlyrs) ;
         printTeamPts(plyrInfo, numPlyrs) ;
      }
   	
      return 0 ;
   }
   
	
   int readStats( int plyrInfo[][NUMCOLS] )
   {
      int numPlyrs = 0, row = 0, column = 0 ;
   
   	//open file
      FILE *stats ;
      stats = fopen(INFILE, "r") ;
   
   	//check for bad file open
      if( stats == NULL)
      {
         printf("\nOPEN ERROR\n") ;
      }
      
      else 
      {
      	//read file
         while(fscanf(stats, "%d %d %d %d %d",&plyrInfo[row][0], &plyrInfo[row][1], &plyrInfo[row][2], &plyrInfo[row][3], &plyrInfo[row][4]) != EOF)
         {
            row++ ;  
         }        
      }
      return row ;
   }


   void printHeaders() 
   {
      printf("Auburn Women's BB 2010 Season\n\n") ;
      printf("## GP  FG 3FG  FT TOT  AVE\n") ;
      printf("-- -- --- --- --- ---  ---\n") ;
   }
	
	
   void printPlayerPts( int pInfo[][NUMCOLS], int numPlyrs )
   {
   
      int row, column, total = 0 ;
      double avg ;
      
      for(row = 0 ; row < numPlyrs ; row++)
      {
         total = 0 ;
         
         printf("%02d", pInfo[row][0]) ;
      	
         for(column = 1 ; column < NUMCOLS ; column++)
         {
            printf("%3d ", pInfo[row][column]) ;
         }
         
      	//calculate total and average
         total= 2 * pInfo[row][2] + 3 * pInfo[row][3] + pInfo[row][4];
         avg = (double) total / pInfo[row][1] ;
         
      	//print total and average	               
         printf("%3d %4.1f\n\n", total, avg) ;
       
      }
   
   }


   void printTeamPts( int pInfo[][NUMCOLS], int numPlyrs )
   {
   
      int row, column, total = 0, t1 = 0, t2 = 0, t3 = 0;
        
      printf("TOTAL  ") ;
      
   	// calculate totals
      for(row = 0 ; row < numPlyrs ; row++)
      {
         t1 = t1 + pInfo[row][2] ;
         t2 = t2 + pInfo[row][3] ;
         t3 = t3 + pInfo[row][4] ;
      }
   	
   	//calculate final total and print
      total = 2 * t1 + 3 * t2 + t3 ;
      printf("%d %d %d %d", t1, t2, t3, total) ;
   }
   
