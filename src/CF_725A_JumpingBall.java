

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_725A_JumpingBall {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int result = x;
		char[] arr = br.readLine().toCharArray();
		boolean firsttime = true ;
		int temp = 0;
		for(int i=0; i<arr.length;i++){
			if(arr[i]=='>'&&firsttime){
				temp ++;
			firsttime = false ;
			continue ;
			}
			if(!firsttime){
				temp++;
				if(arr[i]=='<'){
					result= result - temp ;
				temp = 0 ;
				}
			}
		}
System.out.println(result);
	}
}
