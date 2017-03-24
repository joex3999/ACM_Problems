import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_313B_IIyaandQueries {
	static int[] dp;
	static char[] arr;

	// public static int solve(int index){
	// if(index>=arr.length)
	// return 0;
	// if(dp[index]!=-1)
	// return dp[index];
	// if(arr[index]==arr[index-1])
	// return
	//
	// }
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		arr = sc.nextLine().toCharArray();
		int[] values = new int[arr.length];
		StringBuilder sb = new StringBuilder();
		// dp = new int [100000];
		// Arrays.fill(dp,-1);
		// dp[0]=1;
values[0]=1;
for(int i= 1 ; i<arr.length;i++){
 if(arr[i]==arr[i-1])
	values[i] = values[i-1]+1;
 else
	 values[i]=values[i-1];
}
		int N = sc.nextInt();
	
		while (N-- > 0) {
			int answer = 0;
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			answer = values[y] - values[x];
					sb.append(answer + "\n");
		}
		System.out.println(sb.replace(sb.length() - 1, sb.length(), ""));
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
