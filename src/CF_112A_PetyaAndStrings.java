import java.util.*;
import java.io.*;
public class CF_112A_PetyaAndStrings {
public static void main(String[] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = br.readLine().toLowerCase();
String b = br.readLine().toLowerCase();
if(s.compareTo(b)>=1){
	System.out.println(1);
}else
	if(s.compareTo(b)<=1&&s.compareTo(b)!=0)
		System.out.println(-1);
	else
		System.out.println(0);
}
}