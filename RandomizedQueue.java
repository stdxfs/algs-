import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
public class RandomizedQueue<Item> implements Iterable<Item> {
   private int elements;
   private Item[] qu;
   private int first=0;
   private int last=0;
   public int size() {
	   return elements;
   }
   private void resizing(int sizeofq) {
	      
		Item[] tmp = (Item[])new Object[sizeofq];
	       int mark =first;
	       for(int i=0;i<sizeofq;i++) {
	    	  
	    	   if(mark<=last&&qu[mark]!=null) {	    		 
	    		   tmp[i] = qu[mark];
	    		   mark++;   
	    	   }else {
	    		   mark++;
	    	   }	    		    	   
           }
	       qu = tmp;
           }
   public RandomizedQueue() {
	   elements=0;   
	   qu = (Item[]) new Object[1];
	   // construct an empty randomized queue
   }
   public boolean isEmpty() {
	   if(elements==0) {
		   return true;// is the randomized queue empty?
	   }else {
		   return false;
	   }
   }
   private int elements() {
		return elements;// return the number of items on the randomized queue
	}
   public void enqueue(Item item) {
	   if(item == null) {
		   throw new java.lang.IllegalArgumentException();
	   }
	  
	   if(elements==0) {
		   qu[0]=item;
		   elements++;		   
	   }else {
	   qu[last+1]=item;
	   elements++;
	   last++;
	   }
	   if(last+1==qu.length)
		   resizing(2*qu.length);	   
	   }
	   // add the item
   
   public Item dequeue() {
	   if(elements==0) 
		   throw new java.util.NoSuchElementException();	   
        int hole;
        if(last<first) {
        	last=first;
        }
   	    do{
		 hole =StdRandom.uniform(first, last+1);
	    }while(qu[hole]==null);
	    Item temp = qu[hole];
   	    qu[hole]=null;
	    if(first!=last) {
	    	if(hole==last) {
	    		last--;
	    	}else {
	    		first++;
	    	}
	    }
	    elements--;
	   if(elements<qu.length/4 && elements>0){
		   resizing(qu.length/2);
	   }
	   return temp;
	   // remove and return a random item
   }
   public Item sample() {	 
	   if(isEmpty()) {
		   throw new java.util.NoSuchElementException();
	   }
	   int r;
	   do{
	       r=StdRandom.uniform(first, last+1);
		  }while(qu[r]==null);
	   return qu[r];	   
	   // return a random item (but do not remove it)
   }
   public Iterator<Item> iterator(){ 
	   return new RandomizedQueueIterator();
	   // return an independent iterator over items in random order
   }
   private class RandomizedQueueIterator implements Iterator<Item>{
	   private boolean stats[] = new boolean [qu.length];
       private int showedsites=0;
	   public boolean hasNext(){
		   if(showedsites==elements) {
			   return false;
		   }else {
			   return true;
		   }
	   }
	   public Item next(){		
	   if(hasNext()==false) {
		   throw new  java.util.NoSuchElementException();
	   }
       int ran;
	   do {
       ran=StdRandom.uniform(first,last+1);
    	
       }while(qu[ran]==null||stats[ran]==true);
	  
	   stats[ran]=true;
	   showedsites++;
	   return qu[ran];
	   }
	   public void remove(){
		   throw new java.lang.UnsupportedOperationException() ;
	   }
	  
	   
   }
   public static void main(String[] args) {
	   RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
		         rq.enqueue(916);
		         rq.isEmpty() ;    //==> false
		         rq.dequeue() ;    //==> 916
		         rq.isEmpty()  ;   //==> true
		         rq.enqueue(294);
		         rq.dequeue();
   }
}