

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_401_Palindromes {
	static boolean isPalindrome(String s ){
		int length = s.length();
		boolean result = true ;
		for(int i = 0 ; i<length/2;i++){
			if(!(s.charAt(i)==s.charAt(length-1-i))){
				result = false ;
			}
		}
		return result ;
	}
	static boolean isMirror(String s){
		int length = s.length();
		boolean result = true ;
		for(int i = 0 ; i<length/2;i++){
			if(!(s.charAt(i)==theMirror(s.charAt(length-1-i)))){
				result = false ;
			}
		}
		return result ;
	}
	static char theMirror(char g ){
		switch(g){
		case 'A' : return 'A';
		case 'E' : return '3';
		case 'H' : return 'H' ;
		case 'I' : return 'I' ;
		case 'J' : return 'L' ;
		case 'L' : return 'J' ;
		case 'M' : return 'M'; 
		case 'O' : return 'O' ;
		case 'S' : return '2' ;
		case 'T' : return 'T' ;
		case 'U' : return 'U';
		case 'V' : return 'V' ;
		case 'W' : return 'W';
		case 'X' : return 'X';
		case 'Y' : return 'Y';
		case 'Z' : return '5';
		case '1' : return '1';
		case '2':return 'S';
		case '3': return 'E';
		case '5' :return 'Z' ;
		case'8' : return '8';
		
		}
		return ' ';
	}
	
public static void main (String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String f = null ;
	while((f=br.readLine())!=null){
		String [] line = f.split(" ");
		String s = line[0];
		boolean mirror = isMirror(s);
		boolean pal = isPalindrome(s);
System.out.println(mirror);
System.out.println(pal);
//	  if(mirror&&pal){
//		  result += " -- is a mirrored palindrome.";
//
//	  }
//	  if(mirror && !pal){
//		  result +=" -- is a mirrored string.";
//	  }
//	  if(pal && !mirror){
//		  result+=" -- is a regular palindrome.";
//	  }
//	  if(!pal&&!mirror){
//		result+=" -- is not a palindrome.";
//		
//	  }
//	  System.out.println(result);
//	}
}
}}
