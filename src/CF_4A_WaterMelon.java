

import java.util.Scanner;

public class CF_4A_WaterMelon {
public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	boolean in = false;
	for(int i =2 ; i<n;i=i+2){
		if((n-i)%2==0){
			in = true ;
			break;
		}
	}
	
	if(in)
		System.out.println("YES");
	else 
		System.out.println("NO");
}
}
