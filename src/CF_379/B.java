package CF_379;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
public static void main(String[] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int K2 =Integer.parseInt(st.nextToken());
	int K3 = Integer.parseInt(st.nextToken()) ;
	int K5 = Integer.parseInt(st.nextToken());
	int K6 = Integer.parseInt(st.nextToken()) ;
	int maxSum =0 ;
	while(K2>0&&K5>0&&K6>0){
	maxSum+= 256;
	K2--;
	K5--;
	K6--;
	}	
	
	while(K3>0 && K2>0){
		maxSum+= 32;
		K3--;
		K2--;
	}
	System.out.println(maxSum);
}
}

