

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_4410_RACING {

	static ArrayList<Integer>[] adjList;
	static int[][] adjMatrix;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
	static int result = 0 ;

	static void tarjanSCC() // O(V + E)
	{
		for (int i = 0; i < V; ++i)
			if (dfs_num[i] == 0)
				tarjanSCC(i);
	}

	static void tarjanSCC(int u) {
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);

		for (int v : adjList[u]) {
			if (dfs_num[v] == 0)
				tarjanSCC(v);
			if (!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
		}
		if (dfs_num[u] == dfs_low[u]) {
			// SCC found
			int temp = stack.pop();
			int mincost = 1000000000 ;
			int placeholder1 = 0 ;
			int placeholder2 = 0 ;
			while (true) {
				
				int v = stack.pop();
				System.out.println(v);
				inSCC[v] = true;
				if (v == u)
					break;
				
				if(mincost>adjMatrix[v][temp]){
					mincost = adjMatrix[v][temp];
					placeholder1 = v ;
					placeholder2 = temp ;
				}
				temp = v ;
			
			}
			System.out.println(mincost);
			result+=mincost;
			adjList[placeholder1].remove((Object)placeholder2);
			adjList[placeholder2].remove((Object)placeholder1);
			SCC++;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		while (c-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			V = n;
			dfs_num = new int [V];
			inSCC = new boolean [V];
			dfs_low = new int [V];
			adjMatrix = new int[V][V];
			adjList = new ArrayList[V];
			stack = new Stack<Integer>();
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<Integer>();
				Arrays.fill(adjMatrix[i], (int) 1000000000);

			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;
				int cost = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
				adjList[to].add(from);
				adjMatrix[from][to] = cost;
				adjMatrix[to][from] = cost;
			}
			result = 0 ;
tarjanSCC();
System.out.println(result);
			
		}
	}
}
