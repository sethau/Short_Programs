   import java.util.Scanner;
   import java.text.DecimalFormat;
	/** 
    * Reads, calculates, and prints information about  
	 * the user's location and target location.
	 *
	 * @author Seth Denney
	 * @version 9-7-2011
    */
   public class LocationFinder {
   	/**
       * Reads, calculates, and prints information about the trip.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
      
         String destName;
         double curLocationX, curLocationY, tgtLocationX, 
            tgtLocationY, speed, angle, time, distance;
         DecimalFormat fmt = new DecimalFormat("0.###");
         Scanner scan = new Scanner(System.in);
      
         System.out.print("Enter your current location "
            + "coordinates (x and y):\r\n\tx1 = ");
         curLocationX = Double.parseDouble(scan.nextLine()); 
         System.out.print("\ty1 = ");
         curLocationY = Double.parseDouble(scan.nextLine());
         
         System.out.print("Enter your target location "
            + "coordinates (x and y):\r\n\tx2 = ");
         tgtLocationX = Double.parseDouble(scan.nextLine()); 
         System.out.print("\ty2 = ");
         tgtLocationY = Double.parseDouble(scan.nextLine());
      	
         System.out.print("Enter your speed: ");
         speed = Double.parseDouble(scan.nextLine());
         
         System.out.print("Enter your target location name: ");
         destName = scan.nextLine();
         System.out.println("");
      	
         distance = Math.sqrt(Math.pow((tgtLocationX 
            - curLocationX), 2) + Math.pow((tgtLocationY 
            - curLocationY), 2));
         System.out.println("Distance to \"" + destName 
            + "\": " + fmt.format(distance));
         
         angle = Math.atan2((tgtLocationY - curLocationY), 
            (tgtLocationX - curLocationX));
         System.out.println("Angle to turn: " + fmt.format(angle));
         
         time = distance / speed;
         System.out.println("Estimated time until arrival: " 
            + fmt.format(time));
      	
      }
   }