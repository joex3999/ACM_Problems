

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_11709_TrustGroups {
	static ArrayList<Integer>[] adjList;
	static int V, counter, SCC, dfs_num[], dfs_low[];
	static boolean[] inSCC;
	static Stack<Integer> stack;
		
	
	static void tarjanSCC()	 	//O(V + E)
	{
		for(int i = 0; i < V; ++i)
			if(dfs_num[i] == 0)
				tarjanSCC(i);
	}
	
	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = ++counter;
		stack.push(u);
		
		
		for(int v: adjList[u])
		{
			if(dfs_num[v] == 0)
				tarjanSCC(v);
			if(!inSCC[v])
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);	
		}
		if(dfs_num[u] == dfs_low[u])
		{
		
			//SCC found
			while(true)
			{
				int v = stack.pop();
				inSCC[v] = true;
				if(v == u)
					break;
			}
			SCC++;
		
		}
		
		
	}
	
	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
while(true){
	StringTokenizer st = new StringTokenizer (br.readLine());
	int p = Integer.parseInt(st.nextToken());
	int t = Integer.parseInt(st.nextToken());
	
	if(p==t&& t==0){//phantom test case xD
break;}
	adjList = new ArrayList[p];
	inSCC = new boolean [p];
	stack  = new Stack<Integer>();
	dfs_low = new int [p];
	dfs_num = new int [p];
	V = p ;
	SCC = 0 ;
	Arrays.fill(dfs_num, 0);
	counter = 0;
	for(int i =0 ; i <p;i++){
		adjList[i] = new ArrayList<Integer>();
	}
	HashMap<String,Integer> map = new HashMap(p);
	for(int i =0 ; i<p;i++){
		map.put(br.readLine(),i);
	
	}
	
	for(int i =0 ; i <t;i++){
		String f = br.readLine();
		String tt = br.readLine();
	int from = map.get(f);
	int to = map.get(tt);
	adjList[from].add(from);

	adjList[from].add(to);
	}
	
	tarjanSCC();
int result = SCC;

sb.append(result+"\n");
System.out.println(result);	
	
}
sb.replace(sb.length()-1,sb.length(), "");
}
}
