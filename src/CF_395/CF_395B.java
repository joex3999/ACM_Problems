package CF_395;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_395B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] result = new int[n];
		for (int i = 0; i <= (n / 2); i++) {
			if (i % 2 == 0) {
				result[i] = arr[n - i - 1];
			} else {
				result[i] = arr[i];
			}
		}
		int iteration = 0;
		for (int i = n - 1; i >= (n / 2); i--) {
			if (iteration % 2 == 0) {
				result[i] = arr[n - i - 1];
			} else {
				result[i] = arr[i];
			}
			iteration++;

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(result[i] + " ");

		System.out.println(sb.replace(sb.length() - 1, sb.length(), "")
				.toString());

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
