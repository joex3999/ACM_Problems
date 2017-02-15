
import java.util.*;
import java.io.*;
public class HR_CamelCase {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	char[] arr = br.readLine().toCharArray();
	int answer = 1 ;
	
	for(int i =1 ; i<arr.length;i++){
	int value = (int)arr[i];
	
	if(value>=65&&value<=90)
		answer++;
	}
	
	System.out.println(answer);
}
}
