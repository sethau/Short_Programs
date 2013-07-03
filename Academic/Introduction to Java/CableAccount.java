   import java.util.ArrayList;

	/**
	* Creates a cable account for the specified owners.
	*
	* @author Seth Denney
	* @version 10-9-2011
	*/
   public class CableAccount {
   	/**
   	* @value NO_CABLE
   	* @value BASIC
   	* @value EXTENDED
   	* @value PREMIUM
   	* @value PREMIUM_PLUS
   	* @value BEST_DEAL
   	*/
      public static final int NO_CABLE = 0, 
      BASIC = 1, EXTENDED = 2, PREMIUM = 3, 
      PREMIUM_PLUS = 4, BEST_DEAL = 5;
      /**
   	* @value NO_CABLE_PRICE
   	* @value BASIC_PRICE
   	* @value EXTENDED_PRICE
   	* @value PREMIUM_PRICE
   	* @value PREMIUM_PLUS_PRICE
   	* @value BEST_DEAL_PRICE
   	*/
      public static final double NO_CABLE_PRICE = 0, 
      BASIC_PRICE = 50, EXTENDED_PRICE = 20, 
      PREMIUM_PRICE = 15.5, PREMIUM_PLUS_PRICE = 20.7, 
      BEST_DEAL_PRICE = 30.5, BOX_COST = 10;
      private int serviceType, numBoxes;
      private ArrayList<String> owners = new ArrayList<String>();
   
   	/**
   	* Constructor for CableAccount class.
   	* 
   	* @param nameIn first owner's name
   	*/
      public CableAccount(String nameIn) {
         owners.add(nameIn);
      }
   	
   	/**
   	* Adds an owner.
   	* 
   	* @param nameIn owner's name
   	* @return boolean for successful set
   	*/
      public boolean addOwner(String nameIn) {
         nameIn = nameIn.trim();
         if (!nameIn.equals("") && !owners.contains(nameIn)) {
            owners.add(nameIn); 
            return true;
         }
         else {
            return false;
         }
      }
      
   	/**
   	* Removes an owner.
   	* 
   	* @param nameIn owner's name
   	* @return boolean for successful removal
   	*/
      public boolean deleteOwner(String nameIn) {
         nameIn = nameIn.trim();
         if (!nameIn.equals("") && owners.contains(nameIn)) {
            if (owners.size() > 1) {
               owners.remove(nameIn); 
               return true;
            }
            else {
               return false;
            }
         }
         else {
            return false;
         }
      }
      
   	/**
   	* Sets desired service.
   	* 
   	* @param typeIn service type
   	* @return boolean for successful set
   	*/
      public boolean setService(int typeIn) {
      	
         switch (typeIn) {
            case NO_CABLE:
               serviceType = typeIn;
               return true;
            case BASIC:
               serviceType = typeIn;
               return true;
            case EXTENDED:
               serviceType = typeIn;
               return true;
            case PREMIUM:
               serviceType = typeIn;
               return true;
            case PREMIUM_PLUS:
               serviceType = typeIn;
               return true;
            case BEST_DEAL:
               serviceType = typeIn;
               return true;
            default:
               return false;
         }
      }
      
   	/**
   	* Sets number of cable boxes.
   	* 
   	* @param numIn number of cable boxes
   	* @return boolean for successful set
   	*/
      public boolean setCableBoxes(int numIn) {
         if (numIn >= 0 && numIn <= 15) {
            numBoxes = numIn;
            return true;
         }
         else {
            return false;
         }
      }
      
   	/**
   	* Gets type of service.
   	* 
   	* @return type of service
   	*/
      public String getServiceString() {
         switch (serviceType) {
            case NO_CABLE:
               return "No Cable";
            case BASIC:
               return "Basic";
            case EXTENDED:
               return "Extended";
            case PREMIUM:
               return "Premium";
            case PREMIUM_PLUS:
               return "Premium Plus";
            case BEST_DEAL:
               return "Best Deal";
            default:
               return "No Cable";
         }
      }
      
   	/**
   	* Calculates total service cost.
   	* 
   	* @return total service cost
   	*/
      public double totalCost() {
         double total = 0, boxTotal = 0, boxCost = BOX_COST;
         int count = 1;
      	
         switch (serviceType) {
            case BEST_DEAL:
               total += BEST_DEAL_PRICE;
            case PREMIUM_PLUS:
               total += PREMIUM_PLUS_PRICE;
            case PREMIUM:
               total += PREMIUM_PRICE;
            case EXTENDED:
               total += EXTENDED_PRICE;
            case BASIC:
               total += BASIC_PRICE;
            case NO_CABLE:
               total += NO_CABLE_PRICE;
            default:
               total += NO_CABLE_PRICE;
         }
         
         total += boxCost;
         if (numBoxes > 1) {
            for (count = 1; count < numBoxes; count++) {
               boxCost *= 0.9;
               total += boxCost;
            }
         }
         
         return total;
      }
      
   	/**
   	* Calculates cost per owner.
   	* 
   	* @return cost per owner
   	*/
      public double costPerOwner() {
         return (totalCost() / owners.size());
      }
   	
   	/**
   	* String output method.
   	* 
   	* @return String output
   	*/
      public String toString() {
         String output = "";
      	
         output += "Owners: ";
         for (String name : owners) {
            output += "\n\t" + name;
         }
      	
         output += "\n\nTotal Cost: " + totalCost();
         output += "\nCost Per Owner: " + costPerOwner();
      	
         return output;
      }
   		
   		
   	
   }