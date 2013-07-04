   import java.util.Iterator;
   
   public class ArraySetDriver {
   
      public static void main(String[] args) {
         ArraySet<Integer> as1 = new ArraySet<Integer>(5);
         ArraySet<Integer> as2 = new ArraySet<Integer>(5);
         ArraySet<Integer> as3 = new ArraySet<Integer>(5);
      	
         System.out.println("Expected: true Actual: " + as1.isEmpty());
         System.out.println("Expected: 0 Actual: " + as1.size());
         
         as1.add(0);
         as1.add(1);
         as1.add(2);
         as1.add(3);
         as1.add(4);
      
         System.out.println("Expected: false Actual: " + as1.isEmpty());
         System.out.println("Expected: 5 Actual: " + as1.size());
         
         as2.add(4);
         as2.add(5);
         as2.add(6);
         as2.add(7);
         
         as3.add(4);
         as3.add(5);
         as3.add(6);
         as3.add(7);
         as3.add(8);
      	
         System.out.println("Expected: true Actual: " + as1.contains(4));
         System.out.println("Expected: false Actual: " + as1.contains(8));
      	
         System.out.println("Expected: {0, 1, 2, 3, 4} Actual: " + as1);
         System.out.println("Expected: {4, 5, 6, 7} Actual: " + as2);
         
         System.out.println("Expected: false Actual: " + as2.add(4));
         System.out.println("Expected: true Actual: " + as2.add(8));
         
         System.out.println("Expected: {4, 5, 6, 7, 8} Actual: " + as2);
         
         System.out.println("Expected: {0, 1, 2, 3, 4, 5, 6, 7, 8} Actual: " + as1.union(as2));
         
         System.out.println("Expected: true Actual: " + as1.addAll(as2));
         
         System.out.println("Expected: {0, 1, 2, 3, 4, 5, 6, 7, 8} Actual: " + as1);
         
         System.out.println("Expected: {4, 5, 6, 7, 8} Actual: " + as1.intersection(as3));
         
         System.out.println("Expected: {0, 1, 2, 3} Actual: " + as1.difference(as3));
         
         System.out.println("Expected: {} Actual: " + as3.difference(as1));
         
         System.out.println("Expected: true Actual: " + as1.remove(8));
         System.out.println("Expected: false Actual: " + as1.remove(8));
         
         try {
            as1.add(null);
         }
            catch (NullPointerException e) {
               System.out.println("add() passed null test");
            }
      	
         try {
            as1.addAll(null);
         }
            catch (NullPointerException e) {
               System.out.println("addAll() passed null test");
            }
      	
         try {
            as1.remove(null);
         }
            catch (NullPointerException e) {
               System.out.println("remove() passed null test");
            }
      	
         try {
            as1.union(null);
         }
            catch (NullPointerException e) {
               System.out.println("union() passed null test");
            }
      	
         try {
            as1.contains(null);
         }
            catch (NullPointerException e) {
               System.out.println("contains() passed null test");
            }
      	
         try {
            as1.intersection(null);
         }
            catch (NullPointerException e) {
               System.out.println("intersection() passed null test");
            }
      	
         try {
            as1.difference(null);
         }
            catch (NullPointerException e) {
               System.out.println("difference() passed null test");
            }
      	
         try {
            as1.equals(null);
         }
            catch (NullPointerException e) {
               System.out.println("equals() passed null test");
            }
            
         System.out.println(as1);
         for (int i = 0; i < 40; i++) {
            System.out.println(as1.getRandom());
         }
      	
         System.out.println("Expected: null Actual: " + as3.difference(as3).getRandom());
         
         as1 = new ArraySet<Integer>(0);
      	
         as1.add(99);
      	
         System.out.println("Expected: {99} Actual: " + as1);
         
         as1.add(1);
         as1.add(2);
         as1.add(3);
      	
         Iterator<Integer> itr = as1.iterator();
      	
         System.out.print("Expected: {99 1 2 3 } Actual: {");
         while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
         }
         System.out.println("}");
      }
   }