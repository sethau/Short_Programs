   import java.util.Comparator;
  
/**
* This Comparator sorts a list of QuizQuestion objects based on 
* ccategory and then index.
* 
* @author Seth Denney
* @version 11-13-2011
*/
   public class CategoryIndexCompare implements Comparator<QuizQuestion> {
   	
   	/**
   	* Compares two QuizQuestion objects based on category and then index.
   	*
   	* @param question1 first QuizQuestion object
   	* @param question2 second QuizQuestion object
   	* @return int identifier used for sorting
   	*/
      public int compare(QuizQuestion question1, QuizQuestion question2) {
         if (question1 instanceof MultipleChoice 
         && question2 instanceof ShortAnswer) {
            return -1;
         }
         else if (question1 instanceof ShortAnswer 
         && question2 instanceof MultipleChoice) {
            return 1;
         }
         else if (question1.getQuestionIndex().toUpperCase().compareTo(
         question2.getQuestionIndex().toUpperCase()) < 1) {
            return -1;
         }
         else if (question1.getQuestionIndex().toUpperCase().compareTo(
         question2.getQuestionIndex().toUpperCase()) > 1) {
            return 1;
         }
         else {
            return 0;
         }
      }
   }