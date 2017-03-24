import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Problem_Randomizer {
	public static  class Pair implements Comparable {
		 String name ;
		 int prob;
		public Pair(String s){
			name = s  ;
			prob = (int)(Math.random()*100+1);
		}
		@Override
		public int compareTo(Object arg0) {
			Pair o = (Pair)arg0;
			if(this.prob>o.prob)
				return -1 ;
			if(o.prob>this.prob)
				return 1 ;
			return 0;
		}
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("input.txt");
		while(!sc.nextLine().equals("All problems  "))
			sc.nextLine();
	
		
		ArrayList<Pair> arr= new ArrayList<Pair>();
		while(true){
			String s = sc.nextLine();
			if(s.charAt(0)=='←'||s.charAt(0)=='?')
				break;
			String n = "";
			for(int i =0 ; i<10 ; i++){
				n+=s.charAt(i);
				if(!Character.isDigit(s.charAt(i)))
					break;
						}
	//	System.out.println(n);
			arr.add(new Pair(n));
		}

		Collections.sort(arr);
		System.out.println("This is a program created to give you a random problem number !. ");
		System.out.println("Created By Youssef A.E.M");
		System.out.println("Please Fill an \"input.txt\" file in the workspace before procceding ");
		System.out.println("Please Enter the number of problems you want: ");
	 sc = new Scanner(System.in);
		int input = sc.nextInt();
		for(int i=0 ;i<input&& i <arr.size();i++){
			System.out.println(arr.get(i).name+" "+ arr.get(i).prob);
		}
		
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
