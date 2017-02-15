

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Nice one ! little proud solved it fast + i solved it with a different approach than the obvious one . AC from 1st try 

public class CF_707B_Bakery {
	public static class TEdge implements Comparable {
		int X ; 
		int Y ; 
		int Z ;
		public TEdge(int x , int y , int z){
			X = x ;
			Y = y ;
			Z = z ;
		}
		@Override
		public int compareTo(Object gg) {
		TEdge O = (TEdge)gg;
		if(Z>O.Z)
			return 1;
		if(Z<O.Z)
			return -1 ;
		
			return 0;
		}
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
	int K = Integer.parseInt(st.nextToken());
	if( K ==0 ){
		System.out.println("-1");
		return ;
	}
	boolean [] storage = new boolean [N];
	Arrays.fill(storage, false);
	TEdge [] arr = new TEdge[M];
	for(int i =0 ; i<M;i++){
		st = new StringTokenizer(br.readLine());
		arr[i] = new TEdge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
	}
	Arrays.sort(arr);
	
	st = new StringTokenizer(br.readLine());
	for(int i=0; i<K;i++){
		storage[Integer.parseInt(st.nextToken())-1] = true ;
	}
	int minimum = Integer.MAX_VALUE;
	for(int i =0 ; i<arr.length;i++){
		TEdge now = arr[i];
		if((!storage[now.X]&&storage[now.Y]) || (storage[now.X]&&!storage[now.Y])){
			if(now.Z<minimum)
				minimum = now.Z;
		}
	}
	if(minimum==Integer.MAX_VALUE)
		System.out.println(-1);
	else System.out.println(minimum);
}
}
