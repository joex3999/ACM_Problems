

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_11060_Beverages {
	static ArrayList<Integer> sortedArray;
	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited, adjMat[];
	static int V;
	static boolean first ;

	
	static void toposort()
	{
		int[] p = new int[V];
		sortedArray = new ArrayList<Integer>(V);
		for(int i = 0; i < V; ++i)
			for(int v: adjList[i])
				++p[v];
		Queue<Integer> roots = new LinkedList<Integer>();	//PriorityQueue??

		for(int i = 0; i < V; ++i)
			if(p[i] == 0)
				roots.add(i);
		while(!roots.isEmpty())
		{
			int u = roots.remove();
			sortedArray.add(u);
			for(int v: adjList[u])
				if(--p[v] == 0)
					roots.add(v);
		}
		
		//if p contains non-zero values -> failure
	}
	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = null ;
	StringBuilder sb = new StringBuilder();
	int casee = 0 ;
	first = true ;
	while((s=br.readLine())!=null&&!s.equals("joe")){
		if(first){
			first = false ;
		}else{
			s=br.readLine();
		}
		StringTokenizer temp = new StringTokenizer(s);
		int n = Integer.parseInt(temp.nextToken());

		V=n;
		adjList = new ArrayList[V];
		
		HashMap<String,Integer>map = new HashMap<String,Integer>();
		HashMap<Integer,String>map2 = new HashMap<Integer,String>();
		for(int i=0 ; i<n;i++){
		adjList[i] = new ArrayList<Integer>();
			String line = br.readLine();
			map.put(line, i);
			map2.put(i, line);
		}
		int m = Integer.parseInt(br.readLine());
		
		for(int i =0 ; i<m;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = map.get(st.nextToken());
			int to = map.get(st.nextToken());
			adjList[from].add(to);
			//adjList[to].add(from);
		}
		toposort();
sb.append(String.format("Case #%s: Dilbert should drink beverages in this order:", ++casee));

		for(int i =0 ; i<sortedArray.size();i++){
			sb.append(" "+map2.get(sortedArray.get(i)));
		}
		sb.append(".\n\n");
		
	}
	sb.replace(sb.length()-1, sb.length(), "");
	System.out.println(sb.toString());
}
}
