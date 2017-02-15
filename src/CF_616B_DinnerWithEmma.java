

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_616B_DinnerWithEmma {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int smallestAll = 0 ;

while(n-->0){
	st = new StringTokenizer(br.readLine());
	int smallest =(int) Double.POSITIVE_INFINITY;
	int pos ;
	int g = m;
	while(g-->0){
		pos = Integer.parseInt(st.nextToken());

		if(pos<smallest){
		
			smallest = pos ;
		}
	}
	
if(smallest>smallestAll){
	smallestAll=smallest;
}
}
System.out.println(smallestAll);
}
}
