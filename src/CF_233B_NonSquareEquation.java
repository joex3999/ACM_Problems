import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_233B_NonSquareEquation {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		long n = input.nextLong();
		int min = 1000000001;
		for (int i = 1; i <= 100; i++) {
			int lo = 0, hi = (int) 1e9;
			for (int j = 0; j < 100; j++) {
				int mid = (lo + hi) / 2;
				if (calculate(mid, i) > n)
					hi = mid;
				else
					lo = mid;
			}

			if (calculate(lo, i) == n && sum(lo) == i)
				min = Math.min(min, lo);
		}
		if (min > 1e9)
			sb.append(-1);
		else
			sb.append(min);
		System.out.println(sb.toString());
	}

	public static long calculate(int x, int s) {
		return (long) x * (x + s);
	}

	public static long sum(long n) {
		long res = 0;
		while (n > 0) {
			res += n % 10;
			n /= 10;
		}
		return res;
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