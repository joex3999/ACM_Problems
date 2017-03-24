

import java.util.Scanner;

public class CF_146B_LuckyMask {
	static int luckyDivision(int num){
		int resultt = 0 ;
		int mult = 1;
		while(num>0){
		if(num%10==7||num%10==4){resultt+=num%10*mult;mult*=10; }
		num=num/10;
		}
	return resultt ;	
	}
public static void main(String[]args)throws Exception{
Scanner sc = new Scanner(System.in);
int a  = sc.nextInt();
int b = sc.nextInt();
if(b>a){
	System.out.println(b);
	return;
}

int result = a+1;
while( luckyDivision(result)!=b){
	result++;
}
System.out.println(result);
}
}
