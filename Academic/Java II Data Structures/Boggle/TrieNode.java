   import java.util.ArrayList;

   public class TrieNode<T> {
   
      private T element;
      private boolean isEnd;
      private ArrayList<TrieNode<T>> children;
   
      public TrieNode() {
         this.element = null;
         this.isEnd = false;
         children = new ArrayList<TrieNode<T>>();
      }
   	
      public TrieNode(T element, boolean isEnd) {
         this.element = element;
         this.isEnd = isEnd;
         children = new ArrayList<TrieNode<T>>();
      }
   
      public T getElement() {
         return element;
      }
   
      public boolean isEnd() {
         return isEnd;
      }
   
      public void addChild(T element, boolean isEnd) {
         if (!(getChild(element) == null))
            return;
         	
         TrieNode<T> node = new TrieNode<T>(element, isEnd);
      	
         children.add(node);
      }
   
      public TrieNode<T> getChild(T element) {
         for (TrieNode<T> node : children) {
            if (node.getElement() != null && node.getElement().equals(element))
               return node;
         }
      
         return null;
      }
      
      public void addSequence(T[] seq) {
         if (seq == null || seq.length == 0)
            return;
      		
         TrieNode<T> current = this;
         T[] nextSeq = (T[]) new Object[seq.length - 1];
         int i;
      	
         for (i = 1; i < seq.length; i++) {
            nextSeq[i - 1] = seq[i];
         }
      	
         current.addChild(seq[0], seq.length == 1 ? true : false);
      	
         current = current.getChild(seq[0]);
         current.addSequence(nextSeq);
      }
   	
      public boolean isFullSequence(T[] seq) {
         if (seq == null || seq.length == 0)
            return false;
      		
         TrieNode<T> current = this.getChild(seq[0]);
         
         if (current == null)
            return false;
      		
         if (seq.length == 1) {
            if (current.isEnd())
               return true;
            return false;
         }
      		
         T[] nextSeq = (T[]) new Object[seq.length - 1];
         int i;
      	
         for (i = 1; i < seq.length; i++) {
            nextSeq[i - 1] = seq[i];
         }
      	
         return current.isFullSequence(nextSeq);
      }
   }