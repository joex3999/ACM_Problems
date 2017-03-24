import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_754B {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[4][4];
		for (int i = 0; i < 4; i++) {
			char[] sub = sc.nextLine().toCharArray();
			for (int j = 0; j < 4; j++) {
				arr[i][j] = sub[j];
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(arr[i][j]=='.'){
					arr[i][j]='x';
					if(solve(arr)){
						System.out.println("YES");
						return;
					}
					arr[i][j]='.';
				}

			}
		}
		
		System.out.println("NO");

	}
public  static boolean solve(char[][]arr){
for(int i =0 ; i<arr.length;i++){
	for(int j = 0 ; j<arr.length;j++){
		if(valid(j+1)&&valid(j+2)&&arr[i][j]=='x'&&arr[i][j+1]=='x'&&arr[i][j+2]=='x')
		return true ;
			if(valid(i+1)&&valid(i+2)&&valid(j+1)&&valid(j+2)&&arr[i][j]=='x'&&arr[i+1][j+1]=='x'&&arr[i+2][j+2]=='x')
				return true ;
				if(valid(i+1)&&valid(i+2)&&arr[i][j]=='x'&&arr[i+1][j]=='x'&&arr[i+2][j]=='x')
					return true ;
				if(valid(i-1)&&valid(i-2)&&valid(j+1)&&valid(j+2)&&arr[i][j]=='x'&&arr[i-1][j+1]=='x'&&arr[i-2][j+2]=='x')
					return true ;
	}
}
return false ;
}

public static boolean valid(int i){
	return i>=0&&i<=3;
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
