import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class UVA_11340_NewsPaper {
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner("in.txt");
	int T = sc.nextInt();
	StringBuilder sb = new StringBuilder();
	while(T-->0){
		int n = sc.nextInt();
		HashMap <Character,Integer>map = new HashMap<Character,Integer>();
		while(n-->0){
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			char s = st.nextToken().charAt(0);
			int value = Integer.parseInt(st.nextToken());
			map.put(s, value);
		}
		int m = sc.nextInt();
		double counter = 0 ;
		while(m-->0){
			char []arr = sc.nextLine().toCharArray();
			for(int i =0 ; i<arr.length;i++){
				if(map.containsKey(arr[i])){
					counter+=map.get(arr[i]);
				}
			}
		}
		sb.append(String.format("%.2f$\n", counter/100));
		}
	System.out.println(sb.replace(sb.length()-1,sb.length(),"").toString());
}

static class Scanner {
	StringTokenizer st;
	BufferedReader br;
	public Scanner(String s )throws Exception{
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
