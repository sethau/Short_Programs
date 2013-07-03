   import java.util.Scanner;
   
   /**
    * Driver program that takes the user's name, activity average, 
    * quiz average, project average, and exam averages as input 
    * and calculates their final grade in COMP 1210.
    *
    * @author Seth Denney
    * @version 9-21-2011
    */
   public class GradeGenerator {
   
      /**
       * Takes user name, activity average, quiz average, project 
   	 * average, and exam averages via standard input and 
   	 * calculates their final grade for COMP 1210.
       *
       * @param args Command line arguments (not used).
       */
      public static void main(String[] args) {
         double actAvg, quizAvg, projAvg, exam1Score, 
            exam2Score, finalExamScore;
         String name;
         Grade comp1210Grade;
         Scanner stdInReader = new Scanner(System.in);
         
      	// get user input for name
         System.out.print("Enter your name: ");
         name = stdInReader.nextLine();
      	
      	// get user input for activity, quiz & project averages
         System.out.print("Enter your activity average: ");
         actAvg = Double.parseDouble(stdInReader.nextLine());
         System.out.print("Enter your quiz average: ");
         quizAvg = Double.parseDouble(stdInReader.nextLine());
         System.out.print("Enter your project average: ");
         projAvg = Double.parseDouble(stdInReader.nextLine());
         
      	// get user input for exam scores
         System.out.print("Enter your exam 1 score: ");
         exam1Score = Double.parseDouble(stdInReader.nextLine());
         System.out.print("Enter your exam 2 score: ");
         exam2Score = Double.parseDouble(stdInReader.nextLine());
         System.out.print("Enter your final exam score: ");
         finalExamScore = Double.parseDouble(stdInReader.nextLine());
         
         comp1210Grade = new Grade(actAvg, quizAvg, projAvg, 
            exam1Score, exam2Score, finalExamScore);
      	
      	// print out COMP 1210 average
         System.out.print("Your average for COMP 1210 is: "
            + comp1210Grade.calculateGrade());
      }
   }