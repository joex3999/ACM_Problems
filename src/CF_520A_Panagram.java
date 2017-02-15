

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CF_520A_Panagram {
public static void main(String []args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	if(n<26){
		System.out.println("NO");
	return;
	}
	
	String y = br.readLine();
boolean [] list = new boolean [26];
for(int i =0 ; i < n ;i++){
	char g = Character.toLowerCase(y.charAt(i));
	int ascii =(int) g ;
	int pos = ascii - 97;
	list[pos]=true;
}
for(int i =0 ; i<list.length;i++){
	if(list[i]==false){
		System.out.println("NO");
		return;
	}
}
System.out.println("YES");

}
}