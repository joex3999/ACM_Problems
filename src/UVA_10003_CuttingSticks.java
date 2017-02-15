

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10003_CuttingSticks {
	static int [] pos;
	static int [][]memo;
	static int dp (int r,int l){
		if(r+1==l)
			return 0 ;
		if(memo[r][l]!=-1)
			return memo[r][l];
		int min = Integer.MAX_VALUE/3;
		for(int i = r+1;i<l;i++)
			min = Math.min(min, dp(r,i)+dp(i,l));
		
		return memo[r][l]= min + pos[l] - pos[r];
		
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	while(true){
		int L = Integer.parseInt(br.readLine());
	if(L==0)
		break;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		 pos = new int [N+2];
		for(int i =1 ;i<N+1;i++){
			pos[i]= Integer.parseInt(st.nextToken());
		}
		pos[0] = 0 ;
		pos [ N+1] = L ;
		memo = new int [55][55];
		for(int i = 0 ; i<55;i++){
			Arrays.fill(memo[i], -1);
		}
		sb.append(String.format("The minimum cutting is %s.\n", dp(0,N+1)));
	}
	sb.replace(sb.length()-1,sb.length(), "");
	System.out.println(sb.toString());
}
}
