

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// the refund problem only
public class UVA_10819_TroubleOf13Dots {
	static Pair [] arr ;
	static int [][] memset;
	static int n ;
	static int money ;
	static boolean once =true;
	public static class Pair{
		int P ; 
		int F ; 
		public Pair(int p , int f){
			P = p ;
			F = f ;
		}
	}
	public static int solve(int i , int Bleft){
		System.out.println(" i is " + i + "B is " + Bleft);
		if(i==n)
			return 0 ;
		if(memset[i][Bleft]!=-1)
			return memset[i][Bleft];
		
		if(arr[i].P-Bleft<200&&money+200>=2000&&once){
		once= false ;
			return memset[i][Bleft] = Math.max(arr[i].F+solve(i+1,Bleft-arr[i].P+200), solve(i+1,Bleft));
		
		}
			
		if(Bleft-arr[i].P<0)
			return memset[i][Bleft]=solve(i+1,Bleft);
		else{
			return memset[i][Bleft]=Math.max(arr[i].F+solve(i+1,Bleft-arr[i].P), solve(i+1,Bleft));
				
		}
		
		
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = null ;
	StringBuilder sb = new StringBuilder();
	while((s=br.readLine())!=null){
		StringTokenizer st = new StringTokenizer(s);
		int budget = Integer.parseInt(st.nextToken());
		 n = Integer.parseInt(st.nextToken());
	arr = new Pair[n]; // check this 1 again;
	for(int i =0 ; i<n ; i++){
		st =new StringTokenizer(br.readLine());
		arr[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
	}
money = budget;
	memset = new int [105][10005];
	for(int i =0 ; i<105;i++){
		Arrays.fill(memset[i],-1);
	
	}

	System.out.println(solve(0,budget));
	}
}
}
