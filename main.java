package test;
import java.io.IOException;
import java.util.*;

public class main {

	 public static void main(String[] args) throws IOException{
		 
		 polynomial p=new polynomial(2);
		 double[] l=new double[3];
		 
		 l[1]=1;
		 l[2]=0;
		 l[3]=-2;
		 
		 p.add_constants(l);
		 
		 
	 }
}
