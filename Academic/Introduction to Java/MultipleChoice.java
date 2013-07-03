/**
* This class represents a multiple choice question with an 
* index and possible answer(s).
* 
* @author Seth Denney
* @version 11-5-2011
*/
   public class MultipleChoice extends QuizQuestion {
      private char correctOption;
      private char[] letters = {'A', 'B', 'C', 'D', 'E', 
         'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 
         'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 
         'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
         'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
         't', 'u', 'v', 'w', 'x', 'y', 'z'};
      protected int correctIndex;
      
   	/**
   	* Parameterless constructor for MultipleChoice class.
   	*/
      public MultipleChoice() {
         setQuestionText(null);
         setQuestionIndex(null);
         answerCount = 0;
      }
   	
   	/**
   	* Parametered constructor for MultipleChoice class.
   	*
   	* @param indexIn question index
   	*/
      public MultipleChoice(String indexIn) {
         setQuestionText(null);
         setQuestionIndex(indexIn);
         answerCount = 0;
      }
   	
   	/**
   	* Displays question in appropriate form.
   	* 
   	* @return question
   	*/
      public String displayQuestion() {
         return super.getQuestion() + displayAnswers();
      }
      
      
   	/**
   	* Returns formatted answer choices.
   	* 
   	* @return formatted answer choices
   	*/
      protected String displayAnswers() {
         String output = "";
         int i = 0;
      	
         do {
            output += letters[i] + ". " + answers[i] + "\n";
            i++;
         } while (i < MAX_ANSWERS && answers[i] != null);
         
         return output;
      }
   	
   	/**
   	* Sets correct answer.
   	* 
   	* @param correct correct answer id
   	* @return boolean for valid answer choice
   	*/
      public boolean setCorrectOption(char correct) {
         int i = 0;
      	
         do {
            if (letters[i] == correct) {
               if (answers[i] != null) {
                  correctOption = correct;
                  correctIndex = i;
                  return true;
               }
               else {
                  return false;
               }
            }
            i++;
         } while (i < MAX_ANSWERS);
         
         return false;
      }
   	
   	/**
   	* Gets correct answer id.
   	* 
   	* @return correct answer id
   	*/
      public char getCorrectOption() {
         return correctOption;
      }
      
   	/**
   	* Displays answer key.
   	* 
   	* @return formatted answer key
   	*/
      public String displayKey() {
         String output = "";
      	
         output += getQuestion();
         output += getCorrectOption() + ". ";
         output += answers[correctIndex] + "\n";
         
         return output;
      }
      
   	/**
   	* Returns an html-formatted display of the question.
   	*
   	* @return html question
   	*/
      public String toHtmlString() {
         String output = "";
      
         output += "\r\n\n    <p>\r\n      <b>" 
            + this.getQuestionIndex() + ". ";
         output += this.getQuestion() + "</b>";
      	
         int i = 0;
         do {
            output += "\r\n      <br />";
            output += letters[i] + ". " + answers[i];
            i++;
         } while (i < MAX_ANSWERS && answers[i] != null);
         
         output += "\r\n    </p>";
      
         return output;
      }
   }