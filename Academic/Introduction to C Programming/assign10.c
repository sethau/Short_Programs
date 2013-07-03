/*Seth Denney
Assignment 10
4/22/2010
===========================================
Read player data from file, print organized 
report, and calculate averages and percent
wins. Print to screen and extended detail 
report to new file.
===========================================
*/

#include <stdio.h>
#include <math.h>
#include <string.h>
#define TITLE 40
#define NUMCOLS 9
#define MAXPLYRS 10
#define MAXNAME 20
#define INFILE "wbb2010players.txt"
#define OUTFILE "wbB2010playersSUM.txt"

   int readStats( int plyrInfo[][NUMCOLS], char plyrNm1[][MAXNAME], char plyrNm2[][MAXNAME], char Title[] );   
   void printPlayerPts( int pInfo[][NUMCOLS], int numPlyrs, char plyrNm1[][], char plyrNm2[][]  );
   void printTeamPts( int pInfo[][NUMCOLS], int numPlyrs );
   void printHeaders(char Title[]) ;	
   void printFile( int pInfo[][NUMCOLS], int numPlyrs ) ;

   int main ()
   {
   	//call functions
      int numPlyrs, plyrInfo[MAXPLYRS][NUMCOLS] ;
      char Title[TITLE], plyrNm1[MAXPLYRS][MAXNAME], plyrNm2[MAXPLYRS][MAXNAME] ;
      
      numPlyrs = readStats(plyrInfo, plyrNm1, plyrNm2, Title) ;	
   	
   	//check for successful read   
      if(numPlyrs != 0)
      {
         printHeaders(Title) ;
         printPlayerPts(plyrInfo, numPlyrs, plyrNm1, plyrNm2) ;
         printTeamPts(plyrInfo, numPlyrs) ;
         printFile(plyrInfo, numPlyrs) ;
      }
   	
      return 0 ;
   }
   
	
   int readStats( int plyrInfo[][NUMCOLS], char plyrNm1[][MAXNAME], char plyrNm2[][MAXNAME], char Title[] )
   {
      int numPlyrs = 0, row = 0 ;
   
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
         fgets(Title, TITLE, stats) ;
      	
         while(fscanf(stats, "%s %s %d %d %d %d %d %d %d %d %d", &plyrNm1[row], &plyrNm2[row], &plyrInfo[row][0], &plyrInfo[row][1], &plyrInfo[row][2], &plyrInfo[row][3], &plyrInfo[row][4], &plyrInfo[row][5], &plyrInfo[row][6], &plyrInfo[row][7], &plyrInfo[row][8]) != EOF)
         {
            row++ ;  
         }        
      }
      //close file
      fclose(stats) ;
   	
      return row ;
   }


   void printHeaders(char Title[]) 
   {
      printf("    ") ;
      puts(Title) ;
      printf("                   ## GP  FG 3FG  FT TOT  AVE\n") ;
      printf("                   -- -- --- --- --- ---  ---\n") ;
   }
	
	
   void printPlayerPts( int pInfo[][NUMCOLS], int numPlyrs, char plyrNm1[][MAXNAME], char plyrNm2[][MAXNAME] )
   {
   
      int row, column, total = 0 ;
      double avg ;
      
      for(row = 0 ; row < numPlyrs ; row++)
      {
         total = 0 ;   
      
         printf("%s, %s ", plyrNm2[row], plyrNm1[row]) ;
         
         if(row == 0 || row == 1 || row == 4)
         {
            printf("     ") ;
         }
         else
         {
            printf(" ") ;
         }
         
         printf("%02d", pInfo[row][0]) ;
      	
         for(column = 1 ; column < NUMCOLS ; column++)
         {
            if( column != 2 && column != 4 && column != 6 && column != 8 )
            { 
               printf("%3d ", pInfo[row][column]) ;
            }
         }
         
         total= 2 * pInfo[row][3] + 3 * pInfo[row][5] + pInfo[row][7];
         
         avg = (double) total / pInfo[row][1] ;
                      
         printf("%3d %4.1f\n\n", total, avg) ;
         
      }
   
   }


   void printTeamPts( int pInfo[][NUMCOLS], int numPlyrs )
   {
   
      int row, column, total = 0, t1 = 0, t2 = 0, t3 = 0;
        
      printf("                   TOTAL ") ;
      
   	// calculate totals
      for(row = 0 ; row < numPlyrs ; row++)
      {
         t1 = t1 + pInfo[row][3] ;
         t2 = t2 + pInfo[row][5] ;
         t3 = t3 + pInfo[row][7] ;
      }
      
   	//calculate final total and print
      total = 2 * t1 + 3 * t2 + t3 ;
      printf("%d  %d %d %d", t1, t2, t3, total) ;
   }
   
	
   void printFile( int pInfo[][NUMCOLS], int numPlyrs )
   {
      int row ;
      double GS, FG, FG3, FT ;
      
   	//open file
      FILE *summary ;
      summary = fopen(OUTFILE, "w") ;
   
   	//check for bad file open
      if( summary == NULL)
      {
         printf("\nOPEN ERROR\n") ;
      }
   
   	//print file summary
      fprintf(summary, "1   2   3    4    5   6   7    8   9   10  11  12   13\n") ;
      fprintf(summary, "No. GP  GS  %%GS  FG FGA %%FG 3FG 3FGA %%3FG  FT FTA  %%FT\n") ;
      
      for(row = 0 ; row < numPlyrs ; row++)
      {
         fprintf(summary, "%02d", pInfo[row][0]) ;
      	
         fprintf(summary, "%4d %3d ", pInfo[row][1], pInfo[row][2]) ;
      
         if(pInfo[row][1] == 0)
         {	
            GS = 0 ;
         }
         
         else
         {
            GS = (double) pInfo[row][2] / (double) pInfo[row][1] ;
         }
      
         fprintf(summary, "%.2f ", GS) ;
      
         fprintf(summary, "%3d %3d ", pInfo[row][3], pInfo[row][4]) ;
      
         if(pInfo[row][4] == 0)
         {	
            FG = 0 ;
         }
         
         else
         {
            FG = (double) pInfo[row][3] / (double) pInfo[row][4] ;
         }
      
         fprintf(summary, "%.2f ", FG) ;	
      
         fprintf(summary, "%3d %3d ", pInfo[row][5], pInfo[row][6]) ;
      
         if(pInfo[row][6] == 0)
         {	
            FG3 = 0 ;
         }
         
         else
         {
            FG3 = (double) pInfo[row][5] / (double) pInfo[row][6] ;
         }
      
         fprintf(summary, "%.2f ", FG3) ;	
      
         fprintf(summary, "%3d %3d ", pInfo[row][7], pInfo[row][8]) ;
      
         if(pInfo[row][8] == 0)
         {	
            FT = 0 ;
         }
         
         else
         {
            FT = (double) pInfo[row][7] / (double) pInfo[row][8] ;
         }
      
         fprintf(summary, "%.2f\n", FT) ;
      
      }	
   }
   
	
