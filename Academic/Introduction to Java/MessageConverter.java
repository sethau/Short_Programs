   import java.util.Scanner;  
	/** 
    * Receives an input message and modifies it as specified by the user. 
	 *
	 * @author Seth Denney
	 * @version 9-6-2011
    */
   public class MessageConverter {
   
      /**
       * Receives an input message and modifies it as specified by the user. 
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
        
         String message, result = "";
         int outputType;
         Scanner userInput = new Scanner(System.in);
        
         System.out.print("Type in a message and press enter:\r\n\t> ");
         message = userInput.nextLine();
        
         System.out.print("\r\nOutput types:"
            + "\r\n\t1: As is"
            + "\r\n\t2: lower case"
            + "\r\n\t3: UPPER CASE"
            + "\r\n\t4: v_w_ls r_pl_c_d"
            + "\r\nEnter your choice: ");
        
         outputType = Integer.parseInt(userInput.nextLine());
        
         if (outputType == 1) { //as is
            result = message;
         }
         else if (outputType == 2) { //lower case
            result = message.toLowerCase();
         }
         else if (outputType == 3) { //upper case
            result = message.toUpperCase();
         }
         else if (outputType == 4) { //vowels replaced
            result = message.replace("a", "_");
            result = result.replace("e", "_");
            result = result.replace("i", "_");
            result = result.replace("o", "_");
            result = result.replace("u", "_");
            result = result.replace("A", "_");
            result = result.replace("E", "_");
            result = result.replace("I", "_");
            result = result.replace("O", "_");
            result = result.replace("U", "_");
         }	
         else { //invalid type input
            result = "Error: Invalid choice input.";
         }
      	
         System.out.println("\r\n" + result);
      }
   }