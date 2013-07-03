   import org.junit.Assert;
   import org.junit.Test;

   /** Tests the functionality of the ApparelItem class. **/
	
   public class ApparelItemTest {
   
       /*-------------------- getName tests --------------------*/
     
       /** Test getName after constructor is invoked. **/
      @Test public void nameTest() {   
         ApparelItem item = new ApparelItem("Coat,45352,10.2");
         Assert.assertEquals("Coat", item.getName());
      }
       
       /** Test getName with leading / trailing spaces in item code. **/
      @Test public void nameWithSpaceTest() {
         ApparelItem item = new ApparelItem(" Wool Scarf  ,8564,10.2");
         Assert.assertEquals("Wool Scarf", item.getName());
      }
   	
       /** Test getName after resetting the code. **/
      @Test public void nameAfterSetTest() {
         ApparelItem item = new ApparelItem("Coat,45352,10.2");
         item.setItemCode("Gloves,326,10.2");
         Assert.assertEquals("Gloves", item.getName());
      }
   
   
        /*-------------------- getId tests --------------------*/
   	  
       /** Test getId after constructor is invoked. **/
      @Test public void idTest() {
         ApparelItem item = new ApparelItem("Coat,45352,10.2");
         Assert.assertEquals(45352, item.getId());
      }
      
       /** Test getId with leading / trailing spaces in item code. **/
      @Test public void idWithSpaceTest() {
         ApparelItem item = new ApparelItem("Wool Scarf,  8564  ,10.2");
         Assert.assertEquals(8564, item.getId());
      }
    	
       /** Test getId after resetting the code. **/
      @Test public void idAfterSetTest() {
         ApparelItem item = new ApparelItem("Coat,45352,10.2");
         item.setItemCode("Gloves,326,10.2");
         Assert.assertEquals(326, item.getId());
      }
   
   
      	/*-------------------- getPrice tests --------------------*/
   		
   	/** Test getPrice after constructor is invoked. **/
      @Test public void priceTest() {
         ApparelItem item = new ApparelItem("Coat,45352,10.99");
         Assert.assertEquals(10.99, item.getPrice(), 0.01);
      }
       
      /** Test getPrice with leading / trailing spaces in item code. **/
      @Test public void priceWithSpaceTest() {
         ApparelItem item = new ApparelItem("Coat,45352, 10.99  ");
         Assert.assertEquals(10.99, item.getPrice(), 0.01);
      }
   	
       /** Test getPrice after resetting the code. **/
      @Test public void priceAfterSetTest() {
         ApparelItem item = new ApparelItem("Coat,45352, 10.99  ");
         item.setItemCode("Coat,45352, 5.99  ");
         Assert.assertEquals(5.99, item.getPrice(), 0.01);
      }
   
   
   
         /*----------- sellItem and totalItemSales tests ------------*/
   		
       /** Test sellItem and totalItemSales. **/
      @Test public void sellItemTest() {
         ApparelItem item = new ApparelItem(" Wool Scarf  ,8564,10.2");
         item.sellItem();
         Assert.assertEquals(10.2, item.totalItemSales(), 0.01);
         item.sellItem();
         item.sellItem();
         item.sellItem();
         Assert.assertEquals(40.8, item.totalItemSales(), 0.01);
      }
       
    	/** Test sellItem and totalItemSales after setItemCode. **/
      @Test public void sellItemAfterSetTest() {
         ApparelItem item = new ApparelItem("Hat,45673,5.54");
         item.sellItem();
         Assert.assertEquals(5.54, item.totalItemSales(), 0.01);
         item.setItemCode("Hat,45673,10.54");
         item.sellItem();
         item.sellItem();
         Assert.assertEquals(26.62, item.totalItemSales(), 0.01);
      }
   
   
   
   /*----------- toString tests  ------------*/
   
   /** Make sure that toString output contains name. **/
      @Test public void nameInToStringTest() {
         ApparelItem item = new ApparelItem("Hat,45673,5.54");
         Assert.assertEquals(true, item.toString().contains("Hat"));
      }
   
   
   
       /*----------- static mehtods tests  ------------*/
       /** Test allItemSales. **/
      @Test public void allItemSalesTest() {
         double salesBefore = ApparelItem.allItemSales();
         ApparelItem jeansItem = new ApparelItem("Jeans,45673,35.00");
         ApparelItem scarfItem = new ApparelItem("Scarf,45673,5.00");
         jeansItem.sellItem();
         scarfItem.sellItem();
         scarfItem.sellItem();
         Assert.assertEquals(45, ApparelItem.allItemSales() - salesBefore,
            0.01);
      }
   	
       /** Test highestSeller. **/
      @Test public void highestSellerTest() {
         double currentHighest 
            = ApparelItem.highestSeller().totalItemSales();
         ApparelItem jeansItem = new ApparelItem("Jeans,45673,35.00");
         while (jeansItem.totalItemSales() <= currentHighest) {  
            jeansItem.sellItem();
         }
         Assert.assertEquals(jeansItem, ApparelItem.highestSeller());
      }
   
   }
