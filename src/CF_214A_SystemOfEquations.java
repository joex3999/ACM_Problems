

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_214A_SystemOfEquations {
public static void main(String []args)throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String [] s = br.readLine().split(" ");
	int n = Integer.parseInt(s[0]);
	int m = Integer.parseInt(s[1]);
	int counter =0 ;
	for(int i = 0 ; i<32 ; i++){
		for(int j =0 ; j <32 ; j++){
			if(i*i + j == n && j*j+i == m){
				counter ++;
			}
		}
	}
	System.out.println(counter);
	
}
}
