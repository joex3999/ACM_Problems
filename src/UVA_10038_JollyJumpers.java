import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class UVA_10038_JollyJumpers {
	public static void main(String[] args) throws Exception {


	Scanner sc = new Scanner(System.in);
	StringBuilder sb = new StringBuilder();
	loop:while(sc.ready()){
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int n =Integer.parseInt(st.nextToken());
		boolean []bool = new boolean [n];
		int [ ]arr = new int [n];
		for(int i =0 ; i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		
		}
		for(int i =1 ; i<n;i++){
			int val = Math.abs(arr[i]-arr[i-1]);
			
			if(val<=n-1)
			bool[Math.abs(arr[i]-arr[i-1])]=true;
		}
		boolean Ans = true ;
		for(int i = 1 ; i<=n-1;i++){
			
			if(!bool[i])
				Ans=false;
		}
		String s = Ans?"Jolly\n":"Not jolly\n";
		sb.append(s);
	}

	System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
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
