	/**
	* This class represents a short answer question with an 
	* index and possible answer(s).
	* 
	* @author Seth Denney
	* @version 11-5-2011
	*/
   public class ShortAnswer extends QuizQuestion {
      
   	/**
   	* Parameterless constructor for ShortAnswer class.
   	*/
      public ShortAnswer() {
         setQuestionText(null);
         setQuestionIndex(null);
         answerCount = 0;
      }
   	
   	/**
   	* Parametered constructor for ShortAnswer class.
   	*
   	* @param indexIn question index
   	*/
      public ShortAnswer(String indexIn) {
         setQuestionText(null);
         setQuestionIndex(indexIn);
         answerCount = 0;
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
            output += answers[i] + "\n";
            i++;
         } while (i < MAX_ANSWERS && answers[i] != null);
         
         return output;
      }
      
   	/**
   	* Displays answer key.
   	* 
   	* @return formatted answer key
   	*/
      public String displayKey() {
         String output = "";
      	
         output += displayQuestion();
         output += displayAnswers();
         
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
         output += this.getQuestion() + "</b>\r\n      <br />"
            + "\r\n      <br />\r\n      <br />";
         
         output += "\r\n    </p>";
      
         return output;
      }
   }