


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class UVA_11995_ICanGuessTheDataStructure {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		String line;
		Queue<Integer> Q;
		Stack<Integer> S;
		PriorityQueue<Integer> PQ;
		boolean isQueue;
		boolean isStack;
		boolean isPQueue;
		
		while ((line = in.readLine()) != null) {
			int N = Integer.parseInt(line);
			Q = new LinkedList<Integer>();
			S = new Stack<Integer>();
			PQ = new PriorityQueue<Integer>();
			
			isQueue = true;
			isStack = true;
			isPQueue = true;
			
			while (N-- > 0) {
				String[] parts = in.readLine().split("[ ]+");
				int command = Integer.parseInt(parts[0].trim());
				int value = Integer.parseInt(parts[1].trim());
				
				if (command == 1) {
					if (isQueue)
						Q.offer(value);
					if (isStack)
						S.push(value);
					if (isPQueue)
						PQ.offer(-value);
				} else {
					if (isQueue && (Q.isEmpty() || Q.poll() != value))
						isQueue = false;
					if (isStack && (S.isEmpty() || S.pop() != value)) 
						isStack = false;
					if (isPQueue && (PQ.isEmpty() || PQ.poll() != -value))
						isPQueue = false;
				}
			}
			if (isQueue && !isStack && !isPQueue)
				sb.append("queue\n");
			else if (!isQueue && isStack && !isPQueue)
				sb.append("stack\n");
			else if (!isQueue && !isStack && isPQueue)
				sb.append("priority queue\n");
			else if (!isQueue && !isStack && !isPQueue)
				sb.append("impossible\n");
			else 
				sb.append("not sure\n");
		}
		System.out.print(sb.toString());
		
		in.close();
		System.exit(0);
	}
}