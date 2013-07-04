/**
 *		@author seth Denney
 *		@version 2012-07-03
 *
 */

   import java.util.*;

   public class Boggle
   {
   // theBoard
      private BoggleBoard board;
   
   // game dictionary
      private BoggleDictionary dictionary;
   
      private ArrayList<String> userWords, machineWords, duplicateWords;
      
      private static boolean withCustomBoard = false;
      private static String fileName;
      
      public void playGame()
      {
         setupGame();
         userTurn();
         machineTurn();
         reportResults();
      }
   
      public void setupGame()
      {
      // setup board
         board = new BoggleBoard();
         
         if (!Boggle.withCustomBoard)
            board.setToRandomBoard();
         else
            if (!board.setToCustomBoard(Boggle.fileName))
               board.setToRandomBoard();
      
      // setup dictionary
         dictionary = new BoggleDictionary();
         dictionary.loadWords(BoggleDictionary.SMALL_WORD_LIST);
         board.dictionary = dictionary;
      
         userWords = null;
         machineWords = null;
         duplicateWords = new ArrayList<String>();
      }
      
      public void userTurn()
      {
         board.printBoard();
         
         board.findAll();
         
         System.out.println("Enter words one at a time.\r\nPress the return key twice to finish.\r\n");
         
         Scanner in = new Scanner(System.in);
         String inWord;
         ArrayList<String> words = new ArrayList<String>();
      	
         inWord = in.nextLine();
         while (inWord != null && inWord.length() > 0) {
            words.add(inWord);
            inWord = in.nextLine();
         }
         
         userWords = words;
      }
   	
      public void machineTurn()
      {
         machineWords = board.getAllLegalWords();
      }
      
      public BoggleDictionary getDictionary()
      {
         return dictionary;
      }
   	
      public void reportResults()
      {
         String output = "";
         ArrayList<String> duplicates = new ArrayList<String>();
         int userScore = 0, machineScore = 0;
      	
         output += "All User Words:";
         for (String word : userWords) {
            output += " " + word;
         }
         output += "\r\n";
      	
         userWords = board.checkWords(userWords);
         
         output += "Scorable User Words:";
         for (String word : userWords) {
            output += " " + word;
         }
         output += "\r\n\n";
      	
         output += "All Machine Words:";
         for (String word : machineWords) {
            output += " " + word;
         }
         output += "\r\n";
         
         output += "Scorable Machine Words:";
         for (String word : machineWords) {
            output += " " + word;
         }
         output += "\r\n\n";
         
         output += "Duplicate Words:";
         
         for (String word : userWords) {
            if (machineWords.contains(word))
               duplicates.add(word);
         }
         
         for (String word : duplicates) {
            output += " " + word;
         }
         output += "\r\n\n";
         
         for (String word : userWords) {
            if (word.length() == 3 || word.length() == 4)
               userScore += 1;
            if (word.length() == 5)
               userScore += 2;
            if (word.length() == 6)
               userScore += 3;
            if (word.length() == 7)
               userScore += 4;
            if (word.length() >= 8)
               userScore += 5;
         }
         
         for (String word : machineWords) {
            if (word.length() == 3 || word.length() == 4)
               machineScore += 1;
            if (word.length() == 5)
               machineScore += 2;
            if (word.length() == 6)
               machineScore += 3;
            if (word.length() == 7)
               machineScore += 4;
            if (word.length() >= 8)
               machineScore += 5;
         }
         
         output += "User Score: " + userScore + "\r\n";
         output += "Machine Score: " + machineScore + "\r\n\n";
         
         if (machineScore > userScore)
            output += "Machine Wins!";
         else if (machineScore == userScore)
            output += "Tie!";
         else
            output += "User Wins!";
      		
         System.out.println(output);
      }
   	   	
   	
      public static void main (String[] args)
      {
         Boggle boggle = new Boggle();
         
         if (args.length > 0) {
            fileName = args[0];
            withCustomBoard = true;
         }
         	
         boggle.playGame();
      }	
   
   }