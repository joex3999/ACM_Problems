

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// minimum vertex 	cover on a tree .. but couldn't solve it check later . needed dp . AKA .DP on a Tree
public class XCF_61D_EternalVictory {
	
	static final int INF = (int)1e9;	//don't increase, avoid overflow
	static ArrayList<Edge>[] adjList;
	static int V;
	static int result ;
	static int []dist ;
	static int [] parents ;
	static int dijkstra(int S) // O(V^2)
	{
		result = 0 ;
		dist = new int[V];
		parents = new int [V];
		parents[S]=0;
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();// if you want to trace the path you should make an array and add the parents in it here . -j
			result+= dist[cur.node]-dist[parents[cur.node]];
//			if(cur.node == T)		//remove if all nodes are sinks
//				return dist[T];  	// aka. if you want the shortest path to all the vertexes -j
			if(cur.cost > dist[cur.node])
				continue;
			for(Edge nxt: adjList[cur.node])
				if(cur.cost + nxt.cost < dist[nxt.node])
				{
					parents[nxt.node] =cur.node; 
					dist[nxt.node] = cur.cost + nxt.cost;
					pq.add(new Edge(nxt.node, dist[nxt.node]));
				}
				
		}
		return -1;
	}

	static class Edge implements Comparable<Edge>
	{
		int node, cost;
		
		Edge(int a, int b)
		{
			node = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}
		
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	adjList = new ArrayList[n];
	V = n ;
	for(int i =0 ; i<n;i++){
		adjList[i] = new ArrayList<Edge>();
	}
	for(int i = 0 ; i<n-1;i++){
		StringTokenizer st = new StringTokenizer(br.readLine());
		int from = Integer.parseInt(st.nextToken())-1;
		int to = Integer.parseInt(st.nextToken())-1;
		int cost = Integer.parseInt(st.nextToken());
		adjList[from].add(new Edge(to,cost));
		adjList[to].add(new Edge(from,cost));
	}
	dijkstra(0);
	System.out.println(result);
	int result2 = 0 ;
	for ( int i=1 ; i<n;i++){
		result2+= dist[i];
	}
	System.out.println(result2);
}
}
