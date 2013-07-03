   import java.util.ArrayList;

   public class QuizDriver {
   
      public static void main(String[] args) {
         Quiz quiz1 = new Quiz("Quiz 1");
         
         System.out.println(quiz1.toHtmlString());
      
         MultipleChoice mc1 = new MultipleChoice("2A");
         MultipleChoice mc2 = new MultipleChoice("2B");
      
         ShortAnswer sa1 = new ShortAnswer("1A");
         ShortAnswer sa2 = new ShortAnswer("1B");
      
         mc1.setQuestionText("What is your name?");
         mc2.setQuestionText("What is your game?");
         sa1.setQuestionText("Do you have fame?");
         sa2.setQuestionText("Do you have game?");
      
         mc1.addAnswer("Seth");
         mc2.addAnswer("Winning");
         sa1.addAnswer("DUH");
         sa2.addAnswer("UH COSE!");
         
         mc1.setCorrectOption('A');
         mc2.setCorrectOption('A');
      
         quiz1.addQuestion(sa2);
         quiz1.addQuestion(mc2);
         quiz1.addQuestion(sa1);
         quiz1.addQuestion(mc1);
      	
         System.out.println("Should print 1B, 2B, 1A, 2A.\n\n");
         for (QuizQuestion qq : quiz1.questionList()) {
            if (qq instanceof MultipleChoice) {
               System.out.println(((MultipleChoice) qq).displayKey());
            }
            else {
               System.out.println(((ShortAnswer) qq).displayKey());
            }
         }  
         
         System.out.println("Should print 1B, 2B, 1A, 2A.\n\n");
         for (QuizQuestion qq : quiz1.questionList(Quiz.ALL_QUESTIONS, Quiz.QUESTION_LENGTH)) {
            if (qq instanceof MultipleChoice) {
               System.out.println(((MultipleChoice) qq).displayKey());
            }
            else {
               System.out.println(((ShortAnswer) qq).displayKey());
            }
         } 
         
         System.out.println("Should print 1A, 1B, 2A, 2B.\n\n");
         for (QuizQuestion qq : quiz1.questionList(Quiz.ALL_QUESTIONS, Quiz.INDEX)) {
            if (qq instanceof MultipleChoice) {
               System.out.println(((MultipleChoice) qq).displayKey());
            }
            else {
               System.out.println(((ShortAnswer) qq).displayKey());
            }
         } 
         
         System.out.println("Should print 2A, 2B, 1A, 1B.\n\n");
         for (QuizQuestion qq : quiz1.questionList(Quiz.ALL_QUESTIONS, Quiz.CATEGORY)) {
            if (qq instanceof MultipleChoice) {
               System.out.println(((MultipleChoice) qq).displayKey());
            }
            else {
               System.out.println(((ShortAnswer) qq).displayKey());
            }
         }
      }                           
   }