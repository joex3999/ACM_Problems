import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11559_EventPlanning {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (sc.ready()) {
			int N = sc.nextInt();
		
			int B = sc.nextInt();
			int H = sc.nextInt();
			int W = sc.nextInt();
			int minimum = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				int cost = sc.nextInt();
				for (int j = 0; j < W; j++) {
					int capacity = sc.nextInt();
					if (capacity >= N) {
						int totalCost = N * cost;
						if(totalCost<=B)
						minimum = Math.min(minimum, totalCost);
					}
				}
			}
			if(minimum==Integer.MAX_VALUE)
			sb.append("stay home\n");
			else
				sb.append(minimum+"\n");
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
