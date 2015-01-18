package test;

public class polynomial {
     int degree;
     double[] constants;
     
     polynomial(int d){
    	 degree = d;
    	 constants=new double[degree+1];
     }
     
     public void set_constants(double[] l)
     {
    	 for(int i=0;i<=degree;i++)
    		constants[i]=l[i];
     }
     
     public double cal_func_val(double val)
     {
    	double res=0;
 		int k=degree;
 		
 		while(k>=0)
 		{
 			res+=constants[k]*Math.pow(val,k);
 			k--;
 		}
 		
 		return res;
     }
}
