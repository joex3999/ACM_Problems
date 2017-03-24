import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_441B_ValeraAndFruits {
	public static class Pair implements Comparable {
		int x;
		int y;

		public Pair(int first, int second) {
			x = first;
			y = second;
		}

		@Override
		public int compareTo(Object o) {
			Pair other = (Pair) o;
			if (this.x > other.x)
				return 1;
			else if (this.x < other.x)
				return -1;
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		Pair[]arr = new Pair[n];
		int max = Integer.MIN_VALUE;
		for(int i=0 ; i < n ;i++){
			int a = sc.nextInt();
			Pair g = new Pair(a,sc.nextInt());
			arr[i]= g ;
			max = Math.max(max, a);
		}
		
		Arrays.sort(arr);
		int[]arr2 = new int[max+3];
		int[]arr3 = new int[max+3];
		for(int i =0 ;i<arr.length;i++){
			Pair now = arr[i];
			arr2[now.x]+=arr[i].y;
			arr3[now.x+1]+=arr[i].y;
			}
		
		int result =0 ; 
		for(int i =0 ; i<arr2.length;i++){
		
			
			int vall = v ;
			if(arr3[i]!=0){
				vall -=arr3[i];
			
				if(vall<0){
					vall=0;
					result+=v;
				}else{
					result+=arr3[i];
				}
			}
			if(arr2[i]!=0&&vall>0){
				if(arr2[i]>=vall){
					result+=vall;
					arr2[i]-=vall;
					arr3[i+1]-=vall;
				}else{
					result+=arr2[i];
				arr3[i+1]-=arr2[i];
				}
			}
		
		}

		System.out.println(result);
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
