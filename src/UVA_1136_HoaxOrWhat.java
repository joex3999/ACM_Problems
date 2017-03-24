import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class UVA_1136_HoaxOrWhat {
	public static class Intt implements Comparable {
		int num;

		public Intt(int s) {
			num = s;
		}

		@Override
		public int compareTo(Object arg0) {
			int num2 = ((Intt) arg0).num;
			if (num > num2)
				return -1;
			else {
				if (num < num2)
					return 1;
			}
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		StringBuilder sb = new StringBuilder();
		while (true) {
			int answer = 0;

			int n = sc.nextInt();
			int[] arr = new int[1000001];
			if (n == 0)
				break;
			TreeSet<Integer> set = new TreeSet<Integer>();
			for (int j = 0; j < n; j++) {
				int se =sc.nextInt();
				for (int i = 0; i < se; i++) {
					int g = sc.nextInt();
					arr[g]++;
					set.add(g);
				}
				int a = set.first();
				int b = set.last();
				answer += (b - a);
				arr[a]--;
				arr[b]--;
				if (arr[a] == 0)
					set.remove(a);
				if (arr[b] == 0)
					set.remove(b);

			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());

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
