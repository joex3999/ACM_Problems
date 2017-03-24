

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class UVA_10199_TouristGuide {
	
	static ArrayList<Integer>[] adjList;
	static int[] dfs_low, dfs_num, parent;
	static int V, counter, root, rootChildren;
	static boolean[] artPoints;
public class Letter implements Comparable{
	String s ;
public Letter(String g ){
	s = g ;
}

	@Override
	public int compareTo(Object arg0) {
	String s2 = ""+arg0;
		return s.compareTo(s2);
	}
	
}
	
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
				if(dfs_low[v] >= dfs_num[u])
					artPoints[u] = true;
				
				dfs_low[u] = Math.min(dfs_low[v], dfs_low[u]);
			}
			else
				if(parent[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
	}

	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb  = new StringBuilder();
int counter = 0 ;
	int n = 0;
	while((n=Integer.parseInt(br.readLine()))!=0){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		HashMap <Integer,String> map2 = new HashMap<Integer,String>();
		adjList = new ArrayList[n];
		
		
		for(int i =0 ; i<n;i++){
			adjList[i] = new ArrayList<Integer>();
			String line = br.readLine();
			map.put(line, i);
			map2.put(i, line);
		}
		V= n ;
		dfs_low = new int [V];
		dfs_num = new int[V];
		parent = new int [V];
		artPoints = new boolean [V];
	
		int r = Integer.parseInt(br.readLine());
		for(int i =0 ; i <r ; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String from1  = st.nextToken();
			String from2 = st.nextToken();
			int from11 = map.get(from1);
			int from22 = map.get(from2);
			adjList[from11].add(from22);
			adjList[from22].add(from11);
		}
		findArtPointsAndBridges();
		StringBuilder sb2 = new StringBuilder();
		int numberOfAll = 0 ;
		String format = String.format("City map #%s: ",++counter);
		sb.append(format);
		ArrayList<String> temp = new ArrayList<String>();
		for(int i =0 ; i<V ;i++){
			if(artPoints[i]){
			numberOfAll++;
			temp.add(map2.get(i));
				//sb2.append(map2.get(i)+"\n");
			}
		}
		Collections.sort(temp);
		for(int i =0 ; i<temp.size();i++){
			sb2.append(temp.get(i)+"\n");
		}
format = String.format("%s camera(s) found\n",numberOfAll);
sb.append(format);
sb.append(sb2+"\n");
	}
	sb.replace(sb.length()-1, sb.length(),"");
	System.out.println(sb.toString());
	System.out.println("\n");
}
}
