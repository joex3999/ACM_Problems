import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_429B_WorkingOut {
	static long arr[][];
	static long dp1[][];
	static long dp2[][];
	static long dp3[][];
	static long dp4[][];
	static int n;
	static int m;

	public static boolean valid(int i, int j) {
		return (i >= 0 && j >= 0) && i < n && j < m;
	}

	public static long dp1(int index1, int index2) {

		if (index1 < 0 || index2 >= m)
			return Integer.MIN_VALUE;
		if (index1 == 0 && index2 == m - 1)
			return arr[index1][index2];
		if (dp1[index1][index2] != -1)
			return dp1[index1][index2];

		return dp1[index1][index2] = arr[index1][index2]
				+ Math.max(dp1(index1 - 1, index2), dp1(index1, index2 + 1));
	}

	public static long dp2(int index1, int index2) {

		if (index1 < 0 || index2 < 0)
			return Long.MIN_VALUE;
		if (index1 == 0 && index2 == 0)
			return arr[index1][index2];
		if (dp2[index1][index2] != -1)
			return dp2[index1][index2];

		return dp2[index1][index2] = arr[index1][index2]
				+ Math.max(dp2(index1 - 1, index2), dp2(index1, index2 - 1));
	}

	public static long dp3(int index1, int index2) {

		if (index1 > n - 1 || index2 < 0)
			return Integer.MIN_VALUE;
		if (index1 == n - 1 && index2 == 0)
			return arr[index1][index2];
		if (dp3[index1][index2] != -1)
			return dp3[index1][index2];

		return dp3[index1][index2] = arr[index1][index2]
				+ Math.max(dp3(index1 + 1, index2), dp3(index1, index2 - 1));
	}

	public static long dp4(int index1, int index2) {

		if (index1 >= n || index2 >= m)
			return Integer.MIN_VALUE;
		if (index1 == n - 1 && index2 == m - 1)
			return arr[index1][index2];
		if (dp4[index1][index2] != -1)
			return dp4[index1][index2];

		return dp4[index1][index2] = arr[index1][index2]
				+ Math.max(dp4(index1 + 1, index2), dp4(index1, index2 + 1));
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new long[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				arr[i][j] = sc.nextInt();

		}
		dp1 = new long[1001][1001];
		dp2 = new long[1001][1001];
		dp3 = new long[1001][1001];
		dp4 = new long[1001][1001];
		for (int i = 0; i < 1001; i++) {
			Arrays.fill(dp1[i], -1);
			Arrays.fill(dp2[i], -1);
			Arrays.fill(dp3[i], -1);
			Arrays.fill(dp4[i], -1);
		}
		dp1(n - 1, 0);
		dp2(n - 1, m - 1);
		dp3(0, m - 1);
		dp4(0, 0);
	

		long maximum = Long.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (valid(i, j - 1) && valid(i - 1, j) && valid(i, j + 1)
						&& valid(i + 1, j)) {
					maximum = Math.max(maximum, dp1[i - 1][j] + dp2[i][j - 1]
							+ dp3[i + 1][j] + dp4[i][j + 1]);
				}
			}
		}
		System.out.println(maximum);
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
