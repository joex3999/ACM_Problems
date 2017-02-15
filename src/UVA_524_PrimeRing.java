import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_524_PrimeRing {
	static int[] num;
	static boolean[] taken;
	static boolean[] prime;
	static ArrayList<String>[] list;
	static boolean[] found;

	public static void solve(int i, String s) {
		if (i == taken.length - 1) {
			if (prime[num[num.length - 1] + 1]) {
				list[num.length].add(s.substring(0, s.length() - 1));
				found[num.length] = true;
			}
			return;
		}
		for (int j = 2; j < taken.length; j++) {
			if (!taken[j] && prime[num[i - 1] + j]) {
				taken[j] = true;
				num[i] = j;
				solve(i + 1, s + j + " ");
				taken[j] = false;
			}
		}
	}

	public static void main(String[] args)throws Exception{
		list = new ArrayList[17];
		found = new boolean[17];
		prime = new boolean[32];
		prime[2] = prime[3] = prime[5] = prime[7] = prime[11] = prime[13] = prime[17] = prime[19] = prime[23] = prime[29] = prime[31] = true;
		for (int i = 0; i < list.length; i++)
			list[i] = new ArrayList<String>();
		for (int i = 2; i < 17; i++) {
			num = new int[i];
			num[0] = 1;
			taken = new boolean[i + 1];
			solve(1, "1 ");
		}
		list[1].add("1");

		Scanner in = new Scanner(System.in);
		int casee = 1;
		while (in.ready()) {
			if (casee > 1)
				System.out.println();
			int n = in.nextInt();
			System.out.println("Case " + casee + ":");
			StringBuilder temp = new StringBuilder();
			for (String x : list[n])
				temp.append(x + "\n");
			if (temp.length() > 0)
				System.out.println(temp.substring(0, temp.length() - 1));
			casee++;
		}
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