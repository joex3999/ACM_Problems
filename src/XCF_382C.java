
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class XCF_382C {
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	

	BigInteger x = new BigInteger(sc.nextLine());


double g =logBigInteger(x)/logBigInteger(new BigInteger(""+2));
int XX = (int)g;
if(XX==g)
	System.out.println((int)g);
else
	System.out.println(XX+1);
}
private static final double LOG2 = Math.log(2.0);

/**
 * Computes the natural logarithm of a BigInteger. Works for really big
 * integers (practically unlimited)
 * 
 * @param val Argument, positive integer
 * @return Natural logarithm, as in <tt>Math.log()</tt>
 */
public static double logBigInteger(BigInteger val) {
    int blex = val.bitLength() - 1022; // any value in 60..1023 is ok
    if (blex > 0)
        val = val.shiftRight(blex);
    double res = Math.log(val.doubleValue());
    return blex > 0 ? res + blex * LOG2 : res;
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
