package GoodBye2016;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C {
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
System.out.println(1e9);
int min = -(int)1e9;
int max =(int)1e9;
	for(int i =0 ; i<n;i++){
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		 if (d == 1) {
             min = Math.max(min, 1900);
         } else {
             max = Math.min(max, 1899);
         }
         min += c;
         max += c;
     }
     if (min > max) {
         System.out.println("Impossible");
     } else if (max > (int)1e9/2) {
         System.out.println("Infinity");
     } else {
        System.out.println(max);
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

}}