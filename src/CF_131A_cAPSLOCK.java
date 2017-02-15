

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_131A_cAPSLOCK {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s =br.readLine();
String result = "";
boolean change = true ;
for(int i =1 ; i <s.length();i++){
	if(Character.isLowerCase(s.charAt(i))){
		change = false ;
		break;
	}
}
if(change){
for(int i =0 ; i<s.length();i++){
	if(Character.isLowerCase(s.charAt(i))){
		result+=Character.toUpperCase(s.charAt(i));
	}
	if(Character.isUpperCase(s.charAt(i)))
	result+= Character.toLowerCase(s.charAt(i));
}
System.out.println(result);
return ;
}

System.out.println(s);
}
}
