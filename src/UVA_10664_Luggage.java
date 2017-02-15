

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10664_Luggage {
	static int [] [] dp ;
	static int [] arr;
		
	public static int solve(int remainder,int pos){
	if(remainder<=0)
		return 0; 
	if(pos>=arr.length)
		return 0 ;
		if(dp[pos][remainder]!=-1)
			return dp[pos][remainder];
		int mx = 0;
		int t ;
		for(int i=pos; i<arr.length;i++){
			t = arr[i] + solve(remainder-arr[i],pos+1);
			if(mx<t)mx = t ;
		}
		dp[pos][remainder]=mx;
		return dp[pos][remainder];
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int m = Integer.parseInt(br.readLine());

while(m-->0){
	dp = new int [25][200];
	for(int i =0;i<25;i++){
		Arrays.fill(dp[i], -1);
	}
	StringTokenizer st = new StringTokenizer(br.readLine());
	arr = new int [st.countTokens()];
	int sum =0  ; 
	for(int i=0 ; st.hasMoreTokens();i++){
		arr[i] = Integer.parseInt(st.nextToken());
	sum+= arr[i];
	}
	if(sum%2==1){
		System.out.println("NO");
		continue;
	}
	System.out.println(solve(sum/2,0));
	System.out.println(sum/2);
	if(solve(sum/2,0)==sum/2)
		System.out.println("YES");
	else
		System.out.println("NO");
}
}
}
