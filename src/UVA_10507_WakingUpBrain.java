import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UVA_10507_WakingUpBrain {
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

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while (sc.ready()) {
			if (first) {
				first = false;
			} else {
				sc.nextLine();
			}
			int n = sc.nextInt();
			int num = sc.nextInt();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < 26; i++) {
				char x = (char) (65 + i);
				map.put(x, i);
			}
			String s = sc.nextLine();

			boolean[] wake = new boolean[27];
			wake[map.get(s.charAt(0))] = true;
			wake[map.get(s.charAt(1))] = true;
			wake[map.get(s.charAt(2))] = true;
			ArrayList<Integer>[] adjList = new ArrayList[27];
			for (int i = 0; i < 27; i++)
				adjList[i] = new ArrayList<Integer>();
			for (int i = 0; i < num; i++) {
				String ss = sc.nextLine();
				int f = map.get(ss.charAt(0));
				int sec = map.get(ss.charAt(1));

				adjList[f].add(sec);
				adjList[sec].add(f);
			
			}
			int years = 0;
			for (int i = 0; i < 1000; i++) {
				boolean[] temp = Arrays.copyOf(wake, wake.length);
				boolean in = false;

				for (int j = 0; j < 27; j++) {
					int awake = 0;

					if (!wake[j]) {
						
						for (int k = 0; k < adjList[j].size(); k++) {
						
					
							if (wake[adjList[j].get(k)]) {
								awake++;
						
							}
						}
					}

					if (awake >= 3) {
						in = true;

						temp[j] = true;

					}
				}
				if (in)
					years++;
				wake = temp;
			}
			int counter = 0;
			for (int i = 0; i < 26; i++) {
				if (wake[i])
					counter++;
			}
			if (counter == n) {
				sb.append(String.format("WAKE UP IN, %s, YEARS\n", years));
			} else {
				sb.append("THIS BRAIN NEVER WAKES UP\n");
				
			}

		}
		System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
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
