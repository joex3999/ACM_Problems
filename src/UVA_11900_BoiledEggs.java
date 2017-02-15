

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11900_BoiledEggs {
public static void main (String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int cases = Integer.parseInt(br.readLine());
	StringBuilder sb = new StringBuilder();
	boolean first = true ;
	int ctr = 1 ;
	while(cases-->0){
		
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] eggs = new int [n];
		for(int i =0 ; i<n;i++){
			eggs[i]= Integer.parseInt(st.nextToken());
		}
	int result = 0 ;
	int res = 0;
for(int i =0 ; i<n;i++){
	if(i<P){
	if(result+eggs[i]<=Q){
		result+=eggs[i];
	res++;
	}else{
		break;
	}
	
	
	}else{
		break;
	}
	
}
if(first){
		sb.append("Case "+ctr+": "+res);
		first = false ;
}else{
	sb.append("\nCase "+ctr+": "+res);
}
ctr++;
	}
System.out.println(sb.toString());
}
}
