   import java.util.Comparator;
   
/**
* This Comparator sorts a list of QuizQuestion objects based on index.
* 
* @author Seth Denney
* @version 11-13-2011
*/
   public class IndexCompare implements Comparator<QuizQuestion> {
   
   	/**
   	* Compares two QuizQuestion objects based on index.
   	*
   	* @param question1 first QuizQuestion object
   	* @param question2 second QuizQuestion object
   	* @return int identifier used for sorting
   	*/
      public int compare(QuizQuestion question1, QuizQuestion question2) {
         if (question1.getQuestionIndex().toUpperCase().compareTo(
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