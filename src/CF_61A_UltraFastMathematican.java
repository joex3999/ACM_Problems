import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_61A_UltraFastMathematican {
	static String DecToBin(int n){
		String b = "";
		if(n==0){
			return ""+0 ;
		}
		int msk = 1 ;
		double fec =  Math.log(n)/Math.log(2);
		int test = (int) fec;
		
		int factor = (int)Math.ceil(fec);
		if(test==factor){
			factor++;
		}
	for(int i =0 ; i<factor;i++){
		int leftmost = n&msk;
		b= leftmost + b ;
		n=n>>1;}

	return b.toString();
		
	}
	public static void main(String[] args) throws Exception {
		
	Scanner sc = new Scanner(System.in);
	
	StringBuilder x  = new StringBuilder(sc.nextLine());
	StringBuilder y = new StringBuilder(sc.nextLine());
	StringBuilder g = new StringBuilder();
	for(int i=0;i<x.length();i++){
		g.append(Integer.parseInt(x.charAt(i)+"")^Integer.parseInt(y.charAt(i)+""));
	}
	System.out.println(g.toString());


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
