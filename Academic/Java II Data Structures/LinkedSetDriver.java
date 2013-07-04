   import java.util.Iterator;
   
   public class LinkedSetDriver {
   
      public static void main(String[] args) {
         LinkedSet<Integer> ls1 = new LinkedSet<Integer>();
         LinkedSet<Integer> ls2 = new LinkedSet<Integer>();
         LinkedSet<Integer> ls3 = new LinkedSet<Integer>();
      	
         System.out.println("Expected: true Actual: " + ls1.isEmpty());
         System.out.println("Expected: 0 Actual: " + ls1.size());
         
         ls1.add(0);
         ls1.add(1);
         ls1.add(2);
         ls1.add(3);
         ls1.add(4);
      
         System.out.println("Expected: false Actual: " + ls1.isEmpty());
         System.out.println("Expected: 5 Actual: " + ls1.size());
         
         ls2.add(4);
         ls2.add(5);
         ls2.add(6);
         ls2.add(7);
         
         ls3.add(4);
         ls3.add(5);
         ls3.add(6);
         ls3.add(7);
         ls3.add(8);
      	
         System.out.println("Expected: true Actual: " + ls1.contains(4));
         System.out.println("Expected: false Actual: " + ls1.contains(8));
      	
         System.out.println("Expected: {0, 1, 2, 3, 4} Actual: " + ls1);
         System.out.println("Expected: {4, 5, 6, 7} Actual: " + ls2);
         
         System.out.println("Expected: false Actual: " + ls2.add(4));
         System.out.println("Expected: true Actual: " + ls2.add(8));
         
         System.out.println("Expected: {4, 5, 6, 7, 8} Actual: " + ls2);
         
         System.out.println("Expected: {0, 1, 2, 3, 4, 5, 6, 7, 8} Actual: " + ls1.union(ls2));
         
         System.out.println("Expected: true Actual: " + ls1.addAll(ls2));
         
         System.out.println("Expected: {0, 1, 2, 3, 4, 5, 6, 7, 8} Actual: " + ls1);
         
         System.out.println("Expected: {4, 5, 6, 7, 8} Actual: " + ls1.intersection(ls3));
         
         System.out.println("Expected: {0, 1, 2, 3} Actual: " + ls1.difference(ls3));
         
         System.out.println("Expected: 0 Actual: " + ls3.difference(ls1).size());
         System.out.println("Expected: {} Actual: " + ls3.difference(ls1)); //Expected: {} Actual: {, null}
         
         System.out.println("Expected: true Actual: " + ls1.remove(8));
         System.out.println("Expected: false Actual: " + ls1.remove(8));
         
         try {
            ls1.add(null);
         }
            catch (NullPointerException e) {
               System.out.println("add() passed null test");
            }
      	
         try {
            ls1.addAll(null);
         }
            catch (NullPointerException e) {
               System.out.println("addAll() passed null test");
            }
      	
         try {
            ls1.remove(null);
         }
            catch (NullPointerException e) {
               System.out.println("remove() passed null test");
            }
      	
         try {
            ls1.union(null);
         }
            catch (NullPointerException e) {
               System.out.println("union() passed null test");
            }
      	
         try {
            ls1.contains(null);
         }
            catch (NullPointerException e) {
               System.out.println("contains() passed null test");
            }
      	
         try {
            ls1.intersection(null);
         }
            catch (NullPointerException e) {
               System.out.println("intersection() passed null test");
            }
      	
         try {
            ls1.difference(null);
         }
            catch (NullPointerException e) {
               System.out.println("difference() passed null test");
            }
      	
         try {
            ls1.equals(null);
         }
            catch (NullPointerException e) {
               System.out.println("equals() passed null test");
            }
            
         System.out.println(ls1);
         for (int i = 0; i < 100; i++) {
            System.out.println(ls1.getRandom());
         }
      	
         System.out.println("Expected: null Actual: " + ls3.difference(ls3).getRandom());
         
         ls1 = new LinkedSet<Integer>();
      	
         ls1.add(99);
      	
         System.out.println("Expected: {99} Actual: " + ls1);
         
         ls1.add(1);
         ls1.add(2);
         ls1.add(3);
      	
         Iterator<Integer> itr = ls1.iterator();
      	
         System.out.print("Expected: {99 1 2 3 } Actual: {");
         while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
         }
         System.out.println("}");
      }
   }