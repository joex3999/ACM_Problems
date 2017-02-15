

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class UVA_11631_DarkRoads {

	static ArrayList<Edge>[] adjList;
	static int V;



	
	static int prim()		//O(E log E)
	{
		int mst = 0;
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(0, 0));
		while(!pq.isEmpty())
		{
			Edge cur = pq.remove();
			if(visited[cur.to])
				continue;
			visited[cur.to] = true;
			mst += cur.cost;
			for(Edge nxt: adjList[cur.to])
				if(!visited[nxt.to])
					pq.add(nxt);
		}
		
		return mst;
	}
	
	
	
	static class Edge implements Comparable<Edge>
	{
		int to, cost;
		
		Edge(int a, int b)
		{
			to = a;
			cost = b;
		}
		
		public int compareTo(Edge e)
		{
			if(cost != e.cost)
				return cost - e.cost;
			return to - e.to;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
if(V==E && E==0)
	break;
adjList = new ArrayList[V];
for(int i =0 ; i <V;i++){
	adjList[i]= new ArrayList<Edge>();
}
int totalCost = 0 ;
for(int i =0 ; i<E;i++){
	st = new StringTokenizer(br.readLine());
	int from = Integer.parseInt(st.nextToken());
	int to = Integer.parseInt(st.nextToken());
	int cost = Integer.parseInt(st.nextToken());
	totalCost +=cost;
	adjList[from].add(new Edge(to,cost));
	adjList[to].add(new Edge(from,cost));
}

	 int result = totalCost-prim();
sb.append(result+"\n");
		}
		sb.replace(sb.length()-1, sb.length(), "");
		System.out.println(sb.toString());
	}
}
