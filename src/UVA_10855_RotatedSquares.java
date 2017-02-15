import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10855_RotatedSquares {
	public static char[][] Rotate90(char[][] arr) {
		char[][] result = new char[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				result[i][j] = arr[arr.length - 1 - j][i];
			}
		}
		return result;
	}

	public static int Check(char[][] arr1, char[][] arr2) {
		int counter = 0;
		for (int i = 0; i < arr1.length; i++) {
			loop: for (int j = 0; j < arr1.length; j++) {
			
				for (int k = 0; k < arr2.length; k++) {
					for (int l = 0; l < arr2.length; l++) {
							if(k+i>arr1.length-1||l+j>arr1.length-1)
								continue loop;
						if (arr1[k+i][l+j] != arr2[k][l])
							continue loop;
						if (arr1[k+i][l+j] == arr2[k][l]
								&& l == arr2.length - 1 && k == l)
							counter++;
						

					}
					
				}
			}
		}
		return counter;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
StringBuilder sb = new StringBuilder();
		while (true) {
			int N = sc.nextInt();
			int n = sc.nextInt();
			if (N == n && n == 0)
				break;
			char[][] Arr = new char[N][N];
			char[][] arr = new char[n][n];
			for (int i = 0; i < N; i++) {
				char[] line = sc.nextLine().toCharArray();
				for (int j = 0; j < N; j++) {
					char c = line[j];
					Arr[i][j] = c;
				}
			}
			for (int i = 0; i < n; i++) {
				char[] line = sc.nextLine().toCharArray();
				for (int j = 0; j < n; j++) {
					char c = line[j];
					arr[i][j] = c;
				}
			}

			int first = Check(Arr, arr);
			arr = Rotate90(arr);
			int second = Check(Arr, arr);
			arr = Rotate90(arr);
			int third = Check(Arr, arr);
			arr = Rotate90(arr);

			int fourth = Check(Arr, arr);
			sb.append(first + " " + second + " " + third + " "
					+ fourth+"\n");
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
