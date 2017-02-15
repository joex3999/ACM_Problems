import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class CF_432B_FootballKit {
	public static class Pair{
		int x ;
		int y ;
		public Pair(int g,int s ){
			x =g ;
			y =s;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		int []left = new int[100002];
		int []right = new int[100002];
		Pair[]arr = new Pair[n];
		for(int i=0 ; i<n;i++){
			int first = sc.nextInt();
			int second = sc.nextInt();
			left[first]++;
			right[second]++;
			arr[i]= new Pair(first,second);
		}
		
		for(int i =0 ; i<n;i++){
			int l = arr[i].x;
			int r = arr[i].y;
			int ans1 = n-1;
			int ans2 = n-1;
			int val = left[r];
			
			ans2-=val;
			ans1+=val;
					sb.append(String.format("%s %s\n",ans1,ans2));
		}
		System.out.println(sb.toString());
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
