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

public class CF_766A_MahmoudAndLongestCS {
	static char[] arr1;
	static char[] arr2;
	static int dp[][];

	public static int LCS(int indexX, int indexY) {

		if (indexX == arr1.length || indexY == arr2.length)
			return 0;

		if (dp[indexX][indexY] != -1)
			return dp[indexX][indexY];

		if (arr1[indexX] != arr2[indexY])
			return dp[indexX][indexY] = 1 + LCS(indexX + 1, indexY + 1);
		else
			return dp[indexX][indexY] = Math.max(LCS(indexX, indexY + 1),
					LCS(indexX + 1, indexY));

	}

	public static int solve(int index1, int index2) {
		if (index1 == arr1.length || index2 == arr2.length)
			return 0;
		if (dp[index1][index2] != -1)
			return dp[index1][index2];
		int first;
		int second;
		int third;
		if (arr1[index1] != arr2[index2]) {
			first = 1 + solve(index1 + 1, index2 + 1);
			second = solve(index1 + 1, index2 + 1);
		} else {
			first = solve(index1 + 1, index2 + 1);
			second = solve(index1, index2 + 1);
			third = solve(index1 + 1, index2);
		}
		return dp[index1][index2] = Math.max(first, Math.max(second, 0));
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ss = sc.nextLine();
		arr1 = s.toCharArray();
		arr2 = ss.toCharArray();
		if (s.equals(ss)) {
			System.out.println(-1);
			return;
		}
		int answer = 1;

		if (s.length() > ss.length()) {
			answer = s.length();
		} else {
			if (ss.length() > s.length()) {
				answer = ss.length();
			} else {
				answer = ss.length();
			}
		}
		System.out.println(answer);

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
