import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF_742C_ArpasLoudOwf {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		V = n;
		dfs_num = new int[n];
		dfs_low = new int[n];
		adjList = new ArrayList[n];
		inSCC = new boolean[n];
		stack = new Stack<Integer>();
SCCs = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
			int now = sc.nextInt() - 1;
			adjList[i].add(now);
			
		}
		
		tarjanSCC();
		
		System.out.println(MaxSCC);
	}

	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
	static ArrayList<Integer>SCCs;
	static int MaxSCC = Integer.MAX_VALUE;
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
			int length = 0 ;
			while (true) {

				int v = stack.pop();
				inSCC[v] = true;
				length ++;
				if (v == u){
					SCCs.add(length);
					
					MaxSCC = Math.min(MaxSCC, length);	
					break;
				}
			}
			SCC++;
		}

	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
