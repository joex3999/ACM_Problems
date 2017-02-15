import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_204B_LittleElephantAndCards {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int minimum = (int) Math.ceil(((double) n) / 2);
		HashMap<Integer, Integer> faceUp = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> faceDown = new HashMap<Integer, Integer>();
		int[] one = new int[n];
		int[] two = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			one[i]= first ;
			two[i]= second;
			
			if (first == second) {
				two[i]=-1;
				int value = 0;
				if (faceUp.containsKey(first)) {
					value = faceUp.get(first);
					faceUp.remove(first);
				}
				faceUp.put(first, value + 1);
			} else {
				int value1 = 0;
				int value2 = 0;
				if (faceUp.containsKey(first)) {
					value1 = faceUp.get(first);
					faceUp.remove(first);
				}
				if (faceDown.containsKey(second)) {
					value2 = faceDown.get(second);
					faceDown.remove(second);
				}
				faceUp.put(first, value1 + 1);
				faceDown.put(second, value2 + 1);
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int now = one[i];
			int current = faceUp.get(now);
			int cost = 0;
			if (current < minimum) {
				int current2 = 0 ;
				if(faceDown.containsKey(now))
				 current2 = faceDown.get(now);
				if (current + current2 >= minimum) {
					cost = minimum - current;
					answer = Math.min(answer, cost);
				}
			} else {
				answer = Math.min(answer, cost);

			}
		}

		for (int i = 0; i < n; i++) {
			int now = two[i];
			if(now==-1)
				continue;
			int current = faceDown.get(now);
			int cost = current;
			if (current < minimum) {
				int current2 = 0 ;
				if(faceUp.containsKey(now))
			 current2 = faceUp.get(now);
				if (current + current2 >= minimum) {
					answer = Math.min(answer, cost);
				}
			} else {
				answer = Math.min(answer, cost);
			}
		}
		String answerr = (answer==Integer.MAX_VALUE)?"-1":answer+"";
		System.out.println(answerr);
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
