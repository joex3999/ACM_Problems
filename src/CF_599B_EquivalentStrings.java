
import java.util.*;
import java.io.*;
public class CF_599B_EquivalentStrings {
static public boolean recurse(String a ,String b){
	System.out.println("oi");
	if(a.equals(b))
		return true ;
	if(a.length()==1&&b.length()==1&&!a.equals(b))
		return false ;
//System.out.println(" first : " + a.substring(0,(a.length()/2))+ "   " +b.substring((b.length()/2),b.length())
//		+ " second : " +(a.substring((a.length()/2),a.length()) + "   " +b.substring(0,(b.length())/2)) );
		return recurse(a.substring(0,(a.length()/2)),b.substring((b.length()/2),b.length()))&&
				recurse(a.substring((a.length()/2),a.length()),b.substring(0,(b.length())/2));
}
static public String lexoOrder(String s ){

	if(s.length()%2==1)
		return s;
	String first = lexoOrder(s.substring(0, s.length()/2));
	String second = lexoOrder(s.substring(s.length()/2,s.length()));
	if(first.compareTo(second)<1)
		return second+first;
	else
		return first+second;
}

public static void main(String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = br.readLine();
	String b = br.readLine();
String result1 = lexoOrder(s);	
String result2 = lexoOrder(b);
if(result1.equals(result2)){
	System.out.println("YES");
}else{
	System.out.println("NO");
}
}}
