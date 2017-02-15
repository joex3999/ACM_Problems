import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF_704A_Thor {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int[] notRead = new int[n + 1];

		int[] total = new int[n + 1];
		int[] read = new int[n + 1];
		int []last = new int[n+1];
		ArrayList<Integer> timeline = new ArrayList<Integer>();
		int last3 = 0;
		int totalN = 0;
		for (int i = 0; i < q; i++) {
			int type = sc.nextInt();
			if (type == 1) {
				int app = sc.nextInt();
				total[app]++;
				notRead[app]++;
				timeline.add(app);
				totalN++;
			} else {
				if (type == 2) {
					int app = sc.nextInt();
					read[app] += notRead[app];
					totalN -= notRead[app];
					notRead[app] = 0;

				} else {
					int to = sc.nextInt();
					for(int j = last3 ; j<to;j++){
						int app = timeline.get(j);
						last[app]++;
						if(last[app]>read[app])
						{
							read[app]++;
							notRead[app]--;
						totalN--;
						}
					}
					if(to>=last3)
					last3 = to;
				}
			}
			if(totalN>=0){
		sb.append(totalN+"\n");
			System.out.println(totalN);
			}else{
				sb.append(0+"\n");
			totalN=0;
			System.out.println(0);
			}	}
		System.out.println(sb.toString());
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
