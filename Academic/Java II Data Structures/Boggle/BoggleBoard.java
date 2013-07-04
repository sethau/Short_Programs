/**
 *		@author Seth Denney
 *		@version 2012-07-03
 *
 */
 
   import java.util.*;
   import java.io.*;
 
   public class BoggleBoard
   {
      public final int DEFAULT_SIZE = 4;
    
      private String[][] defaultBoard = {               
         		{"E","E","C","A"},
         		{"A","L","E","P"},
         		{"H","N","B","O"},
         		{"Q","T","T","Y"}
         		};
   
      private String[][] theBoard;
      private ArrayList<LetterDie> theDice;
      private int size;
      private String alphabet = "abcdefghijklmnopqrstuvwxyz";
      private ArrayList<String> allLegal;
      
      public static Random randomizer = new Random();
      
      public BoggleDictionary dictionary;
   
      public BoggleBoard()
      {
         size = DEFAULT_SIZE;
         initDice();
         setToDefaultBoard();
         allLegal = new ArrayList<String>();
      }
      
      public void setToRandomBoard()
      {
         if (theBoard == null) 
            return;
      	
         for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
               theBoard[row][col] = Character.toString(
                  alphabet.charAt(randomizer.nextInt(alphabet.length())));
            }
         }
      }
   	
      public void setToDefaultBoard()
      {
         theBoard = defaultBoard;
      }
      
      public boolean setToCustomBoard(String fileName)
      {
         try {
            Scanner in = new Scanner(new File(fileName));
            String content = "";
            int row = 0;
         	
            while (in.hasNextLine()) {
               content = in.nextLine().trim();
               if (content.length() > 3) {
                  theBoard[row][0] = content.substring(0,1);
                  theBoard[row][1] = content.substring(1,1);
                  theBoard[row][2] = content.substring(2,1);
                  theBoard[row][3] = content.substring(3,1);
                  row++;
               }
            }
            
            return true;
         }
            catch (IOException e) {
               return false;
            }
      }
      
      public void setBoard(String[][] board)
      {
         theBoard = board;
      }
      
      public String getLetter (int row, int col)
      {
         return isValidCell(row, col) ? theBoard[row][col] : null;
      }
      
      public boolean isValidCell (int row, int col)
      {
         return (row >= 0 && row < size() && col >= 0 && col < size());
      }
      
      private boolean isValidCell (int row, int col, ArrayList<int[]> path)
      {
         int[] pos = {row, col};
      	
         return (row >= 0 && row < size() && col >= 0 && col < size()) && !contains(path, pos);
      }
      	
      public int size()
      {
         return size;
      }
      
      public ArrayList<String> checkWords(List<String> words)
      {
         ArrayList<String> newList = new ArrayList<String>();
      	
         for (String word : words) {
            if (allLegal.contains(word) && !newList.contains(word))
               newList.add(word);
         }
      	
         return newList;
      }
   	
      public ArrayList<String> getAllLegalWords()
      {
         return allLegal;
      }
   	
      public void findAll()
      {
         int row, col;
         int[] curPos = new int[2];
         ArrayList<int[]> dummy = new ArrayList<int[]>();
         ArrayList<String> newList = new ArrayList<String>();
      	
         for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {
               curPos[0] = row;
               curPos[1] = col;
               dummy.add(curPos);
               stepLetter(dummy, "", dictionary.getDictionary());
               dummy.clear();
            }
         }
         
         for (String word : allLegal) {
            if (dictionary.isWord(word))
               newList.add(word);
         }
      	
         allLegal = newList;
      }
      
      private void stepLetter(ArrayList<int[]> soFar, String word, TrieNode<Character> curNode)
      {	
         int[] curPos = new int[2], nextPos = new int[2];
         String curLet;
         ArrayList<Integer> nextSpaces = new ArrayList<Integer>();
      	
         curPos[0] = soFar.get(soFar.size() - 1)[0];
         curPos[1] = soFar.get(soFar.size() - 1)[1];
      	
      	//get "current" letter
         curLet = theBoard[curPos[0]][curPos[1]].toLowerCase();
         word = word + curLet;
         
      	//advance to "current" node (if there)
         curNode = curNode.getChild((Character) curLet.charAt(0));
         
         if (curNode != null) {
            if (word.length() >= 3 && !allLegal.contains(word))
               allLegal.add(word);
         	
            if (!(word.length() == dictionary.getMaxLength())) {
               nextPos[0] = curPos[0] - 1;
               nextPos[1] = curPos[1] - 1;
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0] - 1;
               nextPos[1] = curPos[1];
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0] - 1;
               nextPos[1] = curPos[1] + 1;
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0];
               nextPos[1] = curPos[1] + 1;
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0] + 1;
               nextPos[1] = curPos[1] + 1;
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0] + 1;
               nextPos[1] = curPos[1];
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0] + 1;
               nextPos[1] = curPos[1] - 1;
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }
               nextPos[0] = curPos[0];
               nextPos[1] = curPos[1] - 1;
               if (isValidCell(nextPos[0], nextPos[1], soFar)) {
                  soFar.add(nextPos);
                  stepLetter(soFar, word, curNode);
                  soFar.remove(soFar.size() - 1);
               }		
            }
         }
      }
      
      private boolean contains(ArrayList<int[]> checkList, int[] arr)
      {
         for (int[] pos : checkList) {
            if (pos[0] == arr[0] && pos[1] == arr[1])
               return true;
         }
      	
         return false;
      }
   	
      public void printBoard()
      {	
         System.out.println();
         System.out.println("* * * *");
         
         for (int i = 0; i < size; i++)
         {
            for (int j = 0; j < size; j++)
               System.out.print (theBoard[i][j] + " ");
            System.out.println();
         }
      	
         System.out.println("* * * *");
         System.out.println();
      }
      
      private void initDice()
      {
      // Official Boggle(TM) dice, except for QU on die #2
         theDice = new ArrayList<LetterDie>();
         theDice.add(new LetterDie("F", "O", "R", "I", "X", "B"));
         theDice.add(new LetterDie("M", "O", "Q", "A", "B", "J")); // should have QU
         theDice.add(new LetterDie("G", "U", "R", "I", "L", "W"));
         theDice.add(new LetterDie("S", "E", "T", "U", "P", "L"));
         theDice.add(new LetterDie("C", "M", "P", "D", "A", "E"));
         theDice.add(new LetterDie("A", "C", "I", "T", "A", "O"));
         theDice.add(new LetterDie("S", "L", "C", "R", "A", "E"));
         theDice.add(new LetterDie("R", "O", "M", "A", "S", "H"));
         theDice.add(new LetterDie("N", "O", "D", "E", "S", "W"));
         theDice.add(new LetterDie("H", "E", "F", "I", "Y", "E"));
         theDice.add(new LetterDie("O", "N", "U", "D", "T", "K"));
         theDice.add(new LetterDie("T", "E", "V", "I", "G", "N"));
         theDice.add(new LetterDie("A", "N", "E", "D", "V", "Z"));
         theDice.add(new LetterDie("P", "I", "N", "E", "S", "H"));
         theDice.add(new LetterDie("A", "B", "I", "L", "Y", "T"));
         theDice.add(new LetterDie("G", "K", "Y", "L", "E", "U"));
      }
   }