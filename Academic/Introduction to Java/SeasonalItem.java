   public class SeasonalItem extends InventoryItem {
      private boolean inSeason;
   
      public SeasonalItem(String nameIn, double priceIn) {
         super(nameIn, priceIn);
         setInSeason(false);
      }
   
      public void setInSeason(boolean inSeasonIn) {
         inSeason = inSeasonIn;
      }
   
      public boolean isInSeason() {
         return inSeason ? true : false;
      }
    	
      public double calculateCost() {
         return inSeason ? super.calculateCost() : price * 0.9;
      }  
      
      public String toString() {
         String output = "";
      	
         output += super.toString();
         if (inSeason) {
            output += "*In Stock*";
         }
         return output;
      }
   }