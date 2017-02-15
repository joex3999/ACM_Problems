

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheKnightsOfTheRoundTable {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	String line = null ;
	while((line=br.readLine())!=null){
		
		String [] arr = line.split(" ");
		double  a = Double.parseDouble(arr[0]);
		double b = Double.parseDouble(arr[1]);
		double c = Double.parseDouble(arr[2]);
		double P = a + b + c ;
		double S = 0.5 * P ;
		double Area = Math.sqrt(S*(S-a)*(S-b)*(S-c));
		double radius = Area / S ;
		if(a != 0.0 && b !=0.0 && c!= 0.0){
		System.out.printf("The radius of the round table is: %.3f",radius);
		System.out.println();}else{
			double g = 0.000;
			System.out.printf("The radius of the round table is: %.3f",g);
		System.out.println();
		}
		
	}
}
}
