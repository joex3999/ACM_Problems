import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_538B_QuasiNumbers {
	static int []dp;
	static ArrayList<Integer> list ;
	public static int change(int value){
		if(value==0)
			return 0 ;
		if(value<0)
			return Integer.MAX_VALUE;
		if(dp[value]!=-1)
			return dp[value];
		int min = Integer.MAX_VALUE;
		for(int i=0 ; i <list.size();i++){
			if(list.get(i)<=value)
			min = Math.min(min,change(value-list.get(i)));
		}
		
		return dp[value]=1+min;
	}
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	list = new ArrayList<Integer>();
	dp = new int [10000000];
	for(int i = 0 ; i<1000000;i++){
		if(can(i)){
			list.add(i);
		
		}
	}
list.remove(0);
Arrays.fill(dp,-1);
	int X = sc.nextInt();
	System.out.println(change(X));
}
public static boolean can(int i){

	for( ; i>1;){
	
if(i%10!=0 &&i%10!=1)
	return false ;
else
	i/=10;
}

return true ;

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
