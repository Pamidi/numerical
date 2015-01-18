package test;
import java.io.IOException;
import java.util.Random;

public class method_false_position {
	
        public static void main(String[] args) throws IOException{
    	   
        	int deg=1;
    		double[] cons={1,0};
    		
    		Equation eq = new Equation(deg);
    		eq.add_constants(cons);
    		
    	if(eq.set_a())
  		  {
  			System.out.println("the interval is"+eq.a+"and"+eq.b);
  			System.out.println(find_root(eq));
  		  }
          else
  		  System.out.println("couldnot find a root");
       }
}

class Equation{
	
	int degree;
	double[] l;
    double a,b,steps;
	
	Equation(int d)
	{
		degree=d;
		l=new double[degree+1];
	}
	
	public void add_constants(double[] c)
	{
		for(int i=0;i<=degree;i++)
			l[i]=c[i];
	}
	
	public void display()
	{
		for(int i=0;i<=degree;i++)
			System.out.println(l[i]);
	}
	
   public double calculate_function_value(double val)
	{
		double res=0;
		int k=degree;
		
		while(k>=0)
		{
			res+=l[k]*Math.pow(val,k);
			k--;
		}
		
		return res;
	}
   
   public boolean set_a()
	{
		Random randomGenerator= new Random();
	    
	    double a1,b1;
		int count=0;
		while(true)
		{
	    	 b1=randomGenerator.nextInt(100);
		     a1=randomGenerator.nextInt(100)-100;
		    System.out.println(Double.toString(a1)+" " +Double.toString(b1));
	        if((calculate_function_value(a1)*calculate_function_value(b1))<=0)
		     {
			    a=a1;
		        b=b1;
		        return true;
		     }
            count++;
            if(count>1000) return false;
        }
	 }
 }

