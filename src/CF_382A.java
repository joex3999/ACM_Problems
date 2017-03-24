

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_382A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		int m = sc.nextInt();
	char[] arr = sc.nextLine().toCharArray();
int firstPos = 0 ;
	for(int i =0 ; i<arr.length;i++){
		if(arr[i]=='G'||arr[i]=='T'){
			firstPos = i ;
			break;}
	
	}

	int now = firstPos+m ;

	boolean can = false  ; 
while(now<arr.length){
	if(arr[now]=='#')
	{
		System.out.println("NO");
		return ;
	}
	if(arr[now]=='G'||arr[now]=='T')
	{
	
		System.out.println("YES");
		return ;
	}
	now+=m;

}
if(!can){
	System.out.println("NO");
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
