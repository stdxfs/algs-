
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
/*
 * 读取两个命令行参数n和T，n是gird 行数，T为grid 需要Percolates的次数
 * 通过每次percolates的点数/总点数 计算平均值   标准差，通过蒙特卡洛方法得到Percolates的概率
 */

public class PercolationStats {
	   private  Percolation perco;
	   private double xn [];
	  
	  
	   public PercolationStats(int n, int trials) {
		  if(n>0&&trials>0) {
			  
		  }else {
			  throw new java.lang.IllegalArgumentException();
		  }
		 
		 xn=new double [trials] ;
		 
		 for(int i=0;i<trials;i++) { 
			 perco =new Percolation(n);
			 while(perco.percolates()==false) {
				 
			 int rowr=StdRandom.uniform(1, n+1);
			 int colr=StdRandom.uniform(1, n+1);
			 
			 if(perco.isOpen(rowr, colr)==false)
			   perco.open(rowr, colr);
			 }
	    
		 xn[i]=(double)(perco.numberOfOpenSites())/(double)(n*n);
		 perco=null;
		 }
	   } // perform trials independent experiments on an n-by-n grid
	   public  double mean() {
		   double temp=StdStats.mean(xn);
		   		   return temp;
	   }// sample mean of percolation threshold
	   public double stddev() {
		   double temp=StdStats.stddev(xn);
		   return temp;
	   }// sample standard deviation of percolation threshold
	   public double confidenceLo() {
		   return mean()-((1.96*stddev()/Math.sqrt(xn.length)));
	   }// low  endpoint of 95% confidence interval
	   public double confidenceHi() {
		   return mean()+((1.96*stddev()/Math.sqrt(xn.length)));
		   // high endpoint of 95% confidence interval
	   }

	   public static void main(String[] args) {
		  int n = Integer.parseInt(args[0]);
		  int  rials= Integer.parseInt(args[1]);
		  PercolationStats per=new PercolationStats(n,rials);
		  StdOut.println("mean"+"                    = "+per.mean());
		  StdOut.println("stddev"+"                  = "+per.stddev());
		  StdOut.println("95% confidence interval = ["+per.confidenceLo()+","+per.confidenceHi()+"]");
		  
	   }
}
