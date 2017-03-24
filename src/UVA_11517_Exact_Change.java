import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_11517_Exact_Change {
	static int cost;
	static int[] arr;
	static Pair[][] dp;

	static class Pair {
		long val, coins;

		Pair(long v, long c) {
			val = v;
			coins = c;
		}
	}
	public static Pair dp (int idx , int sum)
    {
        if (idx == arr.length)
            if (sum < cost) return new Pair(Integer.MAX_VALUE , Integer.MAX_VALUE);
            else return new Pair(0,0);
        if (sum > cost)
            return new Pair(0,0);

        if (dp[idx][sum] != null) return dp[idx][sum];
        Pair take = dp(idx + 1, sum + arr[idx]);
        Pair leave = dp(idx + 1 , sum);

        if (take.val + arr[idx] < leave.val) return dp[idx][sum] = new Pair(take.val + arr[idx] , take.coins + 1);
        else if (take.val + arr[idx] > leave.val) return dp[idx][sum] = leave;
        else return dp[idx][sum] = take.coins + 1 < leave.coins ? new Pair(take.val + arr[idx] , take.coins + 1) : leave;
    }



	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		while (T-- > 0) {
			cost = sc.nextInt();

			int n = sc.nextInt();
			dp = new Pair[100][20005];

			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			Pair minVal = dp(0, 0);
			out.print(minVal.val + " ");

			out.print(minVal.coins);
			out.println();
		}
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
