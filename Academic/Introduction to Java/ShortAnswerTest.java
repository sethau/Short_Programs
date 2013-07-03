   import org.junit.Assert;
   import org.junit.Test;

  //Tests for the MultipleChoiceTest.
   public class ShortAnswerTest {
   
     /** Tests the overloaded constructor. **/
      @Test public void constructor1Test() {
         String index = "4B";
         ShortAnswer sa = new ShortAnswer(index);
         Assert.assertEquals(index, sa.getQuestionIndex());
      }
      
   	/** Tests the parameterless constructor. **/
      @Test public void constructor2Test() {
         ShortAnswer sa = new ShortAnswer();
         Assert.assertEquals("", sa.getQuestionIndex());
      }
   
     /** Tests the setQuestionText and getQuestionText method. **/
      @Test public void setQuestionTest() {
         ShortAnswer sa = new ShortAnswer();
         String question = "What is the answer?";
         sa.setQuestionText(question);
         Assert.assertEquals(question, sa.getQuestionText());
         question = null;
         sa.setQuestionText(question);
         Assert.assertEquals("", sa.getQuestionText());
      }
      
   	/** Tests the setQuestionIndex and getQuestionIndex method. **/
      @Test public void setIndexTest() {
         ShortAnswer sa = new ShortAnswer(null);
         Assert.assertEquals("", sa.getQuestionIndex());
         // test valid 10-character index
         sa.setQuestionIndex("1234567890");
         Assert.assertEquals("1234567890", sa.getQuestionIndex());
      	// test invalid 11-character index
         sa.setQuestionIndex(null);
         sa.setQuestionIndex("12345678901");
         Assert.assertEquals("", sa.getQuestionIndex());
      }
     
   	/** Tests the addAnswer return with valid and 
   	 *  invalid inputs. Should return true with a valid input
   	 *  and false with an invalid input.
   	 **/
      @Test public void addAnswerReturnTest() {
         ShortAnswer sa = new ShortAnswer();
         // the following line is 40 characters long (valid input)
         String validInput = "123456789_123456789_123456789_123456789_";
         // the following line is 41 characters long (invalid input)
         String invalidInput = "100000000_200000000_300000000_400000000_5"; 
         Assert.assertTrue(sa.addAnswer(validInput));
         Assert.assertFalse(sa.addAnswer(invalidInput));
      	// add 52 answers
         ShortAnswer sa1 = new ShortAnswer();
         for (int i = 0; i < 52; i++) {
            Assert.assertTrue(sa1.addAnswer("Answer " + i));
         }
         sa.addAnswer("Should not be added");
         String display = sa1.displayKey();
         // make sure a valid answer was added
         Assert.assertTrue(display.contains("Answer 51"));
      	// make sure the invalid answer was not added
         Assert.assertFalse(display.contains("Should not be added"));
      }
      
   	/** Basic tests for the question display.
   	 **/
      @Test public void displayTest() {
         ShortAnswer sa1 = new ShortAnswer();
         sa1.setQuestionText("What is the name of the Java compiler?");
         sa1.addAnswer("javac");
         sa1.addAnswer("javac.exe");
         String display = sa1.displayQuestion();
         Assert.assertTrue(display.contains("What is the name"));
         Assert.assertFalse(display.contains("javac"));
       	// test null and valid index  
         Assert.assertFalse(display.contains("Question"));
         sa1.setQuestionIndex("1A");
         display = sa1.displayQuestion();
         Assert.assertTrue(display.contains("Question"));
         // test null questionText
         sa1.setQuestionText(null);
         display = sa1.displayQuestion();
         Assert.assertFalse(display.contains("What is the name"));
         Assert.assertTrue(display.contains("Question"));
         // test oversized questionText w/ 51 characters
         sa1.setQuestionText("100000000 200000000 300000000 400000000 "
            + "500000000 6");
         display = sa1.displayQuestion();
         Assert.assertFalse(display.contains("400000000 500000000 6"));
         Assert.assertTrue(display.contains("400000000 500000000"));
      }
      
   	/** A basic test for the question key.
   	 **/
      @Test public void keyTest() {
         ShortAnswer sa1 = new ShortAnswer();
         sa1.setQuestionText("What is the name of the Java compiler?");
         sa1.addAnswer("javac");
         sa1.addAnswer("javac.exe");
         String key = sa1.displayKey();
         Assert.assertTrue(key.contains("What is the name"));
         Assert.assertTrue(key.contains("javac"));
      
      }
      
   	/** Checks the return of the equals method.
   	 **/
      @Test public void equalsTest() {
         ShortAnswer sa1 = new ShortAnswer("1A");
         sa1.setQuestionText("KJHDFGV?");
         
         MultipleChoice sa2 = new MultipleChoice("1A");
         sa2.setQuestionText("KJHDFGV?");
         
         Assert.assertTrue(sa1.equals(sa2));
      	
         sa2.setQuestionText("321");
      	
         Assert.assertFalse(sa1.equals(sa2));
      	
         sa2.setQuestionText("KJHDFGV?");
         sa2.setQuestionIndex("1B");
      	
         Assert.assertFalse(sa1.equals(sa2));
      }
      
   	/** Checks the return of the hashcode method.
   	 **/
      @Test public void hashCodeTest() {
         ShortAnswer sa = new ShortAnswer();
         Assert.assertEquals(42, sa.hashCode());
      }
   }
