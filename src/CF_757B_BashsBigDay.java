import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;


public class CF_757B_BashsBigDay {
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	new HashMap<Integer,Integer>();
	int answer =1;
	int[]roots = new int[100050];
	Arrays.fill(roots, 0);
	for(int i =0 ; i<n;i++){
		int g = sc.nextInt();
		int root = (int)Math.sqrt(g);
		for(int j=2 ; j<=root;j++){
			if(g%j==0)
				roots[j]++;
				while(g%j==0)
					g/=j;
		}
			if(g>1)
				roots[g]++;
			
		
	
		
}
	
	for(int i =0 ; i<100050;i++){
		answer=Math.max(answer, roots[i]);
	}
		System.out.println(answer);
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
