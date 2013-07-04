/*
 *
 *	@author Seth Denney
 *	@version 2012-07-03
 *	
 *	An adaptor class that provides the dictionary behavior necessary
 *	for a Boggle game.
 *	
 */
	

   import java.io.*;
   import java.util.*;

   public class BoggleDictionary implements Iterable
   {
      public static final String LARGE_WORD_LIST = "sowpods.txt";
      public static final String SMALL_WORD_LIST = "bogwords.txt";
   
      private TrieNode<Character> dictionary;
      
      private int maxLength;
   
      public BoggleDictionary()
      {
         dictionary = null;
         maxLength = 0;
      }
   
      public void loadWords (String wordList)
      {
         try {
            Scanner in = new Scanner(new File(wordList));
            String content = "", next;
            
            dictionary = new TrieNode<Character>(null, false);
         	
            while (in.hasNextLine()) {
               next = in.nextLine().trim();
               if (next.length() > 2)
                  dictionary.addSequence(toCharArray(next.toCharArray()));
               maxLength = (next.length() > maxLength) ? next.length() : maxLength;
            }
            
            in.close();
         } 
            catch (FileNotFoundException e) {
               e.printStackTrace();
            }
            catch (Exception e) {
               e.printStackTrace();
            }
      }
      
      private Character[] toCharArray(char[] arr)
      {
         Character[] newArr = new Character[arr.length];
      	
         for (int i = 0; i < arr.length; i++) {
            newArr[i] = Character.valueOf(arr[i]);
         }
      	
         return newArr;
      }
      
      public TrieNode<Character> getDictionary()
      {
         return dictionary;
      }
      
      public int getMaxLength()
      {
         return maxLength;
      }
      
      public boolean isWord (String str)
      {
         return dictionary.isFullSequence(toCharArray(str.toCharArray()));
      }
   }