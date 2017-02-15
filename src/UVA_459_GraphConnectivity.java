

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
// correct answer but submitted : http://www.ihussain.info/uva-459-graph-connectivity-java-solution/ 
// due to some stupid difficulties 
public class UVA_459_GraphConnectivity {
	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int V;
	static boolean first = true;
	static int result = 0;

	static void dfs(int u) // O(V + E) adjList, O(V^2) adjMat
	{

		if (!visited[u]) {
			if (first) {
				first = false;
				result++;
			}
			visited[u] = true;
		} else {
			return;
		}

		// for adjacency list

		for (int v : adjList[u])
			if (!visited[v])
				dfs(v);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int all = Integer.parseInt(br.readLine());
	br.readLine();
		while (all-- > 0) {
		result = 0 ;
			V = br.readLine().charAt(0) - 65 + 1;
		
			adjList = new ArrayList[V];
			visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			String s = null;
			while ((s = br.readLine()) != null&&!s.equals("")&&!s.equals("joe")) {
				
				int from = s.charAt(0) - 65;
				int to = s.charAt(1) - 65;
				adjList[from].add(to);
				adjList[to].add(from);
			}
			for (int i = 0; i < V; i++) {
				first = true;
				dfs(i);

			}
			System.out.println(result);
		}
	}
}
