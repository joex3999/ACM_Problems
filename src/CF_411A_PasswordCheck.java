

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_411A_PasswordCheck {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = br.readLine();
boolean length = false ;
if((s.length()>=5)){
	length = true ;
}
boolean large = false ;
boolean small = false ;
boolean digit = false ;
for(int i =0 ; i<s.length();i++){
	char c = s.charAt(i);
	
	if(Character.isLowerCase(c)){
		small = true ;
	}
	
	if(Character.isUpperCase(c)){
		large = true ;
	}
	
	if(Character.isDigit(c)){
		digit = true ;
	}
}

if(large&&small&&digit&&length){
	System.out.println("Correct");
}else{
	System.out.println("Too weak");
}
}
}
