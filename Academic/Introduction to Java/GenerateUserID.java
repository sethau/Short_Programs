   import java.util.Scanner;
	
	/** 
    * Driver to read information about user and create
	 * a username and a password.
	 *
	 * @author Seth Denney
	 * @version 9-18-2011
    */
   public class GenerateUserID {
   
   /**
       * Creates username and password.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
         String firstName, lastName, password, change;
         Scanner input = new Scanner(System.in);
         boolean setCheck;
      
         System.out.print("Enter your first name: ");
         firstName = input.nextLine();
      
         System.out.print("Enter your last name: ");
         lastName = input.nextLine();
      
         UserID person = new UserID(firstName, lastName);
      
         System.out.println("\n\rName: " + firstName + " " + lastName);
         System.out.println("User ID: " + person.getId());
         System.out.println("Password: " + person.getPassword());
         
         System.out.print("\n\rWould you like to" 
            + " change your password? (y - yes, n - no): ");
         change = input.nextLine();
      	
         if (change.equals("y")) {
            System.out.print("\n\rEnter your new password: ");
            password = input.nextLine();
         	
            setCheck = person.setPassword(password);
         	
            if (setCheck) {
               System.out.println("\n\rName: " + firstName + " " + lastName);
               System.out.println("User ID: " + person.getId());
               System.out.println("Password: " + person.getPassword());
            }
            else {
               System.out.println("\n\rError. Invalid password. "
                  + "Password must be 6 or more digits.");
            }
         }
         else if (change.equals("Y")) {
            System.out.print("\n\rEnter your new password: ");
            password = input.nextLine();
         	
            setCheck = person.setPassword(password);
         	
            if (setCheck) {
               System.out.println("\n\rName: " + firstName + " " + lastName);
               System.out.println("User ID: " + person.getId());
               System.out.println("Password: " + person.getPassword());
            }
            else {
               System.out.println("\n\rError. Invalid password. "
                  + "Password must be 6 or more digits.");
            }
         }   
      }
   }
