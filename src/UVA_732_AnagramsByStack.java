import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_732_AnagramsByStack {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		StringBuilder tot = new StringBuilder();
		while (sc.ready()) {
			tot.append("[\n");
			String first = sc.nextLine();
			String second = sc.nextLine();
			if(first.length()==1&&first.equals(second)){
				tot.append("i o\n]\n");
				continue ;
			}
			long value = 2 << (first.length() * 2 - 2);

			long value2 = (2 << (first.length() * 2 - 1)) - 1;
			int log = first.length() * 2 - 1;

			int half = log / 2 + 1;

			loop: for (long i = value2; i > value; --i) {
				Stack<Character> stack = new Stack<Character>();
				StringBuilder s = new StringBuilder();
				StringBuilder ans = new StringBuilder();
				int pos = 0;
				int pos2 = 0;
				int num1 = 0;
				int num0 = 0;
				for (int k = 0; k <= log; k++) {
					int bit = ((int) i & (1 << (log - k))) > 0 ? 1 : 0;

					if (bit == 1) {
						ans.append("i ");
						num1++;
						if (num1 > half)
							continue loop;
						stack.push(first.charAt(pos++));

					} else {
						ans.append("o ");
						num0++;
						if (num0 > half)
							continue loop;
						if (stack.isEmpty()
								|| stack.peek() != second.charAt(pos2++)) {
							continue loop;
						} else {
							char g = stack.pop();

							s.append(g);

						}
					}
					if (k == log && s.toString().equals(second)) {
						tot.append(ans.replace(ans.length() - 1, ans.length(),
								"") + "\n");
					}
				}

			}
			tot.append("]\n");
		}
		System.out.println(tot.replace(tot.length() - 1, tot.length(), "")
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
