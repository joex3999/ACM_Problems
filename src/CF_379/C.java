package CF_379;

import java.io.*;
import java.util.*;

public class C {
	public static class Pair implements Comparable {
		 double slope, dest;
		 char S;

		public Pair(double p, double d, char c) {
			slope = p;
			dest = d;
			S = c;
		}

		@Override
		public int compareTo(Object arg) {
			Pair O = (Pair) arg;
			if (dest >O.dest)
				return 1;
			if (dest < O.dest)
				return -1;

			return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		ArrayList<Pair> listup = new ArrayList<Pair>();
		ArrayList<Pair> listdown = new ArrayList<Pair>();
		ArrayList<Pair> listleft = new ArrayList<Pair>();
		ArrayList<Pair> listright = new ArrayList<Pair>();
		ArrayList<Pair> listupperleft = new ArrayList<Pair>();
		ArrayList<Pair> listupperright = new ArrayList<Pair>();
		ArrayList<Pair> listlowerleft = new ArrayList<Pair>();
		ArrayList<Pair> listlowerright = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			double X = Double.parseDouble(st.nextToken());
			double Y = Double.parseDouble(st.nextToken());
			if (X == x && y > Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				Pair g = new Pair(slope, destination, c);
				listdown.add(g);
			}
			if (X == x && y < Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				Pair g = new Pair(slope, destination, c);
				listup.add(g);

			}
			if (X > x && y == Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				Pair g = new Pair(slope, destination, c);
				listright.add(g);
			}
			if (X < x && y == Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				Pair g = new Pair(slope, destination, c);
				listleft.add(g);
			}
			if (X > x && y > Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				Pair g = new Pair(slope, destination, c);
				listlowerright.add(g);
			}
			if (X < x && y < Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				
				Pair g = new Pair(slope, destination, c);
				listupperleft.add(g);
			}
			if (X < x && y > Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
			
				double slope = (Y - y) / (X - x);
				
				Pair g = new Pair(slope, destination, c);
				listlowerleft.add(g);
			}
			if (X > x && y < Y) {
				double destination = Math.sqrt(Math.pow(X - x, 2)
						+ Math.pow(Y - y, 2));
				double slope = (Y - y) / (X - x);
				Pair g = new Pair(slope, destination, c);
				listupperright.add(g);
			}
		}
		Collections.sort(listup);
		Collections.sort(listdown);
		Collections.sort(listleft);
		Collections.sort(listright);
		Collections.sort(listupperleft);
		Collections.sort(listupperright);
		Collections.sort(listlowerleft);
		Collections.sort(listlowerright);
		
		boolean done = false ;
		if (listup.size() > 0) {
			Pair g = listup.get(0);
			if (g.S == 'Q' || g.S == 'R') {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listdown.size() > 0) {
			Pair g = listdown.get(0);
			if (g.S == 'Q' || g.S == 'R') {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listleft.size() > 0) {
			Pair g = listleft.get(0);
			if (g.S == 'Q' || g.S == 'R') {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listright.size() > 0) {
			Pair g = listright.get(0);
			if (g.S == 'Q' || g.S == 'R') {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listupperleft.size() > 0) {
			Pair g = listupperleft.get(0);
			if ((g.S == 'Q' || g.S == 'B')&&(g.slope==1||g.slope==-1)) {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listupperright.size() > 0) {
			Pair g = listupperright.get(0);
			
	
			
			if ((g.S == 'Q' || g.S == 'B')&&(g.slope==1||g.slope==-1)) {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listlowerleft.size() > 0) {
			Pair g = listlowerleft.get(0);
			if ((g.S == 'Q' || g.S == 'B')&&(g.slope==1||g.slope==-1)) {
				System.out.println("YES");
				done = true ;
			}
		}
		if (listlowerright.size() > 0) {
			Pair g = listlowerright.get(0);
		
			if ((g.S == 'Q' || g.S == 'B')&&(g.slope==1||g.slope==-1)) {
				System.out.println("YES");
				done = true ;
			}
		}
	if(!done)
		System.out.println("NO");
	}
}
