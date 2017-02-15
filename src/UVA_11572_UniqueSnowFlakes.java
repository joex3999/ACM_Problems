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
import java.util.TreeMap;
import java.util.TreeSet;

public class UVA_11572_UniqueSnowFlakes {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int n = sc.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			int max = Integer.MIN_VALUE;
			int counter = 0;
			int lastRemoved = 0;
			for (int i = 0; i < n; i++) {
				int g = sc.nextInt();
				if (map.containsKey(g)) {
					if (map.get(g) < lastRemoved) {

						map.remove(g);
						map.put(g, i);

						counter++;
					} else {
						counter = i - map.get(g);
						lastRemoved = map.get(g);

						map.remove(g);
						map.put(g, i);
					
					}
				} else {
					counter++;
					map.put(g, i);

				}
				
				max = Math.max(counter, max);
			}
			if (max < -1)
				max = 0;
			sb.append(max + "\n");
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
