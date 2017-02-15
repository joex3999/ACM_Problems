import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// Wrong
public class CF_352A_JeffsAndDigits {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();

		}

		long zero = 0;
		long fives = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				zero++;
			} else {
				fives++;
			}
		}

		if (zero == 0) {
			System.out.println("-1");
			return;
		}
		if (fives < 9) {
			System.out.println(0);
			return;
		}
		BigInteger number =new BigInteger("5");
		BigInteger answer =new BigInteger("-1");
		for(int i=0 ; i<fives;i++){
			number =number.multiply(new BigInteger("10"));
			number =number.add(new BigInteger("5"));
		
			if(number.mod(new BigInteger("9")).equals(new BigInteger("0"))){
			
				answer = number;
			}
		}
	
		for(int i=0 ;i<zero;i++){
			answer =answer.multiply(new BigInteger("10"));
		}
		System.out.println(answer);
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
