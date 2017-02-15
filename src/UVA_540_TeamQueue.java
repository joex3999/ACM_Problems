

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// used to give a presentation error ... just inserted an extra space and bam .. no pres error .
// proud of this solution

public class UVA_540_TeamQueue {
	static Queue<Integer>[] listOfQueues ;
	static HashMap<Integer,Integer> map ;
	static StringBuilder listt ;
	static Queue<Integer> position;

	
	static void enqueue(int num){
		int key = map.get(num);
		if(listOfQueues[key].isEmpty()){
			position.add(key);
		}
		
		listOfQueues[key].add(num);
	}
	
	static void dequeue(){
	int key = position.peek();
	int holder =listOfQueues[key].poll();
	if(listOfQueues[key].isEmpty()){
		position.poll();
	}
	listt.append("\n"+holder);
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int s = 0 ;
	int casee = 1;
	boolean first = true ;
	StringBuilder sb = new StringBuilder();
			while((s=Integer.parseInt(br.readLine()))!=0){
		listt = new StringBuilder();
		position = new LinkedList<Integer>();
	
int t = s;
listOfQueues = new Queue[t];
map = new HashMap<Integer,Integer>();
for(int i =0 ; i<t;i++){
	StringTokenizer st = new StringTokenizer(br.readLine());
	listOfQueues[i] = new LinkedList<Integer>();
	int useless = Integer.parseInt(st.nextToken());
while(st.hasMoreTokens()){
	map.put(Integer.parseInt(st.nextToken()), i);
}

}

String ss = null ;
while(!(ss=br.readLine()).equals("STOP")){
	StringTokenizer st = new StringTokenizer(ss);
	switch(st.nextToken()){
	case "ENQUEUE": enqueue(Integer.parseInt(st.nextToken()));break ;
	case "DEQUEUE": dequeue(); break; 
	}
}
String format ;
if(first){
	first = false ;
	 format = String.format("Scenario #%s", casee++);
		
	
}else {
	format = String.format("\n\nScenario #%s", casee++);
}

sb.append(format);
sb.append(listt);


}
			sb.append("\n");
			System.out.println(sb.toString());
			
}}
