import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_11503_VirtualFriends {

	// Union-Find Disjoint Sets Library written in OOP manner, using both path
	// compression and union by rank heuristics
	public static class UnionFind {
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) {
			p = new int[N];
			rank = new int[N];
			setSize = new int[N];
			numSets = N;
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			if (p[i] == i)
				return i;
			else
				return p[i] = findSet(p[i]);
		}

		public Boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			// rank is used to keep the tree short
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
		}
	}

	static class Pair {
		String first;
		String second;

		public Pair(String f, String s) {
			first = f;
			second = s;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = sc.nextInt();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			Pair[] pair = new Pair[n];
			int count = 0;

			for (int i = 0; i < n; i++) {
				String first = sc.next();
				String second = sc.next();
				pair[i] = new Pair(first, second);
				if (!map.containsKey(first))
					map.put(first, count++);

				if (!map.containsKey(second))
					map.put(second, count++);
			}
			UnionFind uf = new UnionFind(count);
			for (int i = 0; i < n; i++) {
				String first = pair[i].first;
				String second = pair[i].second;
				uf.unionSet(map.get(first), map.get(second));
				sb.append(uf.sizeOfSet(map.get(first))+"\n");
			}
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
