

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// submitted :https://github.com/mkirsche/Codeforces/blob/master/246-D/246-D-3951970.java
public class XCF_246D_ColorfulGraph {
	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Edge>[] adjList;
	static boolean[] visited;
	static int V;
	static int[] cardinality;
	static HashSet<Integer>[] arrSet;
	static ArrayList<Integer> colors;

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int u = q.remove();
	
			int currentColor = colors.get(u);
			for (Edge g : adjList[u]) {
				int v = g.to;		
				int color = g.color;
				if (!arrSet[currentColor].contains(color)) {
					arrSet[currentColor].add(color);
					cardinality[currentColor]++;
				}
		
				if (!visited[v]) {
			
					visited[v] = true;
					q.add(v);
				}
			}
		}
	}

	public static class Edge {
	 int to;
	 int color;

		public Edge(int a, int b) {
			to = a;
			color = b;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		V = n;
		adjList = new ArrayList[V];
		visited = new boolean[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<Edge>();
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		colors = new ArrayList<Integer>();
		int maximumC = 0;
		while (st.hasMoreTokens()) {
			int now = Integer.parseInt(st.nextToken());
			colors.add(now);
			if (maximumC < now) {
				maximumC = now;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			adjList[from].add(new Edge(to, colors.get(to)));
			adjList[to].add(new Edge(from, colors.get(from)));
		}
		cardinality = new int[maximumC + 1];
		arrSet = new HashSet[maximumC + 1];
		for (int now : colors) {
			arrSet[now] = new HashSet<Integer>();
		}
		for (int i = 0; i < 1; i++) {
			if (!visited[i])
				bfs(i);
		}
		int index = -1 ;
		int maximum = 0 ;
for(int i =0 ; i<cardinality.length; i++){
	if(maximum<cardinality[i]){
		index = i ;
		maximum = cardinality [i];
	}

		}
System.out.println(index);	}
}
