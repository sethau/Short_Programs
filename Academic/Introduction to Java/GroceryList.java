   import java.util.Scanner;
   import java.util.ArrayList;
   import java.io.File;
   import java.io.IOException;
   import java.text.DecimalFormat;

	/** 
    * Creates a grocery list from a file. 
	 *
	 * @author Seth Denney
	 * @version 10-2-2011
    */
   public class GroceryList {
   /** 
    	* Creates a grocery list from a file. 
   	*
      * @param args Command line arguments (not used).
   	* @throws IOException if the file cannot be read.
      */
      public static void main(String[] args) throws IOException {
         Scanner in = new Scanner(System.in);
         String fileName, input, line;
         int count = 0;
         double taxRate, totalCost = 0.0;
         ArrayList<String> inputList = new ArrayList<String>();
         ArrayList<GroceryItem> groceries = new ArrayList<GroceryItem>();
         DecimalFormat dForm = new DecimalFormat("#.##");
      
         System.out.print("Enter your file name: ");
         input = in.nextLine();
         fileName = input;
      
         Scanner fromFile = new Scanner(new File(fileName));
         
         taxRate = Double.parseDouble(fromFile.nextLine());
      	
         while (fromFile.hasNext()) {
         	//scan each line
            line = fromFile.nextLine();
         
            Scanner wordScan = new Scanner(line);
            //scan each word from the line
            while (wordScan.hasNext()) {
            	//add words to an ArrayList
               inputList.add(wordScan.next());
            }
         	
         	//add a GroceryItem object to an ArrayList
            groceries.add(count, new GroceryItem(
               inputList.get(0), inputList.get(1)));
            groceries.get(count).setBasePrice(
               Double.parseDouble(inputList.get(2)));
            inputList.clear();
            count++;
         }
         
      	
         System.out.println("\nGrocery List\n" 
            + "------------\nGeneral:");
         
         for (count = 0; count < groceries.size();
          count++) {
            if (groceries.get(count).getCategory(
            ).equals(GroceryItem.GENERAL)) {
               System.out.println("- " 
                  + groceries.get(count).getName());
            }
         }
         System.out.println("");
      	
         System.out.println("Produce:");
         for (count = 0; count < groceries.size();
          count++) {
            if (groceries.get(count).getCategory(
            ).equals(GroceryItem.PRODUCE)) {
               System.out.println("- " 
                  + groceries.get(count).getName());
            }
         }
         System.out.println("");
      	
         System.out.println("Refrigerated:");
         for (count = 0; count < groceries.size();
          count++) {
            if (groceries.get(count).getCategory(
            ).equals(GroceryItem.REFRIGERATED)) {
               System.out.println("- " 
                  + groceries.get(count).getName());
            }
         }
         System.out.println("");
      	
         System.out.println("Frozen:");
         for (count = 0; count < groceries.size();
          count++) {
            if (groceries.get(count).getCategory(
            ).equals(GroceryItem.FROZEN)) {
               System.out.println("- " 
                  + groceries.get(count).getName());
            }
         }
         System.out.println("");
      	
         totalCost = 0;
         for (count = 0; count < groceries.size();
          count++) {
            totalCost += groceries.get(
               count).calculateTotalPrice(taxRate);
         }
      	
         dForm.setMinimumFractionDigits(2);
         System.out.println("Total Cost of Items: $" 
            + dForm.format(totalCost));
      }
   	
   }
		
		
