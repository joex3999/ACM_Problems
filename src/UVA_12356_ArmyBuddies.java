import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_12356_ArmyBuddies {
	public static class Tri {
		int value;
		int Left;
		int Right;

		public Tri(int v, int left, int right) {
			value = v;
			Left = left;
			Right = right;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			int S = sc.nextInt();
			int N = sc.nextInt();
			Tri[] arr = new Tri[S];
			if (S == N && N == 0)
				break;
			for (int i = 0; i < S; i++) {
				if(S==1){
					arr[i]= new Tri(i,-1,-1);
			continue;
				}if (i == 0) {
					arr[i] = new Tri(i, -1, i + 1);
					continue;
				}
				if (i == S - 1) {
					arr[i] = new Tri(i, i - 1, -1);
					continue;
				}
				arr[i] = new Tri(i, i - 1, i + 1);
			}

			for (int i = 0; i < N; i++) {
				
				int first = sc.nextInt()-1;
				int second = sc.nextInt()-1;
				//System.out.println(i+" "+arr[first].Left +"  "+arr[second].Right);
				if(arr[second].Right<S)
				{
					if(arr[second].Right!=-1){
					Tri t = arr[arr[second].Right];
					t.Left = arr[first].Left;}
				}
				if(arr[first].Left>=0){
					
					Tri t =arr[arr[first].Left];
					t.Right = arr[second].Right;
				}
				String left = arr[first].Left==-1?"*":arr[first].Left+1+"";
				String right = arr[second].Right==-1?"*":arr[second].Right+1+"";
				sb.append(left+" "+right+"\n");
			}
			sb.append("-\n");
		}
		System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
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
