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
public class CF_760A_PetrAndCalendar {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int d = sc.nextInt();
		int noOfDays = 0;
		if(d==1&&m==2){
			System.out.println(4);
			return;}
		switch(m){
		case 2:noOfDays=28; break;
		case 4:noOfDays=30;break;
		case 6:noOfDays=30;break;
		case 9:noOfDays=30;break;
		case 11: noOfDays=30;break;
			default : noOfDays=31;break;
		}
		
		noOfDays-=7*4;
		noOfDays-=8-d;
	
		if(noOfDays>0){
			System.out.println(6);
		}else{
			System.out.println(5);
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
