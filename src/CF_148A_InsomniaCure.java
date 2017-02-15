

import java.util.Scanner;

public class CF_148A_InsomniaCure {
public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
int k = sc.nextInt();
int ks = k ;
int l =sc.nextInt();
int ls = l ;
int m = sc.nextInt();
int ms = m ;
int n = sc.nextInt();
int ns = n ;
int d=  sc.nextInt();
int result = 0 ;
for(int i =1; i<=d;i++){
 boolean pass = true ;
 if(i==ks){
	 pass= false;
	 ks+=k;
 }
 
 if(i==ls){
	 pass=false;
	 ls+=l;
 }
 if(i==ms){
	 pass = false ;
	 ms+=m;
 }
 if(i==ns){
	 pass = false ;
	 ns+=  n ;
 }
	
 if(!pass)
	 result++;
}
System.out.println(result);

}
}
