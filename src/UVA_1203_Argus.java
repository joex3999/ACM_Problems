

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_1203_Argus {
	static public class Pair implements Comparable {
		int Qnum;
		int Period;
		final int constant ;

		public Pair(int x, int y) {
			Qnum = x;
			Period = y;
		constant = y ;
		}

		@Override
		public int compareTo(Object arg) {

			int P2 = ((Pair) arg).Period;
			int Q2 = ((Pair) arg).Qnum;
			if (Period > P2) {
				return 1;
			} else {
				if (Period < P2) {
					return -1;
				}
			}
			if(Period==P2){
	
				return Qnum>Q2?1:Qnum<Q2?-1:0;
			}
		return 0 ;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while (!(s = br.readLine()).equals("#")) {
			StringTokenizer st = new StringTokenizer(s);
			st.nextToken();
			Pair p = new Pair(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));

			queue.add(p);
		}
		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			Pair p = queue.poll();
			//Pair neww = new Pair(p.Qnum, p.Period + p.constant);
			p.Period = p.Period+p.constant;

			queue.offer(p);
			if (first) {
				first = false;
				sb.append(p.Qnum);
			} else {
				sb.append("\n" + p.Qnum);
			}
		}
System.out.println(sb.toString());
	}
}
