

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XUVA_441_Lotto {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = null ;
	while(!(s=br.readLine()).equals("0")){
		int n  = Integer.parseInt(""+s.charAt(0));
		String [] temp =  (s.substring(2)).split(" ");
		int [] arr = new int [n];
		for(int i =0 ; i<n;i++){
			arr[i] = Integer.parseInt(temp[i]);
		}
		
		
	}
}
}
