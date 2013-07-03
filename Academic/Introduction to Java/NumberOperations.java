   /**
    * Performs analysis on a user-specified number.
    *
    * @author Seth Denney
    * @version 9-27-2011
    */
   public class NumberOperations {
      private int number;
      
   	/**
   	* Constructor for NumberOperations.
   	* 
   	* @param numberIn the number
   	*/
      public NumberOperations(int numberIn) {
         number = numberIn;
      }
   	
    /**
    * Getter for the number.
    *
    * @return the number
    */
      public int getValue() {
         return number;
      }
   	
    /**
    * Lists all odd numbers below the number.
    *
    * @return list of odd numbers below the number
    */
      public String oddsUnder() {
         String output = "";
         int i = 0;
      
         while (i < number) {
            if (i % 2 != 0) {
               output += i + "\t";
            }
            i++;
         }
      	
         return output;
      }
   	
   /**
    * Lists all powers of two below the number.
    *
    * @return powers of two below the number
    */
      public String powersTwoUnder() {
         String output = "";
         int powers = 1, dum = 1;
      
         while (powers < number) {
            if (powers == dum) {
               output += powers + "\t";
               dum = dum * 2;
            }
            powers++;
         }
         return output;
      }
   	
   /**
    * Compares a value to the number.
    *
    * @param compareNumber value to compare to the number
    * @return int identifier for > < or =
    */
      public int isGreater(int compareNumber) {
         if (number > compareNumber) {
            return 1;
         }
         else if (number < compareNumber) {
            return -1;
         }
         else {
            return 0;
         }
      }
   	
   /**
    * Compiles output for the number.
    *
    * @return output
    */
      public String toString() {
         String output = "";
      	
         output += number;
      	
         if (number < 0) {
            output += ": Number is negative ";
         }
         else if (number > 0) {
            output += ": Number is positive ";
         }
      		
         if (number % 2 != 0 && number != 0) {
            output += "odd.";
         }
         else if (number % 2 == 0 && number != 0) {
            output += "even.";
         }
         return output;
      }
   }