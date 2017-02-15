import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FB_HackerCup_LazyLoading {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("in.txt");
		FileWriter out = new FileWriter("out.txt");

		Scanner sc = new Scanner(in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int no = 0;
			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			Deque que = new LinkedList<Integer>();
			for (int j = 0; j < n; j++) {
				que.addLast(arr[j]);
			}

			while (!que.isEmpty()) {

				int g = (int) que.removeLast();
				int weight = g;
				while (weight < 50 && !que.isEmpty()) {
					que.removeFirst();
					weight += g;
				}
				if (weight >= 50)
					no++;
			}
			sb.append(String.format("Case #%s: %s\n", i + 1, no));
		}
		// System.out.println(sb.toString());
		out.write(sb.toString());
		out.flush();
		out.close();
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
