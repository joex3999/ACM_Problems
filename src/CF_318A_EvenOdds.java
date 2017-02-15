import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_318A_EvenOdds {
	public static void main(String args[]) throws Exception {
		Scanner z = new Scanner(System.in);
		long n = z.nextLong();
		long k = z.nextLong();
		if (n % 2 == 0) {
			if (k == n / 2)
				System.out.println(n - 1);
			if (k > n / 2)
				System.out.println(2 * (k - n / 2));
			if (k < n / 2)
				System.out.println((2 * k) - 1);
		} else {
			if (k == n / 2 + 1)
				System.out.println(n);
			if (k > n / 2 + 1)
				System.out.println(2 * (k - (n / 2 + 1)));
			if (k < n / 2 + 1)
				System.out.println((2 * k) - 1);
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
