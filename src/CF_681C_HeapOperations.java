import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class CF_681C_HeapOperations {
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner(System.in);
	PriorityQueue<Long> que = new PriorityQueue<Long>();
	StringBuilder sb = new StringBuilder();
	int n = sc.nextInt();
	int count = 0 ;
	for(int i =0 ; i<n;i++){
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		String s = st.nextToken();
		if(s.equals("insert")){
		
		long number = Long.parseLong(st.nextToken());
			que.add(number);
			count++;
			sb.append(String.format("insert %s\n", number));
		}
		
		if(s.equals("removeMin")){
			if(!que.isEmpty()){
			que.remove();
			count++;
			sb.append(String.format("removeMin\n"));
		}else{
			
			count++;
			count++;
			sb.append(String.format("insert 1\n"));
			sb.append(String.format("removeMin\n"));
		}
			
		}
		
		if(s.equals("getMin")){
		
			long number = Long.parseLong(st.nextToken());
			boolean in = false ;
	if(que.isEmpty()){
		count++;
		sb.append(String.format("insert %s\n",number));
		que.add(number);
	}
			if(!que.isEmpty())
			while(que.peek()<number){
				in = true ;
				que.remove();
				count++;
				sb.append("removeMin\n");
				if(que.isEmpty())
					break;
			}
			if(in){
				count++;
				count++;
				sb.append(String.format("insert %s\n",number));
				sb.append(String.format("getMin %s\n",number));
				que.add(number);
			}else{
				count++;
				sb.append(String.format("getMin %s\n",number));
			}
		}
	}
	System.out.println(count);
	System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
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
