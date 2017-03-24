import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_10901_FerryLoadingIII {
	public static class Pair {
		int time;
		String pos;
		int index;
		int answer;

		public Pair(int i, int t, String p) {
			index = i;
			time = t;
			pos = p;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		int T = sc.nextInt();
		Queue<Pair> queLeft = new LinkedList<Pair>();
		Queue<Pair> queRight = new LinkedList<Pair>();
		while (T-- > 0) {
			int max = sc.nextInt();
			int t = sc.nextInt();
			int m = sc.nextInt();
			int totalTime = 0;
			int iter = 0;
			int fpos = 0;
			Pair[] ferr = new Pair[m];
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				ferr[i] = new Pair(i, Integer.parseInt(st.nextToken()),
						st.nextToken());

			}
			for (; true;) {
				ArrayList<Pair> onBoard = new ArrayList<Pair>();
				Pair s = new Pair(0, 0, "X");
				if (fpos < ferr.length) {
					s = ferr[fpos];

				}
				if (queLeft.isEmpty() && queRight.isEmpty()) {
					totalTime += s.time;

				}
				if (s.pos.equals("left")) {
					queLeft.add(s);
					//fpos++;
				}
				
				if (iter % 2 == 0) {
					for (int k = 0; k < max; k++) {
						if (!queLeft.isEmpty()) {
							;
							Pair pp = queLeft.remove();
							onBoard.add(pp);
							pp.answer = totalTime + t;
						}
					}
				} else {
					for (int k = 0; k < max; k++) {
						if (!queRight.isEmpty()) {

							Pair pp = queRight.remove();
							onBoard.add(pp);
							pp.answer = totalTime + t;
						}
					}
				}
				totalTime += t;
				iter++;
				if (fpos == ferr.length && queRight.isEmpty()
						&& queLeft.isEmpty())
					break;
				for (int l = fpos; l < ferr.length; l++) {
					Pair g = ferr[l];
					if (g.time > totalTime)
						break;
					fpos++;
					if (g.pos.equals("left")) {
						queLeft.add(g);
					} else {
						queRight.add(g);
					}
				}
			}

			for (int i = 0; i < ferr.length; i++) {
				System.out.println(ferr[i].answer + "  " + ferr[i].time);
			}

		}
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
