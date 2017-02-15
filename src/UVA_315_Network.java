

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_315_Network {

	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter, root, rootChildren;
	static boolean[] artPoints;
	static boolean [] visited;
	static int result ;

	
	static void findArtPointsAndBridges()	//O(V + E)
	{


		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
			{
				root = i;
				rootChildren = 0;
				dfs(i);
				if(rootChildren <= 1)		//special case
					artPoints[i] = false;
			}
	}
	
	static void dfs(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		for(int v: adjList[u])
			if(dfs_num[v] == 0)
			{
				parent[v] = u;
				if(u == root)
					++rootChildren;
				dfs(v);
				if(dfs_low[v] >= dfs_num[u]){
					artPoints[u] = true;
				}
				//if(dfs_low[v] > dfs_num[u])
					//System.out.printf("Bridge between %d %d\n", u, v);
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}

public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb =new StringBuilder();

while(true){
	int n = Integer.parseInt(br.readLine());
	if(n==0){
		break;
	}
	V = n ;
	adjList= new ArrayList[V];
	visited = new boolean [V];
	dfs_low = new int [V];
	dfs_num= new int [V];
	parent = new int [V];
   artPoints = new boolean [V];
 result = 0 ;
	String s = null ;
	for(int i =0 ; i<V;i++){
		adjList[i] = new ArrayList<Integer>();
	}
	while(!(s=br.readLine()).equals("0")){
		StringTokenizer st = new StringTokenizer(s);
	int from = Integer.parseInt(st.nextToken())-1;
	while(st.hasMoreTokens()){
		int to = Integer.parseInt(st.nextToken())-1;
		adjList[from].add(to);
		adjList[to].add(from);
	}
	}
findArtPointsAndBridges();
for(int i =0 ; i<V;i++){
	if(artPoints[i]){
		result++;
	}
}
sb.append(result+"\n");
}
sb.replace(sb.length()-1, sb.length(),"");
System.out.println(sb.toString());
}
}
