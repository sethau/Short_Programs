   import java.util.Scanner;
   
	/**
    * Calculates the sum and average of three inputs via standard I/O.
    *
    * @author Seth Denney
    * @version 8-30-2010
    */
   public class AverageOfThree {
   
      /**
       * Calculates the sum and average of three inputs via standard I/O.
       *
       * @param args User-defined command line arguments (not used).
       */
      public static void main(String[] args) {
      
         int sum = 0;
         Scanner numberInput = new Scanner(System.in);  
      	
         System.out.println("This program calculates the sum and average "
            + "of three integers.");
            
         // get numerical input from user
         System.out.print("\tEnter the first number: ");
         sum += numberInput.nextInt();
         System.out.print("\tEnter the second number: ");
         sum += numberInput.nextInt();
         System.out.print("\tEnter the third number: ");
         sum += numberInput.nextInt();
         
      	// display sum
         System.out.println("\r\n \r\nThe sum of your input is " + sum);
      	
      	//display average
         System.out.println("The average of your input is " + (double) sum / 3);
      }
   }