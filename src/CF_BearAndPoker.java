import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_BearAndPoker {
	static final double factor = 0;
	private static long gcd(long a, long b)
	{
	    while (b > 0)
	    {
	        long temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}
	private static long lcm(long a, long b)
	{
	    return a * (b / gcd(a, b));
	}

public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	
	long gcd = 0 ;
	long [] arr = new long[n];
	for(int i =0 ; i<n;i++){
		arr[i]= sc.nextLong();
		
		gcd = gcd(gcd,arr[i]);
	
	}

	for(int i =0 ; i<n;i++){
		long value = arr[i]/gcd;

		while(value%3==0)
			value/=3;
		
		while(value%2==0)
			value/=2;
		
		if(value!=1){
			System.out.println("No");
			return;
		}
	}
	System.out.println("Yes");
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
