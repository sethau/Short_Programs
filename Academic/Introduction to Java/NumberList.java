   import java.util.Scanner;
   import java.util.ArrayList;
   
   /**
    * Obtains a set of numbers from the user until the user enters 0.
    * Information is then printed about each number that was entered 
    * including whether it was even or odd, and positive or negative.
    *
    * @author Seth Denney
    * @version 9-27-2011
    */
   public class NumberList {
   
      /**
       * Obtains a set of numbers from the user until the user enters
   	 * 0. Information is then printed about each number that was entered 
    	 * including whether it was even or odd, and positive or negative.
   	 *
       * @param args - Standard commandline arguments
       */
      public static void main(String[] args) {
      	
         String input = "";
         Scanner in = new Scanner(System.in);
         int count = 0, i;
         ArrayList<NumberOperations> numberList 
            = new ArrayList<NumberOperations>();
              
         System.out.println("Enter a set of non-zero numbers (0 to end): ");
         while (!input.equals("0")) {
            input = in.nextLine();
            if (!input.equals("0")) {
               numberList.add(count, 
                  new NumberOperations(Integer.parseInt(input)));
            }
            count++;
         }
         for (i = 0; i < numberList.size(); i++) {
            System.out.println(numberList.get(i));
         }
      }
   }