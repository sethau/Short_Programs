   import java.util.Random;
    /** 
    * Creates a user profile that may be edited and viewed. 
	 *
	 * @author Seth Denney
	 * @version 9-25-2011
    */
   public class OnlineUserID {
   	
   	/**
   	* @value OFFLINE offline constant
   	* @value ONLINE online constant
   	*/ 
      public static final int OFFLINE = 0, ONLINE = 1;
      private String firstName, lastName, firstLow, 
      lastLow, userName, password, website, email;
      private int status = OFFLINE, loginCount = 0;
      private Random ran = new Random();
   
   	/**
   	* Constructor method for OnlineUserID class.
   	*
   	* @param first user's first name
   	* @param last user's last name
   	*/
      public OnlineUserID(String first, String last) {
      
         website = "Not specified";
         email = "Not specified";
      
         firstName = first;
         lastName = last;
         
         firstLow = first.toLowerCase();
         lastLow = last.toLowerCase();
      	
         if (lastName.length() < 3) {
            userName = lastLow + firstLow.substring(0, 3)
               + ran.nextInt(1) + "" + (ran.nextInt(6) + 3) 
               + "" + ran.nextInt(9);
         }
         else {
            userName = lastLow.substring(0, 3) + firstLow.substring(0, 3) 
               + ran.nextInt(1) + "" + (ran.nextInt(6) + 3) 
               + "" + ran.nextInt(9);
         }
         password = "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9);
      }
      
   	/**
   	* Setter for user's website.
   	*
   	* @param webAddress user's website
   	* @return successful set boolean
   	*/
      public boolean setWebsite(String webAddress) {
         String temp;
         if (webAddress.contains("www.")) {
            website = webAddress;
            temp = website;
            if (website.contains("http://")) {
               email = userName + "@" + temp.replace("http://www.", "");
            }
            else {
               email = userName + "@" + temp.replace("www.", "");
            }
            return true;
         }
         else {
            return false;
         }
      }
   	
   	/**
   	* Getter for user's website.
   	*
   	* @return user's website
   	*/
      public String getWebsite() {
         return website;
      }
   	
   	/**
   	* Getter for user's email address.
   	*
   	* @return user's email
   	*/
      public String getEmail() {
         return email;
      }
   	
   	/**
   	* Method to set user's status.
   	*
   	* @param online online or offline identifier
   	* @return successful set boolean
   	*/
      public boolean setStatus(int online) {
         if (online == OnlineUserID.ONLINE) {
            status = OnlineUserID.ONLINE;
            loginCount++;
            return true;
         }
         else if (online == OnlineUserID.OFFLINE) {
            status = OnlineUserID.OFFLINE;
            return true;
         }
         else {
            return false;
         }
      }
   	
   	/**
   	* Returns boolean regarding whether
   	* or not the user is online.
   	*
   	* @return boolean is user online?
   	*/
      public boolean isOnline() {
         return status == OnlineUserID.ONLINE;
      }
   	
   	/**
   	* Gets the number of times the user
   	* has set the status to "online".
   	*
   	* @return user's login count
   	*/
      public int getLoginCount() {
         return loginCount;
      }
      
   	/**
   	* Getter for User ID.
   	*
   	* @return User ID
   	*/
      public String getId() {
         return userName;
      }
   	
   	/**
   	* Getter for user's password.
   	*
   	* @return user's password
   	*/
      public String getPassword() {
         return password;
      }	
   	
   	/**
   	* Setter for user's password.
   	*
   	* @param newPass user's desired password
   	* @return boolean for successful set
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
   	* Generates a new random password.
   	*/
      public void generateNewPassword() {
         password = "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9) 
            + "" + ran.nextInt(9) + "" + ran.nextInt(9);
      }
      
   	/**
   	* Sets and formats output information.
   	*
   	* @return formatted user information
   	*/
      public String toString() {
         String output = "";
      	
         output += "Name: " + firstName + " " + lastName;
         output += "\rUser ID: " + userName;
         output += "\rPassword: " + password;
         output += "\rWebsite: " + website;
         output += "\rEmail: " + email;
         output += "\rStatus: ";
      	
         if (status == OnlineUserID.ONLINE) {
            output += "Online";
         }
         else {
            output += "Offline";
         }
         
         return output;
      }
   }