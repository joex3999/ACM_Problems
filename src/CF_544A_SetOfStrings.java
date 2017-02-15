import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class CF_544A_SetOfStrings {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		if(n==1){
		System.out.println("YES");
			System.out.println(s);
		return ;
		}
		char[]g = s.toCharArray();
		
		HashSet<Character>set = new HashSet<Character>();
		for(int i = 0 ;i<g.length;i++){
			if(!set.contains(g[i])&&n>0){
				sb.append("\n"+g[i]);
				set.add(g[i]);
				n--;
			}else{
				sb.append(g[i]);
			}
		}
		if(n==0){
		
		System.out.print("YES");
		System.out.println(sb.toString());
		}else{
			System.out.println("NO");
		}
	}
static class Scanner {
	StringTokenizer st;
	BufferedReader br;

	public Scanner(String s) throws Exception {
		br = new BufferedReader(new FileReader(s));
	}

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
