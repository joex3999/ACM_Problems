

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// not working submitted another sol 

public class LUVA_10356_RoughRoads {

	static final int INF = (int)1e9;	//don't increase, avoid overflow
	static ArrayList<Edge>[] adjList;
	static int V;
	static PriorityQueue<Edgee> helper ;
	static HashSet <Edge> container ;
	static ArrayList<Edge> parent;
	static int dijkstra(int S, int T)
	{
		int[] dist = new int[V];
		Arrays.fill(dist, INF);
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		dist[S] = 0;
		pq.add(new Edge(S, 0));
		while(!pq.isEmpty())
		{
		
			Edge cur = pq.remove();// if you want to trace the path you should make an array and add the parents in it here . -j
			if(cur.cost<dist[cur.node])
			//helper.add(cur);
		if(container.contains(cur)){
			continue;
		}
		if(cur.cost<dist[cur.node])
		parent.add(cur);
			
			if(cur.node == T)		//remove if all nodes are sinks
				return dist[T];  	// aka. if you want the shortest path to all the vertexes -j
			if(cur.cost > dist[cur.node])
				continue;
			for(Edge nxt: adjList[cur.node])
				if(cur.cost + nxt.cost < dist[nxt.node])
				{
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
		
		@Override
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return node - e.node;
		}
	}
		
		static class Edgee implements Comparable<Edge>{
			int node, cost;
			
			Edgee(int a, int b)
			{
				node = a;
				cost = b;
			}
			
			@Override
			public int compareTo(Edge e)
			{
				if(cost != e.cost)
					return e.cost - cost;
				return e.node - node;
			}
		
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = null ;
	while((s=br.readLine())!=null){
		StringTokenizer st = new StringTokenizer(s);
		helper = new PriorityQueue<Edgee>();
		container = new HashSet<Edge>();
		parent =  new ArrayList<Edge>();
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[V];
		for(int i =0 ; i<V;i++){
			adjList[i]= new ArrayList<Edge>();
		}
		for(int i = 0 ; i<E;i++){
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			Edge from = new Edge(f,cost);
			Edge to = new Edge(t,cost);
			adjList[f].add(to);
			adjList[t].add(from);
		}
		int path = 1 ;
		while(path%2!=0){
			dijkstra(0,V-1);
			//container.add((Edgee)helper.poll());
		}
		
	}
}
}
