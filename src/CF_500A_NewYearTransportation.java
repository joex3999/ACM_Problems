

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF_500A_NewYearTransportation {

	static final int VISITED = 2, EXPLORED = 1, UNVISITED = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited, adjMat[];
	static int V;
static boolean result ;
	
	static void dfs(int u,int t )				//O(V + E) adjList, O(V^2) adjMat	
	{
		visited[u] = true;

		if(u ==t){
			result = true ;
			return;
		}
		//for adjacency list

		for(int v: adjList[u])
			if(!visited[v])
				dfs(v,t);


	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	V = n+1 ;
	visited = new boolean [V];
	int t = Integer.parseInt(st.nextToken());
	adjList = new ArrayList[V];
	for(int i= 0 ; i<V;i++){
		adjList[i] = new ArrayList<Integer>();
	}
	st = new StringTokenizer(br.readLine());
	for(int i=1 ;st.hasMoreTokens();i++){
		int num = Integer.parseInt(st.nextToken());
		adjList[i].add(i+num);
		
	}
	dfs(1,t);
if(result)
	System.out.println("YES");
else
	System.out.println("NO");
}
}
