

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_499A_WatchingAMovie {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int skip = Integer.parseInt(st.nextToken());
	int lowerBound = 1 ;
	int minutes = 0 ;
	for(int i =0 ; i<n ; i++){
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int diff = x-lowerBound;
		while(diff>=skip){
			diff-= skip;
		}
		minutes += diff ;
		int y = Integer.parseInt(st.nextToken());
		lowerBound = y+1 ;
		minutes+= lowerBound-x;
	}
	System.out.println(minutes);
}


}
