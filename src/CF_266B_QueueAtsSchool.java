import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CF_266B_QueueAtsSchool {
public static void main(String[] args)throws Exception{
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();
int t = sc.nextInt();
char [] bg = sc.nextLine().toCharArray();
for(int i =0 ; i<t;i++){
	for(int j =1 ; j<n;j++){
		char now = bg[j];
		char bef = bg[j-1];
		if(bef=='B'&&now =='G')
		{
			bg[j-1]= 'G';
		bg[j]='B';
		j+=1;
		}
	}

}
for(int g =0 ; g<n;g++)
	System.out.print(bg[g]);

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
