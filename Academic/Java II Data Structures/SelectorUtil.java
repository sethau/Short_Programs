   import java.util.Collection;
   import java.util.Collections;
   import java.util.Comparator;
   import java.util.Iterator;
   import java.util.Arrays;
   import java.util.ArrayList;
   import java.util.List;
   
   public class SelectorUtil<T> implements Selector<T> {
   
   /**
    * Selects the minimum element from collection, as defined by
    * the supplied Comparator for T. This method returns null if
    * the list is empty or null.
    *
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @return					minimum element in collection
    *
    */
      public T min(Collection<T> collection, Comparator<T> comp) {
      
         if (collection == null
         	|| collection.size() == 0)
            return null;
            
         T next, min = null;
         Iterator<T> itr = collection.iterator();	
      		
         while (itr.hasNext()) {	
            next = itr.next();
            
            if (min == null)
               min = next;
         	
            if (comp.compare(next, min) < 0)
               min = next;
         }
      	
         return min;
      }
   
   
   /**
    * Selects the maximum element from collection, as defined by
    * the supplied Comparator for T. This method returns null if
    * the list is empty or null.
    *
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @return					maximum element in collection
    *
    */
      public T max(Collection<T> collection, Comparator<T> comp) {
      	
         if (collection == null
         	|| collection.size() == 0)
            return null;
      		
         T next, max = null;
         Iterator<T> itr = collection.iterator();
      		
         while (itr.hasNext()) {	
            next = itr.next();
            
            if (max == null)
               max = next;
         	
            if (comp.compare(next, max) > 0)
               max = next;
         }
      	
         return max;
      }
   
   
   /**
    * Selects the kth minimum element from collection, as defined by
    * the supplied Comparator for T. This method returns null if
    * the list is empty or null, or if there is no kth minimum element.
    * Note that there is no kth minimum if k < 1, k > collection.size(),
    * or if k is larger than the number of distinct elements in the
    * collection.
    *
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @return					kth minimum element in collection
    *
    */
      public T kmin(Collection<T> collection, Comparator<T> comp, int k) {
      	
         if (collection == null || k < 1 || k > collection.size())
            return null;
      		
         int minCount = 1;
         Iterator<T> itr;
         T next, last = null;
         T[] copy = (T[]) collection.toArray();
         List copyList;
         
         Arrays.sort(copy, comp);
         copyList = Arrays.asList(copy);
      	
         itr = copyList.iterator();
      	
         while (itr.hasNext()) {	
            next = itr.next();
            
            if (last == null)
               last = next;
         	
            if (comp.compare(last, next) < 0) {
               minCount++;
               last = next;
            }
            if (minCount == k)
               return next;
         }
      	
         return null;
      }
   
   
   /**
    * Selects the kth maximum element from collection, as defined by
    * the supplied Comparator for T. This method returns null if
    * the list is empty or null, or if there is no kth maximum element.
    * Note that there is no kth maximum if k < 1, k > collection.size(),
    * or if k is larger than the number of distinct elements in the
    * collection.
    *
    * @param collection		the collection to be searched through
    * @param comp				the Comparator to use for comparison
    * @return					kth maximum element in collection
    *
    */
      public T kmax(Collection<T> collection, Comparator<T> comp, int k) {
      
         if (collection == null || k < 1 || k > collection.size())
            return null;
      	
         int maxCount = 1;
         Iterator<T> itr;
         T next, last = null;
         T[] copy = (T[]) collection.toArray();
         List copyList;
      	
         Arrays.sort(copy, comp);
         copyList = Arrays.asList(copy);
         Collections.reverse(copyList);
      	
         itr = copyList.iterator();
      	
         while (itr.hasNext()) {	
            next = itr.next();
            
            if (last == null)
               last = next;
         	
            if (comp.compare(last, next) > 0) {
               maxCount++;
               last = next;
            }
            if (maxCount == k)
               return next;
         }
      	
         return null;
      }
   
   
   /**
    * Searches collection comparing elements to both low and high with
    * the supplied Comparator. This method returns a Collection containing
    * all the elements in collection that are greater than or equal to low
    * and less than or equal to high. If collection is empty or null, this
    * method returns an empty Collection. Likewise, if there are no qualifying
    * elements, the method returns an empty Collection.
    *
    * @param collection		the collection of elements to be searched through
    * @param low				the lower bound of the range
    * @param high				the upper bound of the range
    * @param comp				the Comparator to use for comparison
    * @return					Collection of elements e such that low <= e <= high
    */
      public Collection<T> range(Collection<T> collection, Comparator<T> comp, T low, T high) {
         ArrayList<T> list = new ArrayList<T>();
         
         if (collection == null || collection.size() == 0)
            return (Collection<T>) list;
            
         Iterator<T> itr = collection.iterator();
         T element;
      		
         while (itr.hasNext()) {
            element = itr.next();
         	
            if (comp.compare(element, low) >= 0 && comp.compare(element, high) <= 0)
               list.add(element);
         }
      	
         return (Collection<T>) list;
      }
   }