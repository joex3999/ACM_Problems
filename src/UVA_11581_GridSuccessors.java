import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11581_GridSuccessors {
	public static boolean valid(int x, int y) {
		return (x >= 0 && y >= 0) && (x < 3 && y < 3);
	}

	public static int[][] solve(int[][] arr) {
		int[][] result = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int sum = 0;
				if (valid(i - 1, j))
					sum += arr[i - 1][j];
				if (valid(i + 1, j))
					sum += arr[i + 1][j];
				if (valid(i, j - 1))
					sum += arr[i][j - 1];
				if (valid(i, j + 1))
					sum += arr[i][j + 1];
				result[i][j] = sum % 2;
			}
		}
		return result;
	}

	public static boolean allZero(int[][]arr){
		for(int i =0 ; i<3;i++){
			for(int j=0; j<3;j++){
				if(arr[i][j]!=0)
					return false ;
			}
		}
		
		return true ;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			sc.nextLine();
			int[][] arr = new int[3][3];
			for (int i = 0; i < 3; i++) {
				String s = sc.nextLine();

				for (int j = 0; j < 3; j++) {
					arr[i][j] = s.charAt(j)-48;
				}
			}
			int counter = 0;

		
			while (true) {
				if (allZero(arr)) {
					sb.append((counter-1)+"\n");
					break;
				}
				arr = solve(arr);
				counter++;

			}
		}
		System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
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
