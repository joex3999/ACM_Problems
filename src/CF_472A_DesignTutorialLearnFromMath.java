import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_472A_DesignTutorialLearnFromMath {
	public static boolean Composite(int number){
int n = (int)Math.sqrt(number);
boolean in = false ;
		for(int i =2;i<=n;i++){
			if(number%i==0){
				in = true ;
			}
		}
	
	return in ;
	}
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);


 int n = sc.nextInt();
 for( int i = 1 ; i<n;i++){
	 int num = n-i;
	 if(i%2==0&&Composite(num)&&Composite(i))
	 {
		 System.out.println(String.format("%s %s",i,num));
		 return;
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
