/**
* This class represents a quiz question with an 
* index and possible answer(s).
* 
* @author Seth Denney
* @version 11-5-2011
*/
   public abstract class QuizQuestion implements Comparable<QuizQuestion> {
      protected String questionText, questionIndex;
      protected String[] answers = new String[52];
      protected int answerCount = 0;
      /**
   	* @value MAX_INDEX_LENGTH maximum index length
   	* @value MAX_LINE_LENGTH maximum line length in question text
   	* @value MAX_ANSWERS maximum number of possible answers
   	* @value MAX_ANSWER_LENGTH maximum length of each possible answer
   	*/
      protected static final int MAX_INDEX_LENGTH = 10, MAX_LINE_LENGTH = 50, 
      MAX_ANSWERS = 52, MAX_ANSWER_LENGTH = 40;
      
   /**
   * Sets question text.
   * 
   * @param textIn text to be set
   */
      public void setQuestionText(String textIn) {
         questionText = textIn;
      }
   
   /**
   * Gets question text.
   * 
   * @return question text
   */
      public String getQuestionText() {
         if (questionText != null) {
            return questionText;
         }
         else {
            return "";
         }
      }
   
   /**
   * Sets question index.
   * 
   * @param indexIn index to be set
   * @return boolean for valid Index
   */
      public boolean setQuestionIndex(String indexIn) {
         if (indexIn != null) {
            String trim = indexIn.trim();
         
            if (trim.length() <= MAX_INDEX_LENGTH && trim.length() >= 0) {
               questionIndex = indexIn;
               return true;
            }
            else {
               throw new IllegalArgumentException("Index '" + indexIn 
                  + "' is not a valid question index.");
            }
         }
         else {
            questionIndex = null;
            throw new IllegalArgumentException("Index '" + indexIn 
                  + "' is not a valid question index.");
         }
      }
   
   /**
   * Gets question index.
   * 
   * @return question index
   */
      public String getQuestionIndex() {
         if (questionIndex != null) {
            return questionIndex;
         }
         else {
            return "";
         }
      }
      
   	/**
   	* Displays question in appropriate form.
   	* 
   	* @return question
   	*/
      public String displayQuestion() {
         return getQuestion();
      }
      
   	/**
   	* Gets formatted question.
   	* 
   	* @return formatted question
   	*/
      protected String getQuestion() {
         String output = "";
         String[] temp = new String[getQuestionText().length()];
         int iter = 0, charCount = 0, check = 0;
      
         if (questionIndex != null) {
            output += "Question " + questionIndex + "\n";
         }
         
         if (questionText != null) {
            //don't cut words when dictating separate lines in the question
            if (questionText.length() > MAX_LINE_LENGTH) {
               temp = questionText.split(" ");
               while (iter < temp.length && check == 0) {
                  do {
                     output += temp[iter];
                     charCount += temp[iter].length();
                  	
                     if (iter + 1 > temp.length - 1) {
                        check = 1;
                     }
                     
                     if (check == 0 && charCount + temp[iter + 1].length() 
                     < MAX_LINE_LENGTH) {
                        output += " ";
                        charCount++;
                     }
                     
                     if (check == 0) {
                        iter++;
                     }
                  } while (iter < temp.length && check == 0 
                  && charCount + temp[iter].length() <= MAX_LINE_LENGTH);
                  
                  output += "\n";
                  charCount = 0;
               }
            }
            else {
               output += questionText + "\n";
            }
         }
         return output;
      }
   
   /**
   * Adds possible answer.
   * 
   * @param answerIn answer to be added
   * @return boolean for valid answer added
   */
      public boolean addAnswer(String answerIn) {
         String trim = answerIn.trim();
         
         
         if (trim.length() <= MAX_ANSWER_LENGTH 
            && trim.length() >= 1) {
            if (answerCount < MAX_ANSWERS || this instanceof ShortAnswer) {
               answers[answerCount] = trim;
               answerCount++;
               return true;
            }
            else {
               throw new IllegalArgumentException("The multiple choice answer '"
                  + answerIn + "' must not exceed 40 characters.");
            }
         }
         else {
            throw new IllegalArgumentException("The number of choices for a"
               + " multiple choice question must not exceed 52.");
         }
      }  
      
   /**
   * Returns formatted answer choices.
   * 
   * @return formatted answer choices
   */
      protected abstract String displayAnswers();
   	
   /**
   * Displays answer key.
   * 
   * @return answer key
   */
      public abstract String displayKey();
   
   /**
   * Checks two QuizQuestion objects for equality.
   * 
   * @param questionIn QuizQuestion object to be tested against
   * @return boolean for equality
   */
      public boolean equals(QuizQuestion questionIn) {
         return this.getQuestionText().equals(
            questionIn.getQuestionText()) 
            && this.getQuestionIndex().equals(
            questionIn.getQuestionIndex());
      }
      
   /**
   * I have no idea, but it satisfies Checkstyle.
   * 
   * @return 42, the answer to life, the universe, and everything
   */
      public int hashCode() {
         int answerToLifeTheUniverseAndEverything = 42;
         assert false : "hashCode not designed";
         return answerToLifeTheUniverseAndEverything;
      }  
   
      public int compareTo(QuizQuestion questionIn) {
         if (this.getQuestionText().length() > questionIn.getQuestionText().length()) {
            return 1;
         }
         else if (this.getQuestionText().length() < questionIn.getQuestionText().length()) {
            return -1;
         }
         else {
            return 0;
         }
      }
   }