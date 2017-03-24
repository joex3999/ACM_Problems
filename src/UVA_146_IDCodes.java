import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// solution tstyf a5r 7aga
public class UVA_146_IDCodes {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		StringBuilder sb = new StringBuilder();
		loop2: while (true) {
			String s = sc.nextLine();
			if (s.equals("#"))
				break;
			char[] arr = s.toCharArray();
			char least = '{';

			int index = -1;
			boolean found = false;
			boolean in = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] < arr[i + 1])
					in = true;
			}
			if (!in) {

				sb.append("No Successor\n");
				continue loop2;
			}
			int i;

			loop: for (i = arr.length - 2; i >= 0; --i) {

				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] > arr[i]) {

						found = true;
						if (arr[j] < least) {
							least = arr[j];
							index = j;
						}
					}
				}
				if (found)
					break loop;
			}
			StringBuilder sb2 = new StringBuilder();

			char temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;

			for (int j = 0; j <= i; j++) {
				sb2.append(arr[j]);
			}
			int[] arr2 = new int[arr.length - i - 1];
			for (int j = 0, k = i + 1; k < arr.length; j++, k++) {
				arr2[j] = arr[k];

			}
			Arrays.sort(arr2);

			for (int j = 0; j < arr2.length; j++) {
				sb2.append((char) arr2[j]);
			}

			sb.append(sb2.toString() + "\n");
		}
		System.out.println(sb.replace(sb.length() - 1, sb.length(), "")
				.toString());

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