package GoodBye2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringTokenizer st = new StringTokenizer("");
		
		boolean answer = true;
		int pos = 0 ;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			int dist = Integer.parseInt(st.nextToken()) ;
			String path = st.nextToken();
	if(path.equals("North")){
		pos-=dist;
		if(pos<0){
			System.out.println("NO");
		return;}
	}else
	if(path.equals("South")){
		pos+=dist;
		if(pos>20000){
			System.out.println("NO");
			return;
		}
	}else{
		if(pos==0||pos==20000){
			System.out.println("NO");
			return;
		}
	}
			
		}
		
		if(pos==0)
			System.out.println("YES");
		else
			System.out.println("NO");
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
