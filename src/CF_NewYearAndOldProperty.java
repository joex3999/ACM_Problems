import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_NewYearAndOldProperty {

	static public long flipBits2(long n) {
		int k = (int)Math.ceil(Math.log(n)/Math.log(2));
	    int mask = (1 << k) - 1;
	    return ~n & mask;
	}
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	long start = sc.nextLong();
	long end = sc.nextLong();
	double minimumBits =Math.ceil(( Math.log(start)/Math.log(2)));
	double maximumBits =Math.ceil(( Math.log(end)/Math.log(2)));
	for(double i = minimumBits;i<=maximumBits;i++){
		String x =  "0";
		String y = "0";
		for(int j = 0 ;j<i;j++ ){
			x= "1"+x;
			y = y+"1";
		}
		System.out.println(x);
		int svalue = Integer.parseInt(x);
		int evalue = Integer.parseInt(y);
				
	while(svalue<=evalue){
		svalue = ((svalue<<1)+1)&0x11;
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
