import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CF_535B_TavasAndSaddas {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int O = n;
		int num = 1;
		while (n / 10 >= 1) {
			n /= 10;
			num++;

		}
		HashSet<Long>ss = new HashSet<Long>();
		
		int num2 = ((int) Math.pow(2, num)) - 1;
		int answer = 0;
		for(int S = num ;S>0;S--){
		for (int i = num2; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			for(int k=0 ; k<S;k++){
				int bit = (i&(1<<k))==0?4:7;
				sb.append(bit);
			}
			long g = Long.parseLong(sb.toString());
			if(!ss.contains(g)){
				ss.add(g);
			
				if(O>g)
					answer++;
			}
		}
		}
System.out.println(answer+1);
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
