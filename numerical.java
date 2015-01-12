package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class numerical {
	
	public static float calculate_root_value(float a,float b,Equation eq)
	{
		float c= (a+b)/2;
		if(eq.calculate_function_value(c) <= 0.001) return c;
		
		else if((eq.calculate_function_value(c)*eq.calculate_function_value(a))<0)
				return calculate_root_value(a,c,eq);
			
		else return calculate_root_value(c,b,eq);
	}

	public static float find_root(Equation eq)
	{
		return calculate_root_value(eq.a,eq.b,eq);
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader o=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
		int deg=Integer.parseInt(o.readLine());
		Float[] cons=new Float[deg+1];
		
		for(int i=0;i<=deg;i++)
			cons[i]=Float.parseFloat(o.readLine());
	
		Equation eq = new Equation(deg);
		eq.add_constants(cons);
		eq.display();
		eq.set_a();
		out.println(eq.get_a());
		out.println(find_root(eq));
	}
}

class Equation{
	
	int degree;
	Float[] l;;
    float a,b;
	
	Equation(int d)
	{
		degree=d;
		l=new Float[degree+1];
	}
	
	public void add_constants(Float[] c)
	{
		for(int i=0;i<=degree;i++)
			l[i]=c[i];
	}
	
	public void display()
	{
		for(int i=0;i<=degree;i++)
			System.out.println(l[i]);
	}
	
   public float calculate_function_value(float val)
	{
		float res=0;
		int k=degree;
		
		while(k>=0)
		{
			res+=l[k]*Math.pow(val,k);
			k--;
		}
		
		return res;
	}
   
   public void set_a()
	{
		Random randomGenerator= new Random();
	    
	    while(true)
		{
	    	float a1=randomGenerator.nextFloat();
		    float b1=randomGenerator.nextFloat();
	        if((calculate_function_value(a1)*calculate_function_value(b1))<0)
		     {
			    a=a1;
		        b=b1;
		        return;
		     }
        }
	 }
   
   public float get_a()
   {
	   return a;
   }
}
