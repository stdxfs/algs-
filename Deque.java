import java.util.Iterator;
public class Deque<Item> implements Iterable<Item> {
    private int size = 0 ;
	private class node<Item>{
    	Item item;
    	node<Item> next;
     	node<Item> pre; 
    }
    private node<Item> first;
    private node<Item> last;
	public Deque() {
		 first =new node<Item>();
		 last=first;
         
   }	   // construct an empty deque

   public boolean isEmpty() {
	   if(size!=0) {
		   return false; 
	   }else {
		   return true;
	   }
	   // is the deque empty?
   }
   public int size() {
	   return size;// return the number of items on the deque
   }
   public void addFirst(Item item) {
	   if(item == null) {
		   throw new java.lang.IllegalArgumentException();
	   }
	   if(isEmpty()) {
		   first.item=item;
		   size++;
		   // add the item to the front
	   }else {
		   node<Item> oldfirst=first;
		   first=new node<Item>();
		   first.item=item;
		   first.next=oldfirst;
		   oldfirst.pre=first;		   
		   size++;
	   }
   }
   public void addLast(Item item) {
	   if(item == null) {
		   throw new java.lang.IllegalArgumentException();
	   }
	   if(isEmpty()) {
		   first.item=item;
		   size++;
		   //add the item to the front
	   }else {
		   node<Item> oldlast=last;
		   last=new node<Item>();
		   last.item=item;
		   oldlast.next=last;
		   last.pre=oldlast;		   
		   size++;
	   }
	   // add the item to the end
   }
   public Item removeFirst() {
	      if(isEmpty()) {
	    	  throw new java.util.NoSuchElementException();
	      }
	      if(first.next==null&first.pre==null) {	    	  
	    	  Item m = first.item;
	    	  first.item=null;size--;
	    	  return m;
	    	  
	      }else {
	      Item n = first.item;
	      first = first.next;
	      first.pre = null;
	      size--;
	      return n;
	      }
	   // remove and return the item from the front
   }
   public Item removeLast() {
	      if(isEmpty()) {
	    	  throw new java.util.NoSuchElementException();
	      } 
	      if(first.next==null&first.pre==null) {
	    	  Item m = first.item;
	    	  first.item=null;size--;
	    	  return m;
	      }else {
	      size--;
	      Item n =last.item;
	      last=last.pre;
	      last.next=null;
	      return n;
	      }
	   // remove and return the item from the end
   }
   public Iterator<Item> iterator() {
	   return new DequeIterator();
	   // return an iterator over items in order from front to end
   }
   private class DequeIterator implements Iterator<Item>{
	   private int n=size;
	   private node<Item> ite=first;
	   public boolean hasNext() {
	          return n>0;
	   }
	   
	   public Item next() {
		    if(hasNext()==false) {
		    	throw new java.util.NoSuchElementException();
		    }
		      n--;
		      
		      Item i =ite.item;
		      ite=ite.next;
		      return i;		      
	   }
	   public void remove(){
		   throw new java.lang.UnsupportedOperationException() ;
	   }
   }
   public static void main(String[] args) {

       Deque<Integer> deque = new Deque<Integer>();
       deque.addFirst(0);
       deque.removeFirst();
		         }
}