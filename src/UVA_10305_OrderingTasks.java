

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_10305_OrderingTasks {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	static int V;
	static Stack<Integer> stack = new Stack<Integer>();
	
	static void dfs(int u)				//O(V + E) adjList, O(V^2) adjMat	
	{
		visited[u] = true;

		for(int v: adjList[u])
			if(!visited[v])
				dfs(v);


	}
	
	static void toposortDFS(int u)	//don't forget preTraversal	
	{
		visited[u] = true;

		for(int v: adjList[u])
			if(!visited[v])			//if v is explored -> failure
				toposortDFS(v);
		stack.push(u);
	}
	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
	while(true){
	StringTokenizer st = new StringTokenizer(br.readLine());
 V = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	if(V==m&m==0){
		break;
	}
	adjList = new ArrayList[V];
	visited = new boolean [V];
	for(int i =0 ; i <V;i++){
		adjList[i]=new ArrayList<Integer>();
	}
	for(int i =0 ; i < m ;i++){
		st = new StringTokenizer(br.readLine());
		int from =Integer.parseInt(st.nextToken())-1;
		int to = Integer.parseInt(st.nextToken())-1;
		adjList[from].add(to);
	}
	for(int i =0 ; i<V;i++){
		if(!visited[i])
		toposortDFS(i);
	}
	sb.append(stack.pop()+1);
	while(!stack.isEmpty()){
	sb.append(" "+(stack.pop()+1));
	}
sb.append("\n");
	}
sb.replace(sb.length()-1, sb.length(), "");
System.out.println(sb.toString());
}
}
