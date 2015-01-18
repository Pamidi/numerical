package test;

public class newton implements method{
	
    public void solve_polynomial(polynomial p)
    {
    	System.out.println("root is" + solve(p));
    }
    
    public double solve(polynomial p)
    {
    	 if(p.cal_func_val(0)==0) return 0;
		 double x1= 3-((p.cal_func_val(3))/6),x0=3;
	
   		 while(true)
		 {
		   if(p.cal_func_val(x1)==0) return x1;
		  
		   if((p.cal_func_val(x1)<=0.001) && ((x1-x0)/x1)<=0.001)
			  return x1;
		   x0=x1;
		  
		   x1=3-((p.cal_func_val(3))/6);
		 }
    }
}
