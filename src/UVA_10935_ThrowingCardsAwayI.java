

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class UVA_10935_ThrowingCardsAwayI {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			StringBuilder dc = new StringBuilder();
			StringBuilder rm = new StringBuilder();
			dc.append("Discarded cards:");
			rm.append("Remaining card: ");
			boolean first2 = true;
			Deque<Integer> total = new ArrayDeque<Integer>();
			int answer = 0;
			for (int i = 1; i <= n; i++) {
				total.addLast(i);
			}
			int size = total.size();

			while (!total.isEmpty()) {
				answer = total.removeFirst();

				if (total.isEmpty())
					break;

				int temp = total.removeFirst();
				total.offerLast(temp);
				if (first2) {
					dc.append(" "+answer);
					first2 = false;
				} else {
					dc.append(", " + answer);
				}
			}

			rm.append(answer);
if(first){sb.append(dc.toString()); first = false; }
else sb.append("\n"+dc.toString());
sb.append("\n"+rm.toString());
		}
		
System.out.println(sb.toString());		

	}
}