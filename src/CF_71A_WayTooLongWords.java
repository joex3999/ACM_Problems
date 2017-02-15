

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_71A_WayTooLongWords {
public static void main(String[]args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int C =Integer.parseInt(br.readLine());
	while(C-->0){
		String word = br.readLine();
		char [] arr = word.toCharArray();
		if(arr.length>10){
			System.out.println((char)arr[0]+""+(arr.length-2)+""+(char)arr[arr.length-1]);
			
		}else{
			System.out.println(word);
		}
	}
	
}
}
