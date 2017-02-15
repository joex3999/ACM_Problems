

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_11933_SplittingNumbers {
	static public int BinToDec(String s ){
		int g = 0 ;
		for(int i =s.length() ; i>0;i--){
			char c = s.charAt(i-1);

			int pp = c-48;

			g+=pp*Math.pow(2, s.length()-i);
		}
		return g ;
		
	}
	static String DecToBin(int n){
		String b = "";
		if(n==0){
			return ""+0 ;
		}
		int msk = 1 ;
		double fec =  Math.log(n)/Math.log(2);
		int test = (int) fec;
		
		int factor = (int)Math.ceil(fec);
		if(test==factor){
			factor++;
		}
	for(int i =0 ; i<factor;i++){
		int leftmost = n&msk;
		b= leftmost + b ;
		n=n>>1;}

	return b.toString();
		
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
 int n = 0;
 boolean first = true ;
 while((n=Integer.parseInt(br.readLine()))!=0){
	int msk = 1 ;
	double fec =  Math.log(n)/Math.log(2);
	int test = (int) fec;
	String a = "";
	String b = "";
	int factor = (int)Math.ceil(fec);
	if(test==factor){
		factor++;
	}
 int index = -1 ;
for(int i=0 ; i<factor ; i++){
	int leftmost = n&msk;
	if(leftmost == 1 ) index ++;
if(leftmost == 1 && index%2==0){
	a = "1"+a;
}else{
	a = "0" + a ;
}

if(leftmost==1 && index%2!=0){
	b = "1"+b;
}else{
	b = "0"+b;
}
	n=n>>1;
}
if ( first ){

sb.append(BinToDec(a)+" "+BinToDec(b));
first = false ;
}else {

	sb.append("\n"+BinToDec(a)+" "+BinToDec(b));
}

 
 
 }
 
System.out.println(sb.toString());}
}
