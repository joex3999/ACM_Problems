import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_BeforeAnExam {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int hours = sc.nextInt();
		int[] arr = new int[d];
		int[] min = new int[d];
		int[] max = new int[d];
		boolean can = true ;
		for(int i =0 ; i<d;i++){
			min[i] = sc.nextInt();
			max[i]= sc.nextInt();
		}
		for(int i =0 ; i<d;i++){
			arr[i]=min[i];
			hours-=min[i];
		}
		if(hours<0)
		{
			System.out.println("NO");
			return;
		}
		
		loop:for(int i=0;i<240;i++){
			for(int j = 0 ; j <d;j++){
				if(hours<=0)
					break loop ;
				if(arr[j]<max[j]){
				arr[j]++;
				hours--;}
			}
		}
		if(hours>0)
			System.out.println("NO");
		else
		{
			System.out.println("YES");
			System.out.print(arr[0]);
			for(int i =1 ; i<d;i++){
				System.out.print(" "+arr[i]);
			}
		}
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
