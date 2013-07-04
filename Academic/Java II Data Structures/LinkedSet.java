   import java.util.Iterator;
   import java.util.Random;
 
   public class LinkedSet<T> implements SetInterface<T>
   {	
      private DoubleNode first, last;
      private int size = 0;
   
   /**
    * Parameterless constructor.
    * 
    */
      @SuppressWarnings("unchecked")
      public LinkedSet()
      {
         first = new DoubleNode();
      }
   	
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
    * @throws NullPointerException - if the specified element is null 
    */
      public boolean add (T e) {
         if (e == null)
            throw new NullPointerException();
            
         if (contains(e))
            return false;
            
         if (size == 0) {
            first = new DoubleNode(e);
            last = first;
         }
         else {
            last.setNext(new DoubleNode(e));
            last.getNext().setPrevious(last);
            last = last.getNext();
         }
         size++;
         
         return true;
      }
   	
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
      public boolean addAll (SetInterface<T> s) throws NullPointerException {
         if (s == null)
            throw new NullPointerException();
         
         Iterator<T> itr = s.iterator();
         boolean changed = false;
         
         while (itr.hasNext())
         {
            changed = add(itr.next()) || changed;
         }
         return changed;
      }
   
   /**
    * Removes the specified element from this set if it is present.
    * After the call, the set is guaranteed to not contain the
    * specified element. If the element is null, the call leaves the
    * set unchanged and throws a NullPointerException.
    *
    * @param  e - element to be removed from this set, if present
    * @return true if the set contained the specified element
    * @throws NullPointerException - if the specified element is null 
    *         and this set does not permit null elements (optional)
    */
      public boolean remove (T e) throws NullPointerException {
         if (e == null)
            throw new NullPointerException();
         
         DoubleNode dummy = first;
      	
         while (dummy != null) {
            if (dummy.getElement().equals(e)) {
               if (dummy == first) {
                  first = first.getNext();
                  first.setPrevious(null);
               }
               else if (dummy == last) {
                  dummy.getPrevious().setNext(null);
               }
               else {
                  dummy.getPrevious().setNext(dummy.getNext());
                  dummy.getNext().setPrevious(dummy.getPrevious());
               }
               size--;
               return true;
            }
            dummy = dummy.getNext();
         }
         
         return false;
      }
   
   /**
    * Selects and returns a reference to an arbitrarily selected element 
    * from this set but does not delete it. After the call, the set is unchanged.
    * If the set is empty null is returned.
    *
    * @return a reference to the selected element.
    */
      public T getRandom () {
         Random ran = new Random();
      
         if (isEmpty())
            return null;
            
         DoubleNode dummy = first;
         
         for (int i = 0; i < ran.nextInt(size + 1); i++) {
            dummy = dummy.getNext();
         }
         return (T) dummy.getElement();
      }
   
   /**
    * Returns true if this set contains the specified element.
    * If the specified element is null, a NullPointerException is
    * thrown.
    *
    * @return true if this set contains the specified element.
    */
      public boolean contains (T e) throws NullPointerException {
         if (e == null)
            throw new NullPointerException();
         
         DoubleNode dummy = first;
      	
         while (dummy != null) {
            if (dummy.getElement() != null && dummy.getElement().equals(e))
               return true;
            dummy = dummy.getNext();
         }
         
         return false;
      }
   
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
      public SetInterface<T> union (SetInterface<T> s) throws NullPointerException {
         if (s == null)
            throw new NullPointerException();
         
         SetInterface<T> newSet = new LinkedSet<T>();
         
         newSet.addAll(this);
         newSet.addAll(s);
         
         return newSet;
      }
   
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
      public SetInterface<T> intersection (SetInterface<T> s) throws NullPointerException {
         if (s == null)
            throw new NullPointerException();
         
         SetInterface<T> newSet = new LinkedSet<T>();
         DoubleNode dummy = first;
         
         while (dummy != null)
         {
            if (s.contains((T) dummy.getElement()))
               newSet.add((T) dummy.getElement());
            dummy = dummy.getNext();
         }
         
         return newSet;
      }
   
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
      public SetInterface<T> difference (SetInterface<T> s) throws NullPointerException {
         if (s == null)
            throw new NullPointerException();
            
         SetInterface<T> newSet = new LinkedSet<T>();
         DoubleNode dummy = first;
         
         while (dummy != null)
         {
            if (!s.contains((T) dummy.getElement()))
               newSet.add((T) dummy.getElement());
            dummy = dummy.getNext();
         }  
      	
         return newSet;
      }
   
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
      public boolean equals (SetInterface<T> s) throws NullPointerException {
         if (s == null)
            throw new NullPointerException();
      		
         if (size == s.size() && difference(s).size() == 0)
            return true;
      		
         return false;		
      }
   
   
   /**
    * Returns true if this set has no elements.
    *
    * @return true if this set has no elements.
    */
      public boolean isEmpty() {
         return size == 0;
      }
   
   /**
    * Returns the number of elements in this set (its cardinality).  
    *
    * @return the number of elements in this set (its cardinality)
    */
      public int size() {
         return size;
      }
   
   /**
    * Returns an iterator over the elements in this set. 
    * The iterator does not access the elements in any particular order.
    *
    * @return an iterator over the elements in this set
    */
      public Iterator<T> iterator() {
         return new LinkedSetIterator(first);
      }	
   
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
      public String toString() {
         String output = "{";
      	
         DoubleNode dummy = first;
      	
         if (size > 0) {
            output += first.getElement().toString();
            dummy = dummy.getNext();
         }
      	
         while (dummy != null && dummy.getElement() != null) {
            output += ", ";
            output += dummy.getElement();
            dummy = dummy.getNext();
         }
      	
         output += "}";
      	
         return output;
      }
      
   	/**
   	* LinkedSetIterator implements the Iterator class
   	* and provides basic Iterator functions.
   	*/
      private class LinkedSetIterator<T> implements Iterator<T> {
         private DoubleNode current;
      	
         public LinkedSetIterator(DoubleNode first) {
            current = first;
         }
      	
         public boolean hasNext() {
            return current != null && current.getElement() != null;
         }
      	
         public T next() {
            if (current == null)
               return null;
         	
            T dummy = (T) current.getElement();
         	
            current = current.getNext();
         	
            return dummy;
         }
         
         public void remove() {
            throw new UnsupportedOperationException();
         }
      }
       
   }
