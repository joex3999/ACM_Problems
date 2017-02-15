import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10452_MarcusHelp {
	static int n;
	static int m;

	public static boolean valid(int i, int j) {
		return (i >= 0 && j >= 0) && i < n && j < m;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		char[] word = { 'I', 'E', 'H', 'O', 'V', 'A', '#' };
		while (T-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			int posx = n-1;
			int posy = 0;
			char[][] arr = new char[n][m];
			for (int i = 0; i < n - 1; i++)
				arr[i] = sc.nextLine().toCharArray();

			char[] temp = sc.nextLine().toCharArray();
			for (int i = 0; i < m; i++) {
				arr[n-1][i] = temp[i];
				
				if (temp[i] == '@') {
					posy = i;
				}
			}
		

			char[] seq = "IEHOVA#".toCharArray();
			for(int k = 0; k < seq.length; ++k)
			{
				if(k != 0)
					sb.append(" ");
				if(posy > 0 && arr[posx][posy - 1] == seq[k])
				{
					sb.append("left");
					--posy;
				}
				else if(posy < m - 1 && arr[posx][posy + 1] == seq[k])
				{
					sb.append("right");
					++posy;
				}
				else
				{
					sb.append("forth");
					--posx;
				}
			}
			sb.append("\n");
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
