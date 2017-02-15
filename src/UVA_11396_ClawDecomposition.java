

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class UVA_11396_ClawDecomposition {
	static int N;
	static ArrayList<Integer>[] G;
	static int[] color;
	static boolean[] visited;
	
	static boolean dfs(int u, int c) {
		visited[u] = true;
		color[u] = c;
		
		boolean ok = true;
		for (int v : G[u])
			if (!visited[v])
				ok &= dfs(v, 1 - c);
			else if (color[u] == color[v])
				return false;
		return ok;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			N = Integer.parseInt(in.readLine());
			
			if (N == 0) break;

			G = new ArrayList[N];
			for (int i = 0; i < N; ++i)
				G[i] = new ArrayList<Integer>();
			
			while (true) {
				String[] parts = in.readLine().split("[ ]+");
				int u = Integer.parseInt(parts[0]) - 1;
				int v = Integer.parseInt(parts[1]) - 1;
				
				if (u == -1 && v == -1) break;
				
				G[u].add(v);
				G[v].add(u);
			}
			visited = new boolean[N];
			color = new int[N];
			Arrays.fill(color, -1);
			boolean ok = true;
			for (int k = 0; k < N; ++k) {
				if (!visited[k])
					ok &= dfs(k, 0);
			}
			
			System.out.println(ok ? "YES" : "NO");
		}
		
		in.close();
		System.exit(0);
	}
}
