   import org.junit.Assert;
   import org.junit.Test;

  /** Very basic tests for the MultipleChoiceTest. **/
   public class MultipleChoiceTest {
   
     /** Tests the overloaded constructor. **/
      @Test public void constructor1Test() {
         String index = "4A";
         MultipleChoice mc = new MultipleChoice(index);
         Assert.assertEquals(index, mc.getQuestionIndex());
      }
      
   	/** Tests the parameterless constructor. **/
      @Test public void constructor2Test() {
         MultipleChoice mc = new MultipleChoice();
         Assert.assertEquals("", mc.getQuestionIndex());
      }
   
     /** Tests the setQuestionText and getQuestionText method. **/
      @Test public void setQuestionTest() {
         MultipleChoice mc = new MultipleChoice();
         String question = "What is the answer?";
         mc.setQuestionText(question);
         Assert.assertEquals(question, mc.getQuestionText());
         question = null;
         mc.setQuestionText(question);
         Assert.assertEquals("", mc.getQuestionText());
      }
      
   	/** Tests the setQuestionIndex and getQuestionIndex method. **/
      @Test public void setIndexTest() {
         MultipleChoice mc = new MultipleChoice(null);
         Assert.assertEquals("", mc.getQuestionIndex());
         // test valid 10-character index
         mc.setQuestionIndex("1234567890");
         Assert.assertEquals("1234567890", mc.getQuestionIndex());
      	// test invalid 11-character index
         mc.setQuestionIndex(null);
         mc.setQuestionIndex("12345678901");
         Assert.assertEquals("", mc.getQuestionIndex());
      }
      
   	/** Tests the setIndexText return with valid and 
   	 *  invalid inputs. Should return true with a valid input
   	 *  and false with an invalid input.
   	 **/
      @Test public void setQuestionIndexReturnTest() {
         MultipleChoice mc = new MultipleChoice();
         String validInput = "1234567890"; // 10 characters or less
         String invalidInput = "1234567890z"; // more than 10 characters
         Assert.assertTrue(mc.setQuestionIndex(validInput));
         Assert.assertFalse(mc.setQuestionIndex(invalidInput));
      }
      
   	/** Tests the setIndexText functionality with valid and 
   	 *  invalid inputs. 
   	 **/
      @Test public void setQuestionIndexTest() {
         MultipleChoice mc = new MultipleChoice();
         String validInput = "1234567890"; // 10 characters or less
         String invalidInput = "1234567890z"; // more than 10 characters
         mc.setQuestionIndex(validInput);
         Assert.assertEquals(validInput, mc.getQuestionIndex());
         mc.setQuestionIndex(invalidInput); // should not change index
         Assert.assertEquals(validInput, mc.getQuestionIndex());
      }
      
   	/** Makes sure that you can't add more than 53 answers to a multiple
   	 *  choice question.
   	 **/
      @Test public void addAnswerAndDisplayTest() {
         MultipleChoice mc = new MultipleChoice();
         // add 53 answers
         for (int i = 0; i < 52; i++) {
            mc.addAnswer("Answer " + i);
         }
      	// try to add another one - it should not be added!
         mc.addAnswer("Should not be added");
         String display = mc.displayQuestion();
         // make sure a valid answer was added
         Assert.assertTrue(display.contains("Answer 51"));
      	// make sure the invalid answer was not added
         Assert.assertFalse(display.contains("Should not be added"));
         
         MultipleChoice mc1 = new MultipleChoice();
         // the following line is 40 characters long (valid input)
         String validInput = "123456789_123456789_123456789_123456789_";
         // the following line is 41 characters long (invalid input)
         String invalidInput = "100000000_200000000_300000000_400000000_5"; 
         Assert.assertTrue(mc1.addAnswer(validInput));
         Assert.assertFalse(mc1.addAnswer(invalidInput));
      }
      
   	/** Basic tests for the question display.
   	 **/
      @Test public void displayTest() {
         MultipleChoice mc2 = new MultipleChoice();
         mc2.setQuestionText("What does the Java compiler do? You "
            + "should also be making sure that lines with 50+ "
            + "characters are being written correctly; you can, "
            + "however, test that in interactions.");
         mc2.addAnswer("Run Java Programs");
         mc2.addAnswer("Compile Source Code");
         mc2.addAnswer("All of the above");
         mc2.setCorrectOption('B');
         String display = mc2.displayQuestion();
         Assert.assertTrue(display.contains("What does the"));
         Assert.assertTrue(display.contains("C. All of the above"));
         // test null and valid index  
         Assert.assertFalse(display.contains("Question"));
         mc2.setQuestionIndex("1A");
         display = mc2.displayQuestion();
         Assert.assertTrue(display.contains("Question"));
         // test null questionText
         mc2.setQuestionText(null);
         display = mc2.displayQuestion();
         Assert.assertFalse(display.contains("What is the name"));
         Assert.assertTrue(display.contains("Question"));
         // test oversized questionText w/ 51 characters
         mc2.setQuestionText("100000000 200000000 300000000 400000000 "
            + "500000000 6");
         display = mc2.displayQuestion();
         Assert.assertFalse(display.contains("400000000 500000000 6"));
         Assert.assertTrue(display.contains("400000000 500000000"));
      }
      
   	/** A basic test for the question key and correct option setter.
   	 **/
      @Test public void keyTest() {
         MultipleChoice mc2 = new MultipleChoice("4a");
         mc2.setQuestionText("What does the Java compiler do? You "
            + "should also be making sure that lines with 50+ "
            + "characters are being written correctly; you can, "
            + "however, test that in interactions.");
         mc2.addAnswer("Run Java Programs");
         mc2.addAnswer("Compile Source Code");
         mc2.addAnswer("All of the above");
         mc2.setCorrectOption('B');ccc
         String key = mc2.displayKey();
         Assert.assertTrue(key.contains("What does the"));
         Assert.assertTrue(key.contains("B. Compile Source Code"));
         Assert.assertFalse(key.contains("All of the above"));
         
      	// test valid and invalid setCorrectOption parameters
         MultipleChoice mc1 = new MultipleChoice();
         mc1.setQuestionText("dfg?");
         mc1.addAnswer("Answer A");
         mc1.addAnswer("Answer B");
         mc1.addAnswer("Answer C");
         Assert.assertTrue(mc1.setCorrectOption('A'));
         Assert.assertTrue(mc1.setCorrectOption('B'));
         Assert.assertTrue(mc1.setCorrectOption('C'));
         Assert.assertFalse(mc1.setCorrectOption('D'));
      }
      
   	/** Checks the return of the equals method.
   	 **/
      @Test public void equalsTest() {
         MultipleChoice mc1 = new MultipleChoice("1A");
         mc1.setQuestionText("KJHDFGV?");
         
         MultipleChoice mc2 = new MultipleChoice("1A");
         mc2.setQuestionText("KJHDFGV?");
         
         Assert.assertTrue(mc1.equals(mc2));
      	
         mc2.setQuestionText("321");
      	
         Assert.assertFalse(mc1.equals(mc2));
      	
         mc2.setQuestionText("KJHDFGV?");
         mc2.setQuestionIndex("1B");
      	
         Assert.assertFalse(mc1.equals(mc2));
      }
      
   	/** Checks the return of the hashcode method.
   	 **/
      @Test public void hashCodeTest() {
         MultipleChoice mc = new MultipleChoice();
         Assert.assertEquals(42, mc.hashCode());
      }
   }
