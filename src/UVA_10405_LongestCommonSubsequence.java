import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10405_LongestCommonSubsequence {
	static int dp[][];
	static char[] x;
	static char[] y;

	public static int LCS(int indexX, int indexY) {

		if (indexX == x.length || indexY == y.length)
			return 0;

		if (dp[indexX][indexY] != -1)
			return dp[indexX][indexY];

		if (x[indexX] == y[indexY])
			return dp[indexX][indexY] = 1 + LCS(indexX + 1, indexY + 1);
		else
			return dp[indexX][indexY] = Math.max(LCS(indexX, indexY + 1),
					LCS(indexX + 1, indexY));

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder b = new StringBuilder();
		while (sc.ready()) {
			String xx = sc.nextLine();
			x = xx.toCharArray();
			String yy = sc.nextLine();
			y = yy.toCharArray();
			dp = new int[1005][1005];
			for (int i = 0; i < 1005; i++) {
				Arrays.fill(dp[i], -1);
			}

			b.append(LCS(0, 0)+"\n");

		}
	System.out.println(b.replace(b.length()-1,b.length(),"").toString());
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
