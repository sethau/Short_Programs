   import javax.swing.JOptionPane;
   import java.io.File;
   import java.io.FileNotFoundException;
   import java.io.PrintWriter;
   import java.awt.Desktop;

   public class QuizConverter {
   
      public static void main(String[] args) {
         int check = 0;
         String fileIn = JOptionPane.showInputDialog("Enter the file "
            + "containing the quiz. do not forget the .qinfo extension.");
         PrintWriter fileWrite = new PrintWriter("QuizOutput.html");
         Quiz quizTest = new Quiz();
      	
         while (check == 0) {
            try {
               quizTest = Quiz.readQuizFile(fileIn);
               check = 1;
            }
               catch (FileNotFoundException fileEx) {
                  JOptionPane.showMessageDialog(null, fileEx.getMessage(),
                     "Error", JOptionPane.ERROR_MESSAGE);
                  check = 0;
               }
               catch (IllegalArgumentException argEx) {
                  JOptionPane.showMessageDialog(null, argEx.getMessage(),
                     "Error", JOptionPane.ERROR_MESSAGE);
                  check = 0;
               }
         }
         
         fileWrite.print(quizTest.toHtmlString());
         fileWrite.close();
      	
         try  // open HTML output file in desktop browser
         {
            File f = new File("QuizOutput.html");
            Desktop dt = Desktop.getDesktop();
            dt.open(f);
         }
            catch (Exception exc) { /*handle exception*/
               exc.printStackTrace();    
            }
      }
   }