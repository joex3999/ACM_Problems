

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_11565_SimpleEquations {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
while(n--!=0){
	String [] temp = br.readLine().split(" ");
	int A = Integer.parseInt(temp[0]);
	int B = Integer.parseInt(temp[1]);
	int C = Integer.parseInt(temp[2]);
	
	boolean in = false ;
	for(int i =-100 ; i<=100&&!in; i++){
		for(int j=-100;j<=100&&!in;j++){
			for(int k = -100 ; k<=100&&!in;k++){
				int sum = i + j + k ;
				int mult = i*j*k;
				int square = i*i + j*j + k*k;
				if(sum==A && mult ==B &&square==C && i!=j && j!=k && i!=k){
					System.out.println(i + " " +j +" " +k);
					in = true ;
					
				}
			}
		}
	}
if(!in){
	System.out.println("No solution.");
}
}
}
}
