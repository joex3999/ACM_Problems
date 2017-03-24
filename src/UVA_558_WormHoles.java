

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class UVA_558_WormHoles {

	static final int INF = (int)1e9;	//don't increase, avoid overflow
	static ArrayList<Edge>[] adjList;
	static int V;
	
	static boolean bellmanFord(int S)		
	{
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		dist[S] = 0;
		boolean modified = true;
		for(int k = 0; modified && k < V - 1; ++k)
		{
			modified = false; // as long as there is a change -j 
			for(int u = 0; u < V; ++u)		// these two loops run in O(E) in total
				for(Edge nxt: adjList[u])	
					if(dist[u] + nxt.cost < dist[nxt.node])
					{
						modified = true;
						dist[nxt.node] = dist[u] + nxt.cost;
					}
		}
		
		boolean negative_cycle_exists = false;
		for(int u = 0; u < V; ++u){
	
			for(Edge nxt: adjList[u])
				if(dist[u] + nxt.cost < dist[nxt.node])
					negative_cycle_exists = true;}
		return negative_cycle_exists;
	}
	
	
	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b)
		{
			node = a;
			cost = b;
		}
		
		@Override
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}
		
	}


public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int c = Integer.parseInt(br.readLine());
	StringBuilder sb = new StringBuilder();
	while(c-->0){
		StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	V = n ;
adjList = new  ArrayList[V];

for(int i =0 ; i <V;i++){
	adjList[i] = new ArrayList<Edge>();
}
	for(int i =0 ; i <m;i++){
		st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
	adjList[from].add(new Edge(to,time));
	}
	boolean doesit = bellmanFord(0);
	if(doesit)
	sb.append("possible"+"\n");
	else
		sb.append("not possible"+"\n");
	}
	sb.replace(sb.length()-1, sb.length(), "");
	System.out.println(sb.toString());
}
}
