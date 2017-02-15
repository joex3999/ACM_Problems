import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_WoodCutters {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] height = new int[n];
		boolean[] fell = new boolean[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			height[i] = sc.nextInt();
		}
		int answer = 1;
		boolean fellleft = false;
		for (int i = 1; i < n;i++) {
			fellleft = false;
			int left = arr[i] - height[i];
			if (fell[i - 1]) {
				int right = arr[i - 1] + height[i - 1];
				if (left > right) {
					answer++;
					fellleft = true;
				}
			} else {
				if (left > arr[i - 1]) {
					answer++;
					fellleft = true;
				}
			}

			if (!fellleft) {
				int right = arr[i] + height[i];
				if (i==n-1||right < arr[i + 1]) {
					answer++;
					fell[i] = true;
				}
			}
		}

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
