   import java.util.Comparator;
   import java.util.Collection;

/**
 * Defines a library of selection methods.
 * 
 * @param <T>	The type of objects involved
 *
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2012-05-24
 *
 */
   public interface Selector<T>
   {
   
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
      T min(Collection<T> collection, Comparator<T> comp);
   
   
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
      T max(Collection<T> collection, Comparator<T> comp);
   
   
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
      T kmin(Collection<T> collection, Comparator<T> comp, int k);
   
   
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
      T kmax(Collection<T> collection, Comparator<T> comp, int k);
   
   
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
      Collection<T> range(Collection<T> collection, Comparator<T> comp, T low, T high);
   
   }