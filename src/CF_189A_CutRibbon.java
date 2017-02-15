import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_189A_CutRibbon {
	static int n;
	static int a;
	static int b;
	static int c;
	static int[] dp = new int[4005];

	 public static int doit(int length) {
		if (length == 0)
			return 0;
		if (length < 0)
			return Integer.MIN_VALUE;
		if (dp[length] != -1)
			return dp[length];

		int G = doit(length - a)+1;
		int X = doit(length - b)+1;
		int Y = doit(length - c)+1;
		return dp[length] = Math.max(Math.max(G, Y), X);

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		Arrays.fill(dp, -1);
		int solution = doit(n);
		System.out.println(solution);

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
