import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_757A_GottaCatchEmAll {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[]arr = sc.nextLine().toCharArray();
		int B = 0 ;
		int u =0 ;
		int l = 0 ;
		//Bulbasaur
		int b=0;
		int a = 0;
		int s = 0 ;
		int r = 0;
		for(int i =0 ; i<arr.length;i++){
			switch(arr[i]){
				case 'B':B++; break;
				case 'u':u++ ;break;
				case 'l':l++ ;break;
				case 'b': b++;break;
				case 'a':a++; break;
				case 's':s++ ;break;
				case 'r': r++;break;
			}
			
		}
		int val = Math.min(B, Math.min(u/2, Math.min(l,Math.min(b,Math.min(a/2,Math.min(s,r))))));
		System.out.println(val);
		
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
