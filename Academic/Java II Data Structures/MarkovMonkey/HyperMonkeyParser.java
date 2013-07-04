   import java.util.*;
   import java.io.*;

   public class HyperMonkeyParser {
      ArrayList<HashMap<String, NavigableMap<Integer, String>>> kMap;
   	//holds the probabilities for each potential "next" char for each k-length String
      HashMap<String, NavigableMap<Integer, String>> probMap;
   	//holds the probabilities for each potential "next" char for each k-length String in a temporary format
      HashMap<String, String> tempProb;
   	//holds the number of instances of each char in original String
      HashMap<String, Integer> charProb;
   	//holds the probabilities for each potential "next" char based on original proportion
      NavigableMap<Integer, String> charWeights;
      int charTotal, level;
      Random ran = new Random();
   	
      public HyperMonkeyParser () {
         level = 0;
         kMap = new ArrayList<HashMap<String, NavigableMap<Integer, String>>>();
         probMap = new HashMap<String, NavigableMap<Integer, String>>();
         tempProb = new HashMap<String, String>();
         charProb = new HashMap<String, Integer>();
         charWeights = new TreeMap<Integer, String>();
      }
      
      public void createMap(String contents, int k) {
         createMap(contents, k, false);
      }
   	
      private void createMap(String contents, int k, boolean recurseCall) {
         int start = 0, total = 0;
         String current, list;
         Character next;
         Iterator<String> itr;
         Iterator<Character> charItr;
         NavigableMap<Integer, String> weightMap;
         HashMap<Character, Integer> temp;
         
         if (!recurseCall)
            charTotal = contents.length();
      	
         while (start + k < charTotal) {
         	//get next k-length String
            current = contents.substring(start, start + k);
         	
            if (!recurseCall) {
            	//increment appropriate entry in charProb
               if (charProb.containsKey(current.substring(0, 1)))
                  charProb.put(current.substring(0, 1), charProb.get(current.substring(0, 1)) + 1);
               else
                  charProb.put(current.substring(0, 1), 1);
            }
            
         	//build tempProb here
            if (tempProb.containsKey(current))
               tempProb.put(current, tempProb.get(current) + contents.charAt(start + k));
            else
               tempProb.put(current, String.valueOf(contents.charAt(start + k)));
         	
            start++;
         }
      	
         if (!recurseCall) {
         	//grab the last k letters and adjust charProb accordingly
            while (start < charTotal) {
               current = contents.substring(start, start + 1);
               if (charProb.containsKey(current))
                  charProb.put(current, charProb.get(current) + 1);
               else
                  charProb.put(current, 1);
               
               start++;
            }
         }
         
      	//fill in probMap with character probabilities for each k-length String
         itr = tempProb.keySet().iterator();
         while (itr.hasNext()) {
            current = itr.next();
            list = tempProb.get(current);
            weightMap = new TreeMap<Integer, String>();
            
         	//iterate through list characters to create NavigableMap for each entry in probMap
            temp = new HashMap<Character, Integer>();
            for (start = 0; start < list.length(); start++) {
               if (temp.containsKey(list.charAt(start)))
                  temp.put(list.charAt(start),
                     temp.get(list.charAt(start)) + 1);
               else
                  temp.put(list.charAt(start), 1);
            }
         	
         	//create weighted next character map for current k-length String
            total = 0;
            charItr = temp.keySet().iterator();
            while (charItr.hasNext()) {
               next = charItr.next();
               total += temp.get(next);
               weightMap.put(total, String.valueOf(next));
            }
         	
         	//add weighted next character map to probMap for current k-length String
            probMap.put(current, weightMap);
         }
         
         if (!recurseCall) {
         	//fill in charWeights from charProb here
            itr = charProb.keySet().iterator();
            total = 0;
            while (itr.hasNext()) {
               current = itr.next();
               total += charProb.get(current);
               charWeights.put(total, current);
            }
         }
         
         kMap.add((HashMap<String, NavigableMap<Integer, String>>) probMap.clone());
         probMap.clear();
         if (k > 1)
            createMap(contents, k - 1, true);
      }
      
      public void generateReplica(int length, int k, FileWriter out) {
         String replica = "", kString;
         int i, start = 0, end = k;
      	
      	//initialize kString and replica with k characters
         for (i = 0; i < k; i++) {
            replica += getRandomChar();
         }
         
         kString = replica.substring(start, end);
         
      	//continue until desired length is reached
         do {
            level = 0;
            replica += getCharAfterSequence(kString);
            start++;
            end++;
            kString = replica.substring(start, end);
         } while (replica.length() < length);
      	
         try {
            out.write(replica);
            out.close();
         } 
            catch (IOException e) {
               e.printStackTrace();
            }
      }
      
      private String getRandomChar() {
         return charWeights.get(charWeights.ceilingKey(ran.nextInt(charTotal)));
      }
      
      private String getRandomChar(NavigableMap<Integer, String> map) {
         return map.get(map.ceilingKey(ran.nextInt(map.lastEntry().getKey())));
      }
      
      private String getCharAfterSequence(String seq) {
         if (kMap.get(level).containsKey(seq)) {
            NavigableMap<Integer, String> map = kMap.get(level).get(seq);
            return getRandomChar(map);
         }
         else if (level == kMap.size() - 1)
            return getRandomChar();
         else {
            level++;
            return getCharAfterSequence(seq.substring(1));
         }
      }
   }