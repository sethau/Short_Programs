   import java.util.Scanner;
	/** 
    * Creates a user profile that may be edited and viewed. 
	 *
	 * @author Seth Denney
	 * @version 9-25-2011
    */
   public class OnlineUsersDemo {
   
   	/** 
    	* Creates a user profile that may be edited and viewed. 
   	*
      * @param args Command line arguments (not used).
      */
      public static void main(String[] args) {
         String name, firstName, lastName, password, status, website;
         Scanner input = new Scanner(System.in);
         boolean setCheck;
      
      	//First person
         System.out.println("Enter first user's first and last name: ");
         name = input.nextLine();
      
         firstName = name.substring(0, name.indexOf(" "));
         lastName =  name.substring(name.indexOf(" ") + 1, name.length());
      
         OnlineUserID person1 = new OnlineUserID(firstName, lastName);
         
         System.out.println("Enter first user's website: ");
         website = input.nextLine();
      	
         setCheck = person1.setWebsite(website);
      	
         System.out.println("Is the first user online? (y - yes; n - no): ");
         status = input.nextLine();
      
         if (status.equals("y")) {
            person1.setStatus(OnlineUserID.ONLINE);
         }
         else if (status.equals("Y")) {
            person1.setStatus(OnlineUserID.ONLINE);
         }   
         else {
            person1.setStatus(OnlineUserID.OFFLINE);
         }
         
      	//Second person
         System.out.println("\n\rEnter second user's first and last name: ");
         name = input.nextLine();
      
         firstName = name.substring(0, name.indexOf(" "));
         lastName =  name.substring(name.indexOf(" ") + 1, name.length());
      
         OnlineUserID person2 = new OnlineUserID(firstName, lastName);
         
         System.out.println("Enter second user's website: ");
         website = input.nextLine();
      	
         setCheck = person2.setWebsite(website);
      	
         System.out.println("Is the second user online? (y - yes; n - no): ");
         status = input.nextLine();
      
         if (status.equals("y")) {
            person2.setStatus(OnlineUserID.ONLINE);
         }
         else if (status.equals("Y")) {
            person2.setStatus(OnlineUserID.ONLINE);
         }   
         else {
            person2.setStatus(OnlineUserID.OFFLINE);
         }
         
      	//Output
         System.out.println("\n*-----*-----*-----*"
            + "-----*-----*-----*-----*-----*");
         System.out.println("User #1:");
         System.out.println(person1);
         System.out.println("*-----*-----*-----*"
            + "-----*-----*-----*-----*-----*");
         System.out.println("User #2:");
         System.out.println(person2);
         System.out.println("*-----*-----*-----*"
            + "-----*-----*-----*-----*-----*");
      	
      }
   }
