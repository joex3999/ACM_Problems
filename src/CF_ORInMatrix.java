import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_ORInMatrix {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		int[][] res = new int[m][n];
		for (int i = 0; i < m; i++)
			Arrays.fill(res[i], -1);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int now = arr[i][j];
				if (now == 0) {
					for (int k = 0; k < m; k++) {
						res[k][j] = 0;
					}
					for (int l = 0; l < n; l++) {
						res[i][l] = 0;
					}
				}
			}
		}



		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int now = arr[i][j];
				boolean once = now == 1 ? false : true;
				if (now == 1) {
					for (int k = 0; k < m; k++) {

						if (res[k][j] != 0) {
							res[k][j] = 1;
							once = true;
						}
						if (res[k][j] == 1)
							once = true;
					}
					for (int l = 0; l < n; l++) {

						if (res[i][l] != 0) {
							res[i][l] = 1;
							once = true;
						}
						if (res[i][l] == 1)
							once = true;
					}

					if (!once) {
						System.out.println("NO");
						return;
					}

				}
			}
		}
		System.out.println("YES");
		for (int i = 0; i < m; i++) {
			System.out.print(res[i][0]);
			for (int j = 1; j < n; j++) {
				System.out.print(" "+res[i][j]);
			}
			System.out.println();
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
