import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
public class CF_160A_Twins {
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int []arr = new int [n];
	StringTokenizer st = new StringTokenizer(br.readLine());
	int sum = 0;
	for(int i =0 ; st.hasMoreTokens();i++){
		arr[i] = Integer.parseInt(st.nextToken());
	sum+= arr[i];
	}
	
	Arrays.sort(arr);
	int willTake = 0 ;
	int now = 0 ;

	for(int i =0 ;i<n;i++){
		now+= arr[n-i-1];
		willTake++;
		if(now>sum-now)
			break;
		
	}
	System.out.println(willTake);
	
}
}
