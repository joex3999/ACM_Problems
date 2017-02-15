import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CF_276C_LittleGirlAndMaximumSum {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int q = sc.nextInt();
		int []arr = new int [n];
		int[]temp = new int [n+1];
		long []weights = new long [n];
	
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i<n;i++)
			arr[i]= sc.nextInt();
		for(int i =0 ; i <q;i++){
			int left = sc.nextInt();
			int right = sc.nextInt();
			temp[left-1]++;
			temp[right]--;
		}
	long sum = 0 ;
		for(int i =0 ; i<n;i++){
			sum+=temp[i];
			weights[i]=sum;
		
		}
	Arrays.sort(weights);
	Arrays.sort(arr);
	long answer = 0 ;
	for(int i =0 ; i<n;i++)
	answer+=weights[i]*arr[i];
	sb.append(answer);
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
