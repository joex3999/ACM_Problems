import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Time Limit Exceed
public class UVA_11475_ExtendedToPalindrome {
	static int[] prefixFunction(char[] s) {
		int n = s.length;
		int[] pi = new int[n];
		for (int i = 1, j = 0; i < n; ++i) {
			while (j > 0 && s[i] != s[j])
				j = pi[j - 1];
			if (s[i] == s[j])
				++j;
			pi[i] = j;

		}
		return pi;
	}

	static String reverse(String x) {
		String result = "";
		for (int i = 0; i < x.length(); i++) {
			result = x.charAt(i) + result;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
StringBuilder sb = new StringBuilder();

while(sc.ready()){
String s = sc.nextLine();
		String reverse = reverse(s);
		char[] a = (reverse + "$" + s).toCharArray();
		int[] arr = prefixFunction(a);
		StringBuilder sb1 = new StringBuilder();
		sb.append(s);
		
		boolean zero = false;

		int max = Integer.MIN_VALUE;
		int index = 0;
int value = arr[arr.length-1];
sb1.append(reverse.substring(value, reverse.length()));
sb.append(sb1+"\n");

}
System.out.println(sb.replace(sb.length()-1,sb.length(), "").toString());
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
