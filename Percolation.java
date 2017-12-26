
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
	       private int opensites=0; 
	       private boolean [] sites;//store the property of open or not
	       private  int size ;//the number of row and col
	       private WeightedQuickUnionUF uf;//to use the method and data structure of UF
	       private int trans(int row, int col){
	    	   return col+(row-1) * size;
	       }//translate row and column to a integer ,because UF use only dimension to solve union find problem
		   public Percolation(int n)
		   {
			   if(n<=0)
                   throw new java.lang.IllegalArgumentException();
		      
			   uf=new WeightedQuickUnionUF(n*n+2);
			   
			   sites = new boolean[n*n+2];//initial boolean array ,element without initial will be false automatically
			   size=n;
			   
 		   }// create n-by-n grid, with all sites blocked
		 
		  /**
		   * 检查一个点是否open，并连接上下左右的点（如果存在）
		   * 连接最上一层和vtop，最下一层和vbot
		   * opensites 加1
		   * @param row
		   * @param col
		   */
		   public    void open(int row, int col) {
			   if(isOpen(row,col))
				   opensites--;
			   if(row<=0||row>size||col<=0||col>size) {
 				   throw new java.lang.IllegalArgumentException();
			   }
			      sites[col+(row-1)*size]=true;
			      
			      opensites++;
			      if(col>1 && isOpen(row,col-1)) {
			    	  uf.union(trans(row,col-1),trans(row,col));
			      }
			      if(row>1 && isOpen(row-1,col)) {
			    	 uf.union(trans(row-1,col),trans(row,col)); //条件检查，注意先后顺序
			      }
			      if(row<size && isOpen(row+1,col)) {
			    	  uf.union(trans(row+1,col),trans(row,col));
			      }
			      if(col<size && isOpen(row,col+1)) {
			    	  uf.union(trans(row,col+1),trans(row,col));
			      }
			      if(row==1) {
			    	  uf.union(trans(row,col), 0);
			      }
			      if(row==size) {
			    	  uf.union(trans(row,col), size*size+1);
			      }
			     
			      
		   } // open site (row, col) if it is not open already and union connected sites
		   public boolean isOpen(int row, int col) {
			   if(row<=0||col<=0||row>size||col>size){				  
				   throw new java.lang.IllegalArgumentException(); 
			   }                   
				return sites[trans(row,col)];
		   }// is site (row, col) open?
		   public boolean isFull(int row, int col) {
                if(row<=0||row>size||col<=0||col>size) {
 				   throw new java.lang.IllegalArgumentException();
			   }
               if(isOpen(row,col) && uf.connected(0, trans(row,col))) {
            	   return true;
               }else {
            	   return false;
               }
			   
		   }
			  
			
		   // is site (row, col) full?
		   public int numberOfOpenSites() 
		   {
			   return opensites;// number of open sites
		   }
		   public boolean percolates() {
			   if(uf.connected(0, size*size+1)) {
				   return true;
			   }else {
				   return false;
			   }
			  
		   } // does the system percolate?

		  public static void main(String []args) {
			     
		  }
				
		  
		   
}
 
