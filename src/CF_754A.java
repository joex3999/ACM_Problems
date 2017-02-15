import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_754A {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
	boolean in= false ;
		int arr [] = new int [n];
		StringBuilder answer2 = new StringBuilder();
		StringTokenizer st = new StringTokenizer(sc.nextLine());
	int sum = 0 ;
		for(int i = 0 ; i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		sum+=arr[i];
		}
		
		if(sum==0){
			for(int i = 0;i < n;i++){
				if(arr[i] != 0){
					System.out.println("YES");
					in = true ;
					System.out.println(2);
					System.out.println(1 + " " + (i+1));
					System.out.println((i+2) + " " + n);
					return;
				}
			}
		}else{
			System.out.println("YES");
			System.out.println(1);
			System.out.println(1 + " " + n);
			return ;
		}
		
		if(!in){
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
