import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class UVA_11286_Conformity {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			TreeMap<String, Integer> map = new TreeMap<String, Integer>();
			String[] arr = new String[n];
			int max = 1;

			for (int i = 0; i < n; i++) {
				String s = "";
				int[] arr2 = new int[5];
				for (int j = 0; j < 5; j++) {
					arr2[j] = sc.nextInt();

				}
				Arrays.sort(arr2);
				for (int j = 0; j < 5; j++) {
					s += arr2[j] + "";
				}
				arr[i] = s;
				if (map.containsKey(s)) {
					int g = map.get(s);
					map.remove(s);
					map.put(s, g + 1);
					if (g + 1 > max) {
						max = g + 1;
					}
				} else {
					map.put(s, 1);

				}
			}
			int counter = 0;
			if(max==1){
				sb.append(n+"\n");
				continue;
			}
			for (int i = 0; i < n; i++) {

				if (map.get(arr[i]) == max) {
					counter++;

				}

			}
			sb.append(counter + "\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
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
