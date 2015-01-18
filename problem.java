package test;

public class problem {
	
	polynomial p;
	method m;
	
	problem(polynomial k,method h){
		p=k;
		m=h;
	}
   
	public void solve()
	{
	   m.solve_polynomial(p);
	}
} 
