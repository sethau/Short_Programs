	/** 
    * Creates a grocery list from a file. 
	 *
	 * @author Seth Denney
	 * @version 10-2-2011
    */
   public class GroceryItem {
   /**
   * @value GENERAL category identifier
   * @value PRODUCE category identifier
   * @value REFRIGERATED category identifier
   * @value FROZEN category identifier
   */
      public static final String GENERAL = "General", 
      PRODUCE = "Produce", REFRIGERATED = "Refrigerated", 
      FROZEN = "Frozen";
     /**
     * @value MAX_PRICE additional cost
   * @value GENERAL_FEE additional cost
   * @value PRODUCE_TAX additional cost
   * @value REFRIGERATED_FEE additional cost
   * @value FROZEN_FEE additional cost
   */
      public static final double MAX_PRICE = 500.0, 
      GENERAL_FEE = 0.0, PRODUCE_TAX = 0.05, 
      REFRIGERATED_FEE = 1.5, FROZEN_FEE = 3.0;
      private String name, category = "General";
      private double basePrice = 0.0;
   	
   	/**
   	* Constructor for the GroceryItem class.
   	*
   	* @param nameIn name
   	* @param categoryIn category
   	*/
      public GroceryItem(String nameIn, String categoryIn) {
      //set name
         setName(nameIn);
      
      //set category
         setCategory(categoryIn);
      }
   	
   	/**
   	* Sets name.
   	*
   	* @param nameIn name
   	*/
      public void setName(String nameIn) {
         String nameTrim = nameIn.trim();
      
      //set name
         if (nameTrim.equals("")) {
            name = "(No Name)";
         }
         else {
            name = nameIn;
         }
      }
   	
   	/**
   	* Gets name.
   	*
   	* @return name
   	*/
      public String getName() {
         return name;
      }
   	
   	/**
   	* Sets base price.
   	*
   	* @param priceIn price
   	* @return int for successful set
   	*/
      public int setBasePrice(double priceIn) {
         if (priceIn > 0 && priceIn <= MAX_PRICE) {
            basePrice = priceIn;
            return 1;
         }
         else if (priceIn > MAX_PRICE) {
            return 0;
         }
         else {
            return -1;
         }
      }
   	
   	/**
   	* Gets base price.
   	*
   	* @return base price
   	*/
      public double getBasePrice() {
         return basePrice;
      }
   	
   	/**
   	* Calculates total price.
   	*
   	* @param taxRate tax rate
   	* @return total price
   	*/
      public double calculateTotalPrice(double taxRate) {
         double totalPrice;
      	
         if (taxRate >= 0.0 && taxRate <= 1.0) {
            if (category.equals(GENERAL)) {
               totalPrice = basePrice + GENERAL_FEE;
               totalPrice = totalPrice * (1 + taxRate);
               return totalPrice;
            }
            else if (category.equals(PRODUCE)) {
               totalPrice = basePrice;
               totalPrice = totalPrice * (1 + PRODUCE_TAX);
               return totalPrice;
            }
            else if (category.equals(REFRIGERATED)) {
               totalPrice = basePrice + REFRIGERATED_FEE;
               totalPrice = totalPrice * (1 + taxRate);
               return totalPrice;
            }
            else if (category.equals(FROZEN)) {
               totalPrice = basePrice + FROZEN_FEE;
               totalPrice = totalPrice * (1 + taxRate);
               return totalPrice;
            }
            else {
               return -1;
            }
         }
         else {
            return -1;
         }
      }
   	
   	/**
   	* Sets the category.
   	*
   	* @param categoryIn category
   	* @return boolean for successful set
   	*/
      public boolean setCategory(String categoryIn) {
         if (categoryIn.equals(GENERAL) || categoryIn.equals(PRODUCE) 
         || categoryIn.equals(REFRIGERATED) || categoryIn.equals(FROZEN)) {
         	
            category = categoryIn;
            return true;
         }
         else {
            return false;
         }
      }
      
   	/**
   	* Gets the category.
   	*
   	* @return category
   	*/
      public String getCategory() {
         if (category.equals(GENERAL) || category.equals(PRODUCE) 
         || category.equals(REFRIGERATED) || category.equals(FROZEN)) {
         	
            return category;
         }
         else {
            return GENERAL;
         }
      }
      
   	/**
   	* toString method.
   	*
   	* @return String output
   	*/
      public String toString() {
         String output = "";
      
         output += "Name: " + name;
         output += "\n\rCategory: " + category;
         output += "\n\rBase Price: " + basePrice;
      
         return output;
      }
   }