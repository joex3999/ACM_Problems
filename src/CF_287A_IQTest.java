import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_287A_IQTest {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[4][4];
		for (int i = 0; i < 4; i++) {
			String g = sc.nextLine();
			for (int j = 0; j < 4; j++) {
				if (g.charAt(j) == '#') {
					arr[i][j] = 1;
				} else {
					arr[i][j] = 0;
				}

			}

		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int white = 0;
				int black = 0;
				if (arr[i][j] == 1)
					white++;
				else
					black++;
				if (arr[i + 1][j] == 1)
					white++;
				else
					black++;
				if (arr[i][j + 1] == 1)
					white++;
				else
					black++;
				if (arr[i + 1][j + 1] == 1)
					white++;
				else
					black++;

				if ((black == 3 && white == 1) || (white == 3 && black == 1)||black==4||white==4) {
					System.out.println("YES");
					return;
				}

			}

		}
		System.out.println("NO");
		return;
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
		}

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
