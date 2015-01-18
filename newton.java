package test;

public class newton implements method{
	
    double steps;
	public void solve_polynomial(polynomial p)
    {
    	System.out.println("root is" + solve(p));
    	System.out.println("steps: "+ steps);
    }
    
    public double solve(polynomial p)
    {
    	 if(p.cal_func_val(0)==0) return 0;
		 double x0=3,x1= x0-((p.cal_func_val(x0))/(2*x0));
		 steps++;
	
   		 while(true)
		 {
		   if(p.cal_func_val(x1)==0) return x1;
		  
		   if((p.cal_func_val(x1)<=0.001) && ((x1-x0)/x1)<=0.001)
			  return x1;
		   x0=x1;
		  
		   x1=x0-((p.cal_func_val(x0))/(2*x0));
		   steps++;
		 }
    }
}
