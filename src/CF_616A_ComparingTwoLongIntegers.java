

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_616A_ComparingTwoLongIntegers {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
	String x = br.readLine();
	int xl = x.length();
	String  y = br.readLine();
	int yl = y.length();
	int gl = 0;
	if(xl>yl){
		gl=xl;
	}else{
		gl=yl;
	}
	boolean contx = true ;
	boolean conty = true ;
	for(int i =0 ; i<gl;i++){
		if(contx)
		if(x.charAt(0)=='0'){
			x= x.substring(1);
		}else{
			contx = false ;
		}
		
		if(conty)
		if(y.charAt(0)=='0'){
			y= y.substring(1);
		}else{
			conty=false;
		}
	
	}
	
	xl = x.length();
	yl = y.length();
	
	
	if(xl>yl){
		System.out.println(">");
	return ;
	}
	
	if(xl<yl){
		System.out.println("<");
	return ;
	}
	
	
	if(x.equals(y)){
		System.out.println("=");
	return ;
	}
	for(int i = 0 ; i<xl;i++){
		if(x.charAt(i)>y.charAt(i)){
			System.out.println(">");
			break;
		}else{
			if(x.charAt(i)<y.charAt(i)){
			System.out.println("<");
			break;}
		}
	}
	
}}
