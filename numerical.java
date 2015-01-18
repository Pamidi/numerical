package test;
import java.io.IOException;
import java.util.Random;

public class numerical {
	
	public static double calculate_root_value(Equation eq)
	{
	    if(eq.calculate_function_value(0)==0) return 0;
		if(eq.calculate_function_value(eq.a)==0) return eq.a;
	    if(eq.calculate_function_value(eq.b)==0) return eq.b;
		double cur= (eq.a+eq.b)/2,prev=0;
	
		while(true)
		{
		  
		  if(eq.calculate_function_value(cur)==0) return cur;
		  
		  if((eq.calculate_function_value(cur)<=0.001) && ((cur-prev)/cur)<=0.001)
			  return cur;
		  prev=cur;
		  
		  if((eq.calculate_function_value(cur)*eq.calculate_function_value(eq.a))<0)
			  eq.b=cur;
		  else eq.a=cur;
		  
		  cur=(eq.a+eq.b)/2;
		  eq.steps++;
		}
		
	}
	
	public static double find_root(Equation eq)
	{
		return calculate_root_value(eq);
	}
	
	
	public static void main(String[] args) throws IOException {
		
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
