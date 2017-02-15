import java.io.*;
import java.util.*;
public class CF_96A_Football {
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
char[] s = br.readLine().toCharArray();
int CC =1 ;
for(int i =1 ; i<s.length;i++){
	if(s[i]==s[i-1])
		CC++;
	else
		CC=1;
	if(CC>=7){
	System.out.println("YES");
	return;
	}
}
System.out.println("NO");

}
}