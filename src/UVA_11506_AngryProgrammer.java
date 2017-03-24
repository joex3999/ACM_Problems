

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// submitted : https://github.com/careermasud/UVA/blob/master/Introduction/src/prevcontest/Acm11506.java
// correct answer 
public class UVA_11506_AngryProgrammer {

	static final int INF = (int)1e9;
	static int V, s, t;						//input
	static ArrayList<Integer>[] adjList;	//input
	static int[][] res;						//input
	static int[] p;
	
	static int edmondsKarp()
	{
		int mf = 0;
		while(true)
		{
			Queue<Integer> q = new LinkedList<Integer>();
			p = new int[V];
			Arrays.fill(p, -1);
			p[s] = s;
			q.add(s);
			while(!q.isEmpty())
			{
				
				int u = q.remove();
				
				if(u == t)
					break;
				for(int v: adjList[u])
				
					if(res[u][v] > 0 && p[v] == -1) // visited and parent in the same data structure -j
					{
					
						
						p[v] = u;
						q.add(v);
					}
			
		}
		
			if(p[t] == -1)
				break;

			mf += augment(t, INF);
			
		}
		
	
		
		return mf;
	}
	
	static int augment(int v, int flow)
	{
	
		if(v == s)
			return flow;
		flow =  augment(p[v], Math.min(res[p[v]][v],flow));
	
		res[p[v]][v] -= flow; // decrease capacity of forward edge -j
		res[v][p[v]] += flow; // increase capacity of backward edge -j
		/*
		  By increasing the capacity of a backward edge (j → i), Ford Fulkerson’s method allows
future iteration (flow) to cancel (part of) the capacity used by a forward edge (i → j) that
was incorrectly used by some earlier flow(s) -j :- CP 
		 */
		return flow;
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	new StringBuilder();
	while(true){
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		V = m*2;
	
		int w = Integer.parseInt(st.nextToken());
		if(m==w&&w==0)break;
		adjList = new ArrayList[V];
		res = new int [V][V];
		for(int i =0 ; i<V;i++){
			adjList[i]= new ArrayList<Integer>();
		}
		adjList[0].add(1);
		adjList[1].add(0);
		adjList[V-1].add(V-2);
		adjList[V-2].add(V-1);
		res[0][1]= (int ) Double.POSITIVE_INFINITY;
		res[1][0]= (int ) Double.POSITIVE_INFINITY;
		res[V-1][V-2]= (int ) Double.POSITIVE_INFINITY;
		res[V-2][V-1]= (int ) Double.POSITIVE_INFINITY;
		HashMap<Integer,Integer> map  = new HashMap<Integer,Integer>();
		for(int i =1 ; i<m-1;i++){
			st = new StringTokenizer(br.readLine());
			int ii = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
		 map.put(ii, c);

		 res[ii*2][ii*2+1] = c ;
		 res[ii*2+1][ii*2]=c;
		 adjList[ii*2].add(ii*2+1);
		 adjList[ii*2+1].add(ii*2);
		}
		
		for(int i =0 ;i<w;i++){
			st = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			// do stuff 
	
			res[j*2+1][k*2]= d ;
			res[k*2][j*2+1]=d;
			adjList[j*2+1].add(k*2);
			adjList[k*2].add(j*2+1);
			
		}
		s=0;
		
		t=V-1;
	int max=	edmondsKarp();
	// max flow is not working
	System.out.println(max);
	// after max flow we dfs one more time to see the minimum cut .
	}
}
}
