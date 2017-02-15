
package CF_395;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_395C {
	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Integer>[] adjList;
	static int[] values;
	static boolean[] visited, adjMat[];
	static int V;

	public static class Pair implements Comparable {
		int value;
		int to;

		public Pair(int a, int b) {
			value = a;
			to = b;
		}

		@Override
		public int compareTo(Object o) {
			Pair t = (Pair) o;
			if (value < t.value) {
				return -1;
			} else {
				if (value > t.value)
					return 1;

			}
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int[] values = new int[V];
		int[] colors = new int[V];
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < V - 1; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list.add(new Pair(from, to));

		}
		for (int i = 0; i < V; i++) {
			colors[i] = sc.nextInt();
		}
		Collections.sort(list);

		boolean first = true;
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			Pair g = list.get(i);
			int from = g.value - 1;
			int to = g.to - 1;
			if (colors[from] != colors[to]) {
				values[to] = values[from] + 1;
				
				index = from + 1;
			} else
				values[to] = from;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++) {
			max = Math.max(values[i], max);
		}
		
		if (max > 2) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			System.out.println(index);
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
