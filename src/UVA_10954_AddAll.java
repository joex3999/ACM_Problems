

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class UVA_10954_AddAll {
public static void main(String[]args)throws Exception{
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	boolean first = true ;
	PriorityQueue<Integer> queue ;
	while((Integer.parseInt(br.readLine()))!=0){
		int total = 0 ; 
		queue = new PriorityQueue<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		while(queue.size()!=1){
			int cost = queue.poll()+queue.poll();
			total+=cost;
			queue.add(cost);
		}
	if(first){
		sb.append(total);
		first=false;
	}else
		sb.append("\n"+total);
	}
	
	System.out.println(sb.toString());
}
}
