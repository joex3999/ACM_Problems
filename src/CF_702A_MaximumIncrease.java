

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_702A_MaximumIncrease {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int [ ] arr = new int [n];
	StringTokenizer st = new StringTokenizer(br.readLine());
	int max = 1;
		int current = 1 ;
	 arr [ 0 ] = Integer.parseInt(st.nextToken());
	for(int i =1 ; i<n ;i++){
		arr[i] = Integer.parseInt(st.nextToken());
		if(arr[i]>arr[i-1]){
			current++;
			if(current> max ){
				max = current ;
			}
		}else{
				current = 1 ;
			}
	}
	System.out.println(max);
	
}
}
