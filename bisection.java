package test;
import java.util.Random;

public class bisection implements method{

	double a,b,steps;
	
	public boolean set_a(polynomial p)
	{
		Random randomGenerator= new Random();
	    
	    double a1,b1;
		int count=0;
		while(true)
		{
	    	 b1=randomGenerator.nextInt(100);
		     a1=randomGenerator.nextInt(100)-100;
		   // System.out.println(Double.toString(a1)+" " +Double.toString(b1));
	        if((p.cal_func_val(a1)*p.cal_func_val(b1))<=0)
		     {
			    a=a1;
		        b=b1;
		        return true;
		     }
            count++;
            if(count>1000) return false;
        }
	 }
	
	public void solve_polynomial(polynomial p)
	{
	  if(set_a(p)) {
		  System.out.println("root is" + solve(p));
		  System.out.println("steps:  "+ steps);
	  }
	  else System.out.println("no root found");
	}
	
	public double solve(polynomial p)
	{
		 if(p.cal_func_val(0)==0) return 0;
		 if(p.cal_func_val(a)==0) return a;
	     if(p.cal_func_val(b)==0) return b;
		 double cur= (a+b)/2,prev=0;
		 steps++;
	
   		 while(true)
		 {
		   if(p.cal_func_val(cur)==0) return cur;
		  
		   if((p.cal_func_val(cur)<=0.001) && ((cur-prev)/cur)<=0.001)
			  return cur;
		   prev=cur;
		  
		   if((p.cal_func_val(cur)*p.cal_func_val(a))<0)
			  b=cur;
		   else a=cur;
		  
		   cur=(a+b)/2;
		   steps++;
		 }
    }
	
}
