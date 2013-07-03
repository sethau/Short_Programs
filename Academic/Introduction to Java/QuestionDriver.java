   public class QuestionDriver {
   
      public static void main(String[] args) {
         MultipleChoice mc1 = new MultipleChoice("1A");
         mc1.setQuestionText("Who ya gonna call?");
         mc1.addAnswer("Mom");
         mc1.addAnswer("GhostBusters");
         mc1.setCorrectOption('B');
         System.out.println(mc1.displayQuestion());
         System.out.println(mc1.displayKey());
         
         ShortAnswer sa1 = new ShortAnswer("1B");
         sa1.setQuestionText("Why am I?");
         sa1.addAnswer("Because I think.");
         sa1.addAnswer("Trick question, for I am not.");
         System.out.println(sa1.displayQuestion());
         System.out.println(sa1.displayKey());
         
         ShortAnswer sa2 = new ShortAnswer("1C");
         sa2.setQuestionText("What is the answer?");
         for (int i = 0; i < 52; i++) {
            sa2.addAnswer("Not Answer " + i);
         }
         System.out.println(sa2.displayKey());
         
         MultipleChoice mc2 = new MultipleChoice("1A");
         mc2.setQuestionText("Who ya gonna call?");
         
         if (mc1.equals(mc2)) {
            System.out.println("true");
         }
         else if (mc1.equals(mc2) == false) {
            System.out.println("false");
            
            System.out.println("mc1 Text:\n" + mc1.getQuestionText());
            System.out.println("mc2 Text:\n" + mc2.getQuestionText());
         }
      }
   }