
   public class BankLoan {
   	// constant fields
      private static final int MAX_LOAN_AMOUNT = 100000;
   
      // instance variables (can be used within the class)
      private String customerName;
      private double balance, interestRate;
      public static int totalLoansCrated = 0;
   
      public BankLoan(String customer, double interest) {
         customerName = customer;
         interestRate = interest;
         balance = 0;
         totalLoansCrated++;
      }
      
      public static int getLoansCreated() {
         return totalLoansCrated;
      }
      
      public static void resetLoansCreated() {
         totalLoansCrated = 0;
      }
   
      public static boolean isAmountValid(double amount) {
         return amount >= 0;
      }
   	
      public static boolean isInDebt(BankLoan loan) {
         return loan.getBalance() > 0;
      }
      
      public boolean borrowFromBank(double amount) {
         
         boolean wasLoanMade = false;
         
         if (balance + amount < MAX_LOAN_AMOUNT) {
            wasLoanMade = true;
            balance += amount;
         }
      
         return wasLoanMade;
      }
   
      public double payBank(double amountPaid) {
         double newBalance = balance - amountPaid;
         // paid too much, return the overcharge
         if (newBalance < 0) {
            balance = 0;
            return Math.abs(newBalance);
         }
         else {
            balance = newBalance;
            return 0;
         }
      }
      
      public double getBalance() {
         return balance;
      }
      
      public boolean setInterest(double newInterest) {
      
         if (newInterest >= 0 && newInterest <= 1) {
            interestRate = newInterest;
            return true;
         }
         else {
            return false;
         }
      }
      
      public void chargeInterest() {
         balance = balance * (1 + interestRate);
      }
   
      
     // toString method
      public String toString() {
         String output = "Name: " + customerName + "\r\n" 
            + "Interest rate: " + interestRate + "%\r\n" 
            + "Balance: $" + balance + "\r\n";
         return output;
      }
   
   
   }
