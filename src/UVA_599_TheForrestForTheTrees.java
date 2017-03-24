import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UVA_599_TheForrestForTheTrees {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	static void dfs(int u) // O(V + E) adjList, O(V^2) adjMat
	{
		visited[u] = true;

		// for adjacency list

		for (int v : adjList[u])
			if (!visited[v])
				dfs(v);

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			ArrayList<String> arr = new ArrayList<String>();

			String s;
			while ((s = sc.nextLine()).charAt(0) != '*') {

				arr.add(s);
			}
			String[] arr2 = sc.nextLine().split(",");
			
			adjList = new ArrayList[arr2.length];
			visited = new boolean[arr2.length];
			for (int i = 0; i < arr2.length; i++)
				adjList[i] = new ArrayList<Integer>();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < arr2.length; i++)
				map.put(arr2[i].charAt(0), i);
			for (int i = 0; i < arr.size(); i++) {

				StringTokenizer st = new StringTokenizer(arr.get(i), "(),");
				char v1 = st.nextToken().charAt(0);
				char v2 = st.nextToken().charAt(0);
				int val1 = map.get(v1);
				int val2 = map.get(v2);
				adjList[val1].add(val2);
				adjList[val2].add(val1);
			}
			int answer1 = 0;
			int answer2= 0;
			for (int i = 0; i < arr2.length; ++i) {
				if (adjList[i].isEmpty())
					answer2++;
				if (!visited[i]) {
					dfs(i);
					answer1++;
				}
			}
		
		sb.append(String.format("There are %s tree(s) and %s acorn(s).\n", (answer1-answer2),answer2 ));

		}
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
		}

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
