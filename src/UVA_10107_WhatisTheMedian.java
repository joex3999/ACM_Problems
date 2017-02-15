import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class UVA_10107_WhatisTheMedian {
public static void main(String[] args) throws Exception {
	Scanner sc = new Scanner("in.txt");
	ArrayList <Integer>arr = new ArrayList<Integer>();
	StringBuilder sb = new StringBuilder();
	while(sc.ready()){
		
		arr.add(sc.nextInt());
		Collections.sort(arr);
		if(arr.size()%2==0){
			int value = arr.get((arr.size()-1)/2) + arr.get(((arr.size()-1)/2+1));
			 value/=2;
			 sb.append(value+"\n");
		}else{
			
			sb.append(arr.get((arr.size()-1)/2)+"\n");
		}
		
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
		return br.ready();	}

}
}
