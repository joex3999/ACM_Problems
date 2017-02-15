

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF_675A_InfiniteSequence {
	public static void main(String []args){
	Scanner sc = new Scanner(System.in);
	int x = sc.nextInt();
	int y = sc.nextInt();
	int z = sc.nextInt();
	if(y>0){

		while(y>x ){
		y=y-z;
		
	}
	}else{
		while(y<x ){
			y=y-z;
			
		}
	}
	
	if(y==x){
		System.out.println("YES");
		return ;
	}
	System.out.println("NO");
}
}
