import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10344_23OutOf5 {
	static int[] nums = new int[6];
	static  boolean flag = false ;
	static boolean[] visited = new boolean[6];
	public static void dfs(int current ,int sum){
		if(sum==23&&current==5)
		{ 
			System.out.println("ahoi");
			flag = true ;
			return ;
		}else{
			for(int i =0 ; i <5;i++){
				if(!visited[i]){
					visited[i]=true;
					dfs(current+1,sum+nums[i]);
					dfs(current+1,sum*nums[i]);
					dfs(current+1,sum-nums[i]);
					visited[i]= false ;
				}
			}
		}
	}

	public static  void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0)
				break;
			
			flag = false ;
			for(int i =0 ; i<5;i++){
				visited[i]= true ;
				dfs(1,nums[i]);
				visited[i] = false;
					
			}
			if(flag)
				sb.append("Possible\n");
			else
				sb.append("Impossible\n");
			
		}
		
		System.out.println(sb.toString());
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
