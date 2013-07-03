   import java.util.Random;
   
	/** 
    * Reads information about user and creates
	 * a username and a password.
	 *
	 * @author Seth Denney
	 * @version 9-18-2011
    */
   public class UserID {
   
      private String firstName, lastName, firstLow, 
      lastLow, userName = "", password;
      private Random ran = new Random();
   	
   	/** 
   	* Reads information and generates username and password.
   	*
   	* @param first first name
   	* @param last last name	
   	*/
      public UserID(String first, String last) {
      
         firstName = first;
         lastName = last;
         
         firstLow = first.toLowerCase();
         lastLow = last.toLowerCase();
      	
         if (lastLow.length() < 3) {
            userName += lastLow;
         }
         else {
            userName += lastLow.substring(0, 3);
         }
         if (firstLow.length() < 3) {
            userName += firstLow;
         }
         else {
            userName += firstLow.substring(0, 3);
         }
      
         userName += ran.nextInt(1) + "" + (ran.nextInt(6) + 3) 
               + "" + ran.nextInt(9);
         password = "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9);
      }
      
   	/** 
   	* Getter for user's username.
   	*
   	* @return username
   	*/
      public String getId() {
         return userName;
      }
   		
   	/** 
   	* Getter for the user's password.
   	*
   	* @return password
   	*/
      public String getPassword() {
         return password;
      }	
   	
   	 /** 
   	* Setter for the user's password.
   	*
   	* @param newPass desired new password
   	* @return boolean for successful password set	
   	*/	
      public boolean setPassword(String newPass) {
         if (newPass.length() > 5) {
            password = newPass;
            return true;
         }
         else {
            return false;
         } 
      }	
      
   	/** 
   	* Generates a new random 6-digit password.
   	*	
   	*/
      public void generateNewPassword() {
         password = "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9);
      }
      
   	/** 
   	* Returns user information as String.
   	*
   	* @return user information
   	*/
      public String toString() {
         String output = "";
      	
         output += firstName + " " + lastName;
         output += "\n\r" + userName;
         output += "\n\r" + password;
         
         return output;
      }
   }