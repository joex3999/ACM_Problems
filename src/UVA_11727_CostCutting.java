import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11727_CostCutting {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int i = 1; T-- > 0; i++) {
			int one = sc.nextInt();
			int two = sc.nextInt();
			int three = sc.nextInt();
			int max = Math.max(Math.max(one, two), three);
			int min = Math.min(Math.min(one, two), three);
			int answer = 0 ;
			if (one != min && one != max) {
answer = one ;
			}
			if (two != min && two != max) {
answer = two ;
			}
			if (three != min && three != max) {
answer = three;
			}
			if(min==max)
				answer = one;
			sb.append(String.format("Case %s: %s\n", i,answer));
		}
		System.out.println(sb.replace(sb.length()-1, sb.length(), ""));
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
