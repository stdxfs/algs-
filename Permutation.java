import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
       public static void main(String [] args) {
       RandomizedQueue<String> deck = new RandomizedQueue<String>(); 
       int k = Integer.parseInt(args[0]);
       while(true) {
    	   if(StdIn.isEmpty()==true)
    		   break;
    	   deck.enqueue(StdIn.readString());
    	  
       }
       Iterator<String> out = deck.iterator(); 
       do {
    	   StdOut.println(out.next());
    	   k--;
       }while(k>0&&out.hasNext());
     }
}
       
