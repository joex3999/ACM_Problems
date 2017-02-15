package CF_374;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {
	public static class Edge{
		int To ; 
		int Weight;
		public  Edge (int a , int b){
			To = a ;
			Weight = b;
			
		}
	}
	static ArrayList<Edge>[] adjList;
	static int T ;
	static int des ;
	static int [][] memTable;
	public static int solve(int pos , int T ){
		if(T ==0)
			return 0;
		if(pos==des)
			return 0 ;
		if(T<0)
			return -5000;
		if(memTable[pos][T]!=-1)
			return memTable[pos][T];
		int max= Integer.MIN_VALUE;
		for(int i =0 ; i<adjList[pos].size();i++){
			int G = 1+solve(adjList[pos].get(i).To,T-adjList[pos].get(i).Weight);
			if(max<G)
				max=G;
		}
			return memTable[pos][T]=max ;
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	des = N-1;
	int M = Integer.parseInt(st.nextToken());
	 T = Integer.parseInt(st.nextToken());
memTable = new int [5000][100000000];
for(int i =0 ; i<5000;i++)
	Arrays.fill(memTable[i], -1);
	 for(int i =0 ; i<N ; i ++){
adjList[i] = new ArrayList<Edge>();	
}
	 for(int i =0 ; i<N ; i++){
	st = new StringTokenizer(br.readLine());
	int from = Integer.parseInt(st.nextToken())-1;
	int to = Integer.parseInt(st.nextToken())-1;
	int w = Integer.parseInt(st.nextToken());
	adjList[from].add(new Edge(to,w));
	 }
	 int g = solve(0,T);
}
}
