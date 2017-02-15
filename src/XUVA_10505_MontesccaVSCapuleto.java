

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
// submitted : https://fabhodev.wordpress.com/2014/01/18/10505-montesco-vs-capuleto-uva-solution/
public class XUVA_10505_MontesccaVSCapuleto {
	static int[] color;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int left;
	static int right;

	static boolean bipartitieCheck(int u) {
		visited[u] = true;
		if (color[u] == 0) {
			left++;
		} else {
			right++;
		}
		for (int v : adjList[u])
			if (color[v] == -1) {
				color[v] = 1 ^ color[u];

				if (!bipartitieCheck(v)) {
					return false;
				}
			} else {
				if (color[v] == color[u])
					return false;
			}

		return true;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			br.readLine();
			left = 0;
			right = 0;
			int n = Integer.parseInt(br.readLine());
			adjList = new ArrayList[n];
			color = new int[n];
			Arrays.fill(color, -1);
			visited = new boolean[n];

			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				while (st.hasMoreTokens()) {
					adjList[i].add(Integer.parseInt(st.nextToken()) - 1);
				}
			}
			boolean x = true;
			boolean oneTime = true ;
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
				if(oneTime){
					color[i]=0;
					x = bipartitieCheck(i);
					oneTime = false;
					if (!x)
						break;
				}else{
					color[i]=0;
					boolean f = bipartitieCheck(i);
				}
				}
			}

			if (x)
				sb.append(Math.max(left, right) + "\n");
			else
				sb.append(0 + "\n");
		}
		sb.replace(sb.length()-1, sb.length(), "");
	System.out.println(sb.toString());
	}
}
