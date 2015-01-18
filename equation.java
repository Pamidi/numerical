package test;
import java.io.IOException;

public class equation {

	 public static void main(String[] args) throws IOException{
		 
		 polynomial py=new polynomial(2);
		 double[] l=new double[3];
		 l[0]=1;
		 l[1]=0;
		 l[2]=-2;
		 
		 py.set_constants(l);
		 
		 problem p=new problem(py,new newton());
	}
}
