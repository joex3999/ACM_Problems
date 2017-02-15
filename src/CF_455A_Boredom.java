import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// should only convert from int to long
public class CF_455A_Boredom {
	static int[] count = new int[100005];
	static int[] dp = new int[100005];
static int maxnum = Integer.MIN_VALUE;
	public static int solve(int index) {
		if (index > maxnum+1)
			return 0;
		if (dp[index] != -1)
			return dp[index];

		return dp[index] = Math.max(solve(index + 1), solve(index + 2)
				+ count[index] * index);
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Arrays.fill(count, 0);
		Arrays.fill(dp,-1);
		for (int i = 0; i < n; i++) {
			int now = sc.nextInt();
			count[now]++;
maxnum = Math.max(maxnum,now);
		}

		int answer = solve(0);
		System.out.println(answer);
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
