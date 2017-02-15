import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CF_PrimeMatrix {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		boolean[] sieve = new boolean[1000000];
		Arrays.fill(sieve, true);
		sieve[0] = sieve[1] = false;
		for (int i = 2; i < 1000000; i++) {
			if (!sieve[i])
				continue;
			for (long j = (long) i * i; j < 1000000; j += i) {
				sieve[(int) j] = false;
			}
		}
		int n = input.nextInt(), m = input.nextInt();
		int[][] data = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				data[i][j] = input.nextInt();
		int[] count = new int[200000];
		count[100000] = 3;
		for (int i = 99999; i >= 0; i--) {
			if (sieve[i])
				count[i] = 0;
			else
				count[i] = 1 + count[i + 1];
		}
		int res = 100000;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++)
				sum += count[data[i][j]];
			res = Math.min(res, sum);
		}
		for (int i = 0; i < m; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++)
				sum += count[data[j][i]];
			res = Math.min(res, sum);
		}
		System.out.println(res);

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