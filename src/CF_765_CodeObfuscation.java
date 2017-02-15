import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CF_765_CodeObfuscation {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.nextLine().toCharArray();
		char last = arr[0];
			if(arr[0]!='a')
			{
				System.out.println("NO");
				return;
			}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				break;
			if (i == arr.length - 1 && arr[i] == arr[i - 1] && arr[i] != 'a') {
				System.out.println("NO");
				return;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == last)
				arr[i] = '#';
		}
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != '#') {

				if (last != arr[i] - 1) {

					System.out.println("NO");
					return;
				} else {
					for (int j = i + 1; j < arr.length; j++) {
						if (arr[j] == arr[i])
							arr[j] = '#';
					}
					last = arr[i];

				}
			}
		}

		System.out.println("YES");
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
