	/** 
    * Reads information about user and 
	 * calculates a final grade.
	 *
	 * @author Seth Denney
	 * @version 9-18-2011
    */
   public class Grade {
      double actAvg, quizAvg, projAvg, 
      	exam1Score, exam2Score, finalExamScore;
   	
   	/** 
   	* Constructor for Grade that gets grade information.
   	*
   	* @param first first name
   	* @param last last name	
   	*/
      public Grade(double actAvg1, double quizAvg1, double projAvg1, 
      	double exam1Score1, double exam2Score1, double finalExamScore1) {
      	
         actAvg = actAvg1;
         quizAvg = quizAvg1;
         projAvg = projAvg1;
         exam1Score = exam1Score1;
         exam2Score = exam2Score1;
         finalExamScore = finalExamScore1;
      }
          
   	/** 
   	* Calculates user's final grade.
   	*
   	* @return user final grade
   	*/
      public double calculateGrade() {
         return actAvg * .1 + quizAvg * .1 + projAvg * .2
            + exam1Score * .2 + exam2Score * .2 + finalExamScore * .2;
      }
   }