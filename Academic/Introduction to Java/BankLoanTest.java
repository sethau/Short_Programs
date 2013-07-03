   import org.junit.Assert;
   import org.junit.Before;
   import org.junit.Test;


   public class BankLoanTest {
   
      BankLoan loan1 = new BankLoan("Bob", 0.08);
   	
      @Test public void addBalanceTest() {
      
         loan1.borrowFromBank(100);
      	
         Assert.assertEquals("The getBalance method returned an incorrect "
            + "value after $100 was added.", 100, loan1.getBalance(), 0.01);
      }
   	
      @Test public void amountValidTest() {
         boolean test;
      	
         test = loan1.isAmountValid(-1);
      	
         Assert.assertEquals("isAmountValid failed for value -1.", false, loan1.isAmountValid(-1));
         Assert.assertEquals("isAmountValid failed for value 1.", true, loan1.isAmountValid(1));
      }
   }
