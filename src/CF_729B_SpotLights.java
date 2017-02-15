import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_729B_SpotLights {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		boolean found = false;
		for (int i = 0; i < n; i++) {
			found = false ;
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					found = true;
				if (map[i][j] == 0 && found)
					result++;

			}
		}
	 found = false;
		for (int i = n-1; i >= 0; i--) {
			found = false ;
			for (int j = m-1; j >= 0; j--) {
				if (map[i][j] == 1)
					found = true;
				if (map[i][j] == 0 && found)
					result++;

			}
		}
		
		for (int j = 0; j <m; j++) {
			found = false ;
			for (int i = 0; i <n; i++) {
				if (map[i][j] == 1)
					found = true;
				if (map[i][j] == 0 && found)
					result++;

			}
		}
		
		
		for (int j = m-1; j >=0; j--) {
			found = false ;
			for (int i = n-1; i >=-0; i--) {
				if (map[i][j] == 1)
					found = true;
				if (map[i][j] == 0 && found)
					result++;

			}
		}
	System.out.println(result);
	}
}

class Scanner {
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
