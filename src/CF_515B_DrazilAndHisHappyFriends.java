import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_515B_DrazilAndHisHappyFriends {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] boys = new boolean[n];
		boolean[] girls = new boolean[m];
		int s = sc.nextInt();
		for (int i = 0; i < s; i++) {
			boys[sc.nextInt()] = true;
		}
		int g = sc.nextInt();
		for (int i = 0; i < g; i++) {
			girls[sc.nextInt()] = true;
		}
		for (int k = 0; k < 1000000; k++) {
			if(boys[k%n]||girls[k%m])
			{
				boys[k%n]= true ;
				girls[k%m]=true;
			}
			
		}
		
		for(int i=0 ; i<n;i++){
			if(!boys[i]){
				System.out.println("NO");
				return;
			}
		}
		for(int i=0 ; i<m;i++){
			if(!girls[i]){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
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
