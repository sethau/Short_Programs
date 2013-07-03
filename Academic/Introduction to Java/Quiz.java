   import java.util.ArrayList;
   import java.util.Collections;
   import java.io.File;
   import java.util.Scanner;
   import javax.swing.JOptionPane;

/**
* This class represents a quiz with sortable questions.
* 
* @author Seth Denney
* @version 11-13-2011
*/
   public class Quiz {
      private String quizName;
      private ArrayList<QuizQuestion> questionList 
      = new ArrayList<QuizQuestion>();
      /**
   	* @value ALL_QUESTIONS no filtering
   	* @value MULTIPLE_CHOICE only MultipleChoice objects
   	* @value SHORT_ANSWER only ShortAnswer objects
   	* @value QUESTION_LENGTH sort by question length (natural sort)
   	* @value INDEX sort by index
   	* @value CATEGORY sort by category and then index
   	*/
      public static final int ALL_QUESTIONS = 0, 
      MULTIPLE_CHOICE = 1, SHORT_ANSWER = 2,
      QUESTION_LENGTH = 3, INDEX = 4, CATEGORY = 5;
   
   	/**
   	* Parameterless constructor for the Quiz class.
   	*/
      public Quiz() {
         setName("Today's Quiz");
      }
   	
   	/**
   	* Parametered constructor for the Quiz class.
   	* 
   	* @param nameIn quiz name
   	*/
      public Quiz(String nameIn) {
         setName(nameIn);
      }
      
   	/**
   	* Getter for quiz name.
   	*
   	* @return quiz name
   	*/
      public String getName() {
         return quizName;
      }
   	
   	/**
   	* Setter for quiz name.
   	*
   	* @param nameIn quiz nema
   	* @return boolean for successful set
   	*/
      public boolean setName(String nameIn) {
         String trim = nameIn.trim();
         if (nameIn != null) {
            if (trim.length() > 0) {
               quizName = nameIn;
               return true;
            }
            return false;
         }
         return false;
      }
      
   	/**
   	* Adds one QuizQuestion object to the quiz.
   	*
   	* @param questionIn question to be added
   	* @return boolean for valid question
   	*/
      public boolean addQuestion(QuizQuestion questionIn) {
      
         for (QuizQuestion listQuestion : questionList) {
            if (listQuestion.equals(questionIn) 
            && !questionIn.getQuestionIndex().equals("")) {
               return false;
            } 
         }
      	
         questionList.add(questionIn);
         return true;
      }
      
   	/**
   	* Removes one or more QuizQuestion objects from the quiz.
   	*
   	* @param indexIn index of question(s) to be removed
   	* @return number of questions removed
   	*/
      public int removeQuestion(String indexIn) {
         int removeCount = 0;
      	
         for (QuizQuestion listQuestion : questionList) {
            if (listQuestion.getQuestionIndex().equals(indexIn)) {
               questionList.remove(listQuestion);
               removeCount++;
            }
         }
      	
         return removeCount;
      }
      
   	/**
   	* Returns the unsorted list of questions.
   	*
   	* @return unsorted list of questions
   	*/
      public ArrayList<QuizQuestion> questionList() {
         return questionList;
      }
   	
   	/**
   	* Returns a filtered list of questions.
   	*
   	* @param questionType exclusive type of questions to be returned
   	* @return filtered list of questions by the 
   	* specified question type
   	*/
      public ArrayList<QuizQuestion> questionList(int questionType) {
         ArrayList<QuizQuestion> newList = new ArrayList<QuizQuestion>();
      	
         switch (questionType) {
            case ALL_QUESTIONS: 
               return questionList;
            case MULTIPLE_CHOICE:
               for (QuizQuestion listQuestion : questionList) {
                  if (listQuestion instanceof MultipleChoice) {
                     newList.add(listQuestion);
                  }
               }
               return newList;
            case SHORT_ANSWER:
               for (QuizQuestion listQuestion : questionList) {
                  if (listQuestion instanceof ShortAnswer) {
                     newList.add(listQuestion);
                  }
               }
               return newList;
            default: 
               return questionList;
         }
      }
   	
   	/**
   	* Returns a filtered and/or sorted list of questions.
   	*
   	* @param questionType exclusive type of questions to be returned
   	* @param sortType type of sorting to be applied
   	* @return filtered list of questions by the 
   	* specified question type
   	*/
      public ArrayList<QuizQuestion> questionList(int questionType, 
      int sortType) {
         ArrayList<QuizQuestion> newList = new ArrayList<QuizQuestion>();
      	
         switch (questionType) {
            case ALL_QUESTIONS: 
               for (QuizQuestion listQuestion : questionList) {
                  newList.add(listQuestion);
               }
               break;
            case MULTIPLE_CHOICE:
               for (QuizQuestion listQuestion : questionList) {
                  if (listQuestion instanceof MultipleChoice) {
                     newList.add(listQuestion);
                  }
               }
               break;
            case SHORT_ANSWER:
               for (QuizQuestion listQuestion : questionList) {
                  if (listQuestion instanceof ShortAnswer) {
                     newList.add(listQuestion);
                  }
               }
               break;
            default: 
               for (QuizQuestion listQuestion : questionList) {
                  newList.add(listQuestion);
               }
               break;
         }
         
         if (sortType == QUESTION_LENGTH) {
            Collections.sort(newList);
         }
         else if (sortType == INDEX) {
            IndexCompare comp = new IndexCompare();
            Collections.sort(newList, comp);
         }
         else if (sortType == CATEGORY) {
            CategoryIndexCompare comp = new CategoryIndexCompare();
            Collections.sort(newList, comp);
         }
         return newList;
      }
      
   	/**
   	* Returns an html-formatted display of the quiz.
   	*
   	* @return html quiz
   	*/
      public String toHtmlString() {
         String output = "";
      
         output += "<html>\r\n  <body>\r\n\n    <h1>\r\n      "
            + "<font color=\"blue\"> COMP 1210 Quiz 11 </font>"
            + "\r\n      <h1>";
            
      		//maybe each qq in this.questionList(get user input)?
         for (QuizQuestion qq : questionList) {
            if (qq instanceof MultipleChoice) {
               output += ((MultipleChoice) qq).toHtmlString();
            }
            else if (qq instanceof ShortAnswer) {
               output += ((ShortAnswer) qq).toHtmlString();
            }
         }
      	
         output += "\r\n\n  </body>\r\n</html>";
      
         return output;
      }
      
      public static Quiz readQuizFile(String fileNameIn) {
         Quiz quiz;
         Scanner fileScan;
         File inFile = new File(fileNameIn);
         String temp;
         MultipleChoice mc;
         ShortAnswer sa;
         
         fileScan = new Scanner(inFile);
            
         if (fileScan.hasNextLine()) {
            quiz = new Quiz(fileScan.nextLine());
         
            while (fileScan.hasNextLine()) {
               temp = fileScan.nextLine();
               if (temp.equals("mc")) {
                  mc = new MultipleChoice(fileScan.nextLine());
                  mc.setQuestionText(fileScan.nextLine());
                
                  temp = fileScan.nextLine(); 
                  while (!temp.equals("/mc")) {
                     mc.addAnswer(temp);
                     temp = fileScan.nextLine();
                  }
                  quiz.addQuestion(mc);
               }
               else if (temp.equals("sa")) {
                  sa = new ShortAnswer(fileScan.nextLine());
                  sa.setQuestionText(fileScan.nextLine());
                  temp = fileScan.nextLine(); 
                  quiz.addQuestion(sa);
               }
            }
         
            return quiz;
         }
         else {
            return null;
         }
      }
   }