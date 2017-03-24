import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_699B_OneBomb {
	static int[][] destroyed;
	static int n;
	static int m;

	public static void Do(int x, int y) {
		for (int k = 0; k < n; k++) {
			destroyed[k][y]++;
		}
		for (int k = 0; k < m; k++) {
			destroyed[x][k]++;
		}
		destroyed[x][y]--;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		boolean[][] exist = new boolean[n][m];
		destroyed = new int[n][m];
		int number = 0;
		for (int i = 0; i < n; i++) {
			String g = sc.nextLine();
			for (int j = 0; j < m; j++) {
				if (g.charAt(j) == '*') {
					exist[i][j] = true;
					number++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (exist[i][j])
					Do(i, j);

			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (destroyed[i][j] == number) {
					System.out.println("YES");
					System.out.println(i + 1 + " " + (j + 1));
					return;
				}

			}

		}

		System.out.println("NO");
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
