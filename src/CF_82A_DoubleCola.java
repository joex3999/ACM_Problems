import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CF_82A_DoubleCola {
	public static class Pair {
		char Character;
		int number;

		public Pair(char charr, int num) {
			Character = charr;
			number = num;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Deque<Pair> que = new LinkedList<Pair>();

		que.addFirst(new Pair('H', 1));
		que.addFirst(new Pair('R', 1));
		que.addFirst(new Pair('P', 1));
		que.addFirst(new Pair('L', 1));
		que.addFirst(new Pair('S', 1));
		int till = 0 ;
		for (int i = 0; i < 10000000; i++) {
			Pair x = que.getFirst();
			char c = x.Character;
			int num = x.number;
			till+=num;
	
			que.removeFirst();
			que.addLast(new Pair(c, num * 2));

			if (till >= n) {
				switch(c){
				case 'H':System.out.println("Howard"); break ;
				case 'R':System.out.println("Rajesh"); break ;
				case 'P': System.out.println("Penny");break ;
				case 'L':System.out.println("Leonard"); break ;
				case 'S': System.out.println("Sheldon");break ;
				}
				return;
			}
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
