   import java.util.Scanner;
	/** 
    * Reads, calculates, and prints information about the user. 
	 *
	 * @author Seth Denney
	 * @version 9-7-2011
    */
   public class NameDisplay {
   	/**
       * Reads, calculates, and prints information about the user.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
      
         String name, nickName, result = "";
         int age, year;
         Scanner scan = new Scanner(System.in);
      
         System.out.print("Enter the current year: ");
         year = Integer.parseInt(scan.nextLine()); 
      
         System.out.print("Enter your age (the age you will turn "
            + "this year): ");
         age = Integer.parseInt(scan.nextLine());
      
         System.out.print("Enter your first and last name, "
            + "separated by a space: ");
         name = scan.nextLine();
      	
         System.out.print("Enter your nickname: ");
         nickName = scan.nextLine();
         
         result = name.substring(0, name.indexOf(" ")) + " \"" 
            + nickName + "\"" + name.substring(name.indexOf(" ")) 
            + " " + (year - age);
      
         System.out.println("\r\nYour information is " + result);
      }
   }