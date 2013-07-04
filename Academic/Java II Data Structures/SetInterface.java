   import java.util.Iterator;

/**
 * A collection that contains no duplicate elements. 
 * More formally, sets contain no pair of elements e1 and e2 such that 
 * e1.equals(e2). Null values are not allowed as elements in the set.
 * It is not required that implementations guard against the possibility
 * that mutable elements become equal after being added to the set.
 * The property of no duplicates only has to be enforeced at the time of 
 * insertion.
 * 
 * As implied by its name, this interface models the mathematical set 
 * abstraction. All interface methods that correspond to set theoretic
 * operations must conform to the properties of those operations as
 * specified in http://en.wikipedia.org/wiki/Set_(mathematics).
 *
 * Any instance of an implementing class of SetInterface that has zero
 * elements is considered to be equivalent to the "empty set". Note that
 * the empty set can't be null.
 *
 * This interface is designed to be consistent in many respects with 
 * java.util.Set, but is not equivalent to it.
 *
 * @author	Dean Hendrix (dh@auburn.edu)
 * @version	2012-06-10
 * 
 */


   public interface SetInterface<T>
   {
   /**
    * Adds the specified element to this set if it is not already present,
    * ensuring that the collection does not contain duplicates. If this set
    * already contains the element, the call leaves the set unchanged and 
    * returns false. If the element is null, the call leaves the set 
    * unchanged and throws a NullPointerException.
    *
    * @param  e - element to be added to this set
    * @return true if element is not null and this set did not already 
    *			  contain the specified element, false otherwise.
    * @throws ClassCastException - if the class of the specified element 
    *          prevents it from being added to this set
    * @throws NullPointerException - if the specified element is null 
    */
      public boolean add (T e);
   
   
   /**
    * Adds all of the elements in the specified collection to this set 
    * if they're not already present. The addAll operation effectively 
    * modifies this set so that its value is the union of the two sets.
    * All implementations of SetInterface should ensure that the result
    * of this method is consistent with the mathematical description
    * of set union (http://en.wikipedia.org/wiki/Set_(mathematics)).
    * Note that this set and the specified set do not have to have the
    * same size. If the specified set is null, a NullPointerException 
    * is thrown. This method returns true if the set is changed as a
    * result of the call, false otherwise.
    * 
    * @param s - the set containing the elements to be added to this set
    * @return true if this set changed as a result of the call
    * @throws NullPointerException if the specified set is null
    */
      public boolean addAll (SetInterface<T> s);
   
   
   /**
    * Removes the specified element from this set if it is present.
    * After the call, the set is guaranteed to not contain the
    * specified element. If the element is null, the call leaves the
    * set unchanged and throws a NullPointerException.
    *
    * @param  e - element to be removed from this set, if present
    * @return true if the set contained the specified element
    * @throws ClassCastException - if the type of the specified element 
    *         is incompatible with this set
    * @throws NullPointerException - if the specified element is null 
    *         and this set does not permit null elements (optional)
    */
      public boolean remove (T e);
   
   
   /**
    * Selects and returns a reference to an arbitrarily selected element 
    * from this set but does not delete it. After the call, the set is unchanged.
    * If the set is empty null is returned.
    *
    * @return a reference to the selected element.
    */
      public T getRandom ();
   
   
   /**
    * Returns true if this set contains the specified element.
    * If the specified element is null, a NullPointerException is
    * thrown.
    *
    * @return true if this set contains the specified element.
    */
      public boolean contains (T e);
   
   
   /**
    * Computes and returns the union of this set with the specified set.
    * After the call, this set and the specified parameter set are
    * unchanged. If the specified set is null, a NullPointerException
    * is thrown. All implementations of SetInterface should ensure
    * that this method is consistent with the mathematical description
    * of set union (http://en.wikipedia.org/wiki/Set_(mathematics)).
    * Note that this set and the specified set do not have to have the
    * same size.
    * 
    * @param s - the set that is to be unioned with this set
    * @return a set containing all the elements in the union of this
    *         set and the specified set
    * @throws NullPointerException if the sepcified set is null.
    */
      public SetInterface<T> union (SetInterface<T> s);
   
   
   /**
    * Computes and returns the intersection of this set with the specified set.
    * After the call, this set and the specified parameter set are
    * unchanged. If the specified set is null, a NullPointerException
    * is thrown. All implementations of SetInterface should ensure
    * that this method is consistent with the mathematical description
    * of set intersection (http://en.wikipedia.org/wiki/Set_(mathematics)).
    * Note that this set and the specified set do not have to have the
    * same size.
    * 
    * @param s - the set that is to be intersected with this set
    * @return a set containing all the elements in the intersection of this
    *         set and the specified set
    * @throws NullPointerException if the sepcified set is null.
    */
      public SetInterface<T> intersection (SetInterface<T> s);
   
   
   /**
    * Computes and returns the difference of this set with the
    * specified set. Note that difference is not commutative, and
    * this method computes the difference of this set (left argument)
    * with the specified set (right argument). So, the result will
    * contain all the elements in this set but not in the specified set.
    * After the call, this set and the specified parameter set are
    * unchanged. If the specified set is null, a NullPointerException
    * is thrown. All implementations of SetInterface should ensure
    * that this method is consistent with the mathematical description
    * of set union (http://en.wikipedia.org/wiki/Set_(mathematics)).
    * Note that this set and the specified set do not have to have the
    * same size.
    *
    * @param s - the set that is to be differenced with this set
    * @return a set containing all the elements in the difference of this
    *         set and the specified set
    * @throws NullPointerException if the sepcified set is null.
    */
      public SetInterface<T> difference (SetInterface<T> s);
   
   
   /**
    * Compares the specified set with this set for equality. 
    * Returns true if the the two sets have the same size,  
    * and every member of the specified set is contained in this set
    * (or equivalently, every member of this set is contained in the
    * specified set). Note that this definition ensures that the 
    * equals method works properly across different implementations of
    * the set interface. If the specified set is null, a NullPointerException
    * is thrown.
    *
    * @param s - the set that is to be compared for equality with this set
    * @return true if this set and the specified set are equal (see above)
    * @throws NullPointerException if the sepcified set is null.
    */
      public boolean equals (SetInterface<T> s);
   
   
   /**
    * Returns true if this set has no elements.
    *
    * @return true if this set has no elements.
    */
      public boolean isEmpty();
   
   
   /**
    * Returns the number of elements in this set (its cardinality).  
    *
    * @return the number of elements in this set (its cardinality)
    */
      public int size();
   
   
   /**
    * Returns an iterator over the elements in this set. 
    * The iterator does not access the elements in any particular order.
    *
    * @return an iterator over the elements in this set
    */
      public Iterator<T> iterator();
   
   
   /**
    * Returns a string representation of this set.
    * All implementations of this interface are required to use the 
    * following format for this string.
    *
    * 		{e1, e2, e3}
    *
    * That is, all the elements should appear in a comma-separated
    * list. This list must be enclosed in curly braces. No particular
    * order is required for the elements.
    *
    * @return a string representation of this set.
    */
      public String toString();
       
       
   }
