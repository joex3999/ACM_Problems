

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_280_Vertex {

	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int V;
	static boolean firstiter = true;

	static void dfs(int u) // O(V + E) adjList, O(V^2) adjMat
	{
		if (!firstiter) {
			visited[u] = true;
		} else {
			firstiter = false;
			;
		}
		// for adjacency list

		for (int v : adjList[u])
			if (!visited[v])
				dfs(v);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			V = Integer.parseInt(br.readLine());
			if (V == 0) {
				break;
			}
			adjList = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				if (u == 0) {
					break;
				}
				int v = 0;
				while ((v = Integer.parseInt(st.nextToken())) != 0) {
					adjList[u - 1].add(v - 1);
				}

			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int lineS = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] result = new ArrayList[lineS];
			for (int i = 0; i < lineS; i++) {
				result[i] = new ArrayList<Integer>();
			}
		
			for (int i = 0; i < lineS; i++) {
				int size = 0 ;
				int start = Integer.parseInt(st.nextToken()) - 1;
				StringBuilder sb2 = new StringBuilder ();
				visited = new boolean[V];
				firstiter = true;
				dfs(start);
			
				for (int j = 0; j < V; j++) {
					if (!visited[j]) {
						size ++;
					
						sb2.append(" "+ (j+1));
						
					}

				}
				sb.append(size + sb2.toString()+"\n");
			}

		}
		sb.replace(sb.length()-1, sb.length(), "");
		System.out.println(sb.toString());
	}
}
