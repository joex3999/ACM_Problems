
import  java.util.*;
import java.io.*;
public class CF_729_InterviewWithOleg {
public static void main(String[] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	char [] arr = br.readLine().toCharArray();
	int i =0 ;
	String result = "";
	while(i<n){
		if(i<n&&arr[i]=='o'){
			boolean remove = false ;
			while(true){
				if(i+1<n&&i+2<n&&arr[i+1]=='g'&&arr[i+2]=='o'){
					remove = true ;
					i+=2;
				}else
					break;
			}
			if(!remove){
				result+='o';
				i++;
			}else{
				result+="***";
				i++;
			}
		}else{
			result+=arr[i];
			i++;
		}
	}
	System.out.println(result);
}
}
