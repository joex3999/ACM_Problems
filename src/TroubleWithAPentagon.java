

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TroubleWithAPentagon {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	String line = null ;
	while((line=br.readLine())!=null){
		double num = Double.parseDouble(line);
		double result = num*Math.sin(3*Math.PI/5)/Math.sin(7*Math.PI/20);
		
		System.out.printf("%.10f",result);
	System.out.println();
	}
	
}
}
