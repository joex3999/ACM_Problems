import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class CF_357_LetMeCountTheWays {
	static int [] coins ={1,5,10,25,50};
	static int [][] dp ;
	public static int solve (int value , int index ){
		if(value==0)
			return 1;
		if(value<0)
			return 0;
		if(dp[value][index]!=-1)
			return dp[value][index];
		if(index<=3)
		 dp[value][index]= solve(value-coins[index],index)+solve(value,index+1);
		else
			dp[value][index] = solve(value-coins[index],index);
		return dp[value][index];
	}
	
public static void main(String[] args)throws Exception{
new BufferedReader(new InputStreamReader(System.in));
Scanner sc = new Scanner(System.in);
dp = new int [30005][5];

StringBuilder sb = new StringBuilder();
for(int i =0 ; i<dp.length;i++){
	Arrays.fill(dp[i], -1);
}

	while(sc.ready()){
		int now = sc.nextInt();
		int Possible = solve(now,0);
		
		if(Possible==1)
		sb.append(String.format("There is only 1 way to produce %s cents change.\n", now));
	else
		sb.append(String.format("There are %s ways to produce %s cents change.\n", Possible,now));
	}
	System.out.println(sb.replace(sb.length()-1, sb.length(),"").toString());
	
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
	}}
}
