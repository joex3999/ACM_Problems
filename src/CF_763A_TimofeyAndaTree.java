import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF_763A_TimofeyAndaTree {
	public static class Pair {
		int x;
		int z;

		public Pair(int a, int b) {
			x = a;
			 z = b;

		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] colors = new int[n];
		ArrayList<Pair> arr = new ArrayList<Pair>();
		int differentP = 0;
		int[] vertex = new int[n];
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
		
			arr.add(new Pair(a, b));
		}

		for (int i = 0; i < n; i++) {
			colors[i] = sc.nextInt();

		}

		for (int i = 0; i < arr.size(); i++) {
			Pair g = arr.get(i);
			int left = g.x; int right = g.z;

			if(colors[left]!=colors[right]){
				vertex[left]++;
				vertex[right]++;
				differentP++;
			}
		}
	
		for(int i=0 ; i<n;i++){
			if(vertex[i]==differentP){
				System.out.println("YES");
				System.out.println(i+1);
				return;
			}
		}
System.out.println("NO");
return;
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
