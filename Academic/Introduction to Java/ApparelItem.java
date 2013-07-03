   /** 
    * Creates anapparel item. 
	 *
	 * @author Seth Denney
	 * @version 10-23-2011
    */
   public class ApparelItem {
   	/**
   	* @value TOTAL_SALES_ALL counter of sales of 
   	* all ApparelItem objects created
   	* @value HIGHEST_SELLING ApparelItem that 
   	* has the highest total sales
   	*/
      private static double TOTAL_SALES_ALL = 0;
      private static ApparelItem HIGHEST_SELLING = null;
      private String name;
      private String[] code = new String[3];
      private int id; 
      private double price, sales = 0;
   	
   	/**
   	* ApparelItem constructor.
   	*
   	* @param codeIn three-part product code
   	*/
      public ApparelItem(String codeIn) {
         setItemCode(codeIn);
      }
   
   	/**
   	* Sets item properties from code.
   	*
   	* @param codeIn three-part product code
   	* @return boolean for successful set
   	*/
      public boolean setItemCode(String codeIn) {
         if (codeIn.split(",").length == 3) {
            code = codeIn.split(",");
            code[0] = code[0].trim();
            code[1] = code[1].trim();
            code[2] = code[2].trim();
         
            name = code[0];
            id = Integer.parseInt(code[1]);
            price = Double.parseDouble(code[2]);
         
            return true;
         }
         else {
            return false;
         }
      }
   	
   	/**
   	* Getter for product name.
   	*
   	* @return product name
   	*/
      public String getName() {
         return name.trim();
      }
      
   	/**
   	* Getter for product id.
   	*
   	* @return product id
   	*/
      public int getId() {
         return id;
      }
   	
   	/**
   	* Getter for product price.
   	*
   	* @return product price
   	*/
      public double getPrice() {
         return price;
      }
      
   	/**
   	* Makes one sale of the product.
   	*/
      public void sellItem() {
         sales += price;
         TOTAL_SALES_ALL += price;
      	
         if (HIGHEST_SELLING == null || sales 
         > HIGHEST_SELLING.totalItemSales()) {
            HIGHEST_SELLING = this;
         }
      }
   	
   	/**
   	* Getter for total sales of product.
   	*
   	* @return total sales of the product
   	*/
      public double totalItemSales() {
         return sales;
      }
      
   	/**
   	* Getter for highest selling product.
   	*
   	* @return highest selling ApparelItem object
   	*/
      public static ApparelItem highestSeller() {
         return HIGHEST_SELLING;
      }
      
   	/**
   	* Getter for all ApparelItem sales.
   	*
   	* @return number of sales of ApparelItem objects
   	*/
      public static double allItemSales() {
         return TOTAL_SALES_ALL;
      }   
      
   	/**
   	* toString method.
   	*
   	* @return string output
   	*/
      public String toString() {
         String output = "";
      
         output += "Name: " + name;
         output += "\nID: " + id;
         output += "\nPrice: " + price;
         output += "\nTotal Sales: " + sales;
      
         return output;
      }
   }