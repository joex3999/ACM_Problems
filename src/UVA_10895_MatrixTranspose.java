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

public class UVA_10895_MatrixTranspose {
	static class Pair {
		int value;
		int column;

		public Pair(int v, int c) {
			value = v;
			column = c;
		}
	}

	static ArrayList<Pair>[] adjList;
	static ArrayList<Pair>[] list;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		StringBuilder sb = new StringBuilder();
		while (sc.ready()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			adjList = new ArrayList[n];
			list = new ArrayList[m];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<Pair>();
			}
			for (int i = 0; i < m; i++)
				list[i] = new ArrayList<Pair>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st1 = new StringTokenizer(sc.nextLine());

				int val = Integer.parseInt(st1.nextToken());

				if (val != 0) {
					StringTokenizer st2 = new StringTokenizer(sc.nextLine());
					for (int j = 0; j < val; j++) {
						int col = Integer.parseInt(st1.nextToken());
						int value = Integer.parseInt(st2.nextToken());
						adjList[i].add(new Pair(value, col));

					}
				}
			}
			sb.append(m + " " + n + "\n");
			for (int i = 0; i < m; i++) {
				loop: for (int j = 0; j < n; j++) {
					for (int k = 0; k < adjList[j].size(); k++) {
						if (adjList[j].get(k).column == i + 1) {
							list[i].add(new Pair(j, adjList[j].get(k).value));

						} else {
							if (adjList[j].get(k).column > i + 1)
								continue loop;

						}
					}
				}
			}
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb2.append(list[i].size() + " ");
				if (list[i].size() != 0) {
					for (int j = 0; j < list[i].size(); j++)
						sb2.append(list[i].get(j).value + 1 + " ");
					sb2.deleteCharAt(sb2.length() - 1);
					sb2.append("\n");

					for (int j = 0; j < list[i].size(); j++)
						sb2.append((list[i].get(j).column + " "));
				} else {
					sb2.deleteCharAt(sb2.length() - 1);
					sb2.append("\n");
					sb2.append("\n");
				}
				sb2.deleteCharAt(sb2.length() - 1);
				sb2.append("\n");

			}
			sb.append(sb2.deleteCharAt(sb2.length() - 1) + "\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
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
