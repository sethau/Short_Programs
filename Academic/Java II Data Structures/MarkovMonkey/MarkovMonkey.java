   import java.io.*;
   import java.util.*;
   
   public class MarkovMonkey {
   
      public static FileWriter out;
      private static String contents = "";
      private static int k, length;
   	
   	/* Takes in k (string length), length (output length in # of char),
   	 * input file, and output file.
   	 * If no arguments, looks in "banana.txt" for args
   	 */
      public static void main(String[] args) {
         int i = 0;
         try {
            if (args != null && args.length == 4) {
               MarkovMonkey.setInitCons(args);
            } 
            else if (args == null || args.length == 0) {
               args = new String[4];
            	
               Scanner in = new Scanner(new File("banana.txt"));
               
               while (i < 4 && in.hasNext()) {
                  args[i] = in.nextLine();
                  i++;
               }
               
               MarkovMonkey.setInitCons(args);
            } 
            else {
               System.out.println("Arguments are invalid. Application will now terminate.");
               System.exit(0);
            }
         } 
            catch (Exception e ) {
               System.out.println("'banana.txt' not found or does not provide valid arguments. Application will now terminate.");
               System.exit(0);
               e.printStackTrace();
            }
      	
      	MonkeyParser mp = new MonkeyParser();
         //HyperMonkeyParser mp = new HyperMonkeyParser(); This is the "2.0" version, if desired.
         mp.createMap(MarkovMonkey.contents, MarkovMonkey.k);
         mp.generateReplica(MarkovMonkey.length, MarkovMonkey.k, MarkovMonkey.out);
         
         System.exit(0);
      }
      
      private static void setInitCons(String[] args) {
         try {
            MarkovMonkey.k = Integer.valueOf(args[0]);
            MarkovMonkey.length = Integer.valueOf(args[1]);
            
            File source = new File(args[2]), result = new File(args[3]);
            Scanner reader = new Scanner(source);
            	
            if (k < 1 || length < 1) {
               System.out.println("Arguments are invalid. Application will now terminate.");
               System.exit(0);
            }
            	
            MarkovMonkey.out = new FileWriter(result);
            	
            while (reader.hasNext()) {
               MarkovMonkey.contents += reader.nextLine() + "\n";
            }
               
            reader.close();
               
            if (MarkovMonkey.contents.length() <= k) {
               System.out.println("Arguments are invalid. Application will now terminate.");
               System.exit(0);
            }
         } 
            catch (Exception e ) {
               System.out.println("Arguments are invalid. Application will now terminate.");
               System.exit(0);
               e.printStackTrace();
            }
      }
   }