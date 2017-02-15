

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CF_115A_Party {
	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited, adjMat[];
	static int V;
	static boolean first = true ;
	static Stack temp ;
	static int depth =-1;
	static int num=-1 ; 
	static void dfs(int u, int n)				//O(V + E) adjList, O(V^2) adjMat	
	{
		visited[u] = true;

		//for adjacency list

temp.push(u);
		for(int v: adjList[u])
			if(!visited[v])
			dfs(v,  n+1);

if(depth<n){
	depth = n ;
	num = u ;
}
		
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	adjList = new ArrayList[n];
	V=n;
	temp = new Stack();
visited = new boolean [V];
Arrays.fill(visited, false);
	for(int i =0 ; i<n;i++){
		adjList[i]= new ArrayList<Integer>();
		int b = Integer.parseInt(br.readLine());
		if(b!=-1){
			adjList[b-1].add(i);
		}
	}
	int max = 0 ;
	for(int i =0 ; i<V;i++){
		if(!adjList[i].isEmpty()){
depth = 0 ;
			dfs(i,1);
			max = Math.max(max,depth); 
		
		}
	}
System.out.println(max);
}
}
