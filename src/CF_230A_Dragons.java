

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// the kirito problem
public class CF_230A_Dragons {
static class Pair implements Comparable{
	int x ;
	int y ;
	public Pair(int x , int y ){
		this.x = x ;
		this.y = y ;
	}
	@Override
	public int compareTo(Object p) {
		Pair o = (Pair) p ;
if(this.x<o.x){
	return -1 ;
}
if(this.x>o.x){
	return 1 ;
}
return 0 ;
	}
}
	public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int strength = Integer.parseInt(st.nextToken());
int n = Integer.parseInt(st.nextToken());
Pair[ ]dragons = new Pair [n];
for(int i =0 ; i < n ; i++){
	st = new StringTokenizer(br.readLine());
	dragons[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	
}

Arrays.sort(dragons);
	for(int i =0 ; i<n;i++){
		Pair g = dragons[i];
		if(strength>g.x){
			strength+=g.y;
		}else{
			System.out.println("NO");
			return ;
		}
		
	}
	System.out.println("YES");
}
}
