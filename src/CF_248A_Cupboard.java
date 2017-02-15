

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_248A_Cupboard {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	int g = Integer.parseInt(br.readLine());
	int leftopen = 0 ;
	int leftclosed = 0 ;
	int rightopen = 0 ;
	int rightclosed =0 ;
	while(g-->0){
		StringTokenizer st = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(st.nextToken());
		int right = Integer.parseInt(st.nextToken());
		if(left ==0){
			leftclosed++;
		}else{
			leftopen++;
		}
		
		if(right==0){
			rightclosed++;
		}else{
			rightopen++;
		}
		
	}
	int result = 0 ;
if(leftopen>leftclosed){
	result+=leftclosed;
}else{
	result+=leftopen;
}

if(rightopen>rightclosed){
	result+=rightclosed;
}else{
	result+=rightopen;
}
System.out.println(result);
}
}
