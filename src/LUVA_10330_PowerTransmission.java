

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// was in a hurry submitted another sol  : " https://github.com/lamphanviet/competitive-programming/blob/master/uva-online-judge/accepted-solutions/10330%20-%20Power%20Transmission.cpp" 
public class LUVA_10330_PowerTransmission {

	static final int INF = (int)1e9;
	static int V, s=0, t;						//input
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
	String sa = null ;
	while((sa=br.readLine())!=null){
		int N = Integer.parseInt(sa);
		V=N*2+2;
		res = new int [V][V];
		adjList = new ArrayList[V];
		for(int i =0 ;i<V;i++){
			adjList[i]= new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=N;i++){
			int from = i*2-1;
			int to = i*2;
			int cost = Integer.parseInt(st.nextToken());
			adjList[from].add(to);
			adjList[to].add(from);
			res[from][to] = cost ;
			res [to][from]=cost;
		}
		int W = Integer.parseInt(br.readLine());
		for(int i=0 ; i<W;i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int actualFrom = from*2;
			int actualTo = to*2-1;
			adjList[actualFrom].add(actualTo);
			adjList[actualTo].add(actualFrom);
			int cost = Integer.parseInt(st.nextToken());
			res[actualTo][actualFrom] = cost ;
			res[actualFrom][actualTo]= cost ;
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<B;i++){
			int now = Integer.parseInt(st.nextToken());
			adjList[0].add(now*2-1);
			adjList[now*2-1].add(0);
			res[0][now*2-1]=INF;
			res[now*2-1][0]=INF;
		}
		for(int i=0 ;i<D;i++){
			int now = Integer.parseInt(st.nextToken());
			int actualNow = now*2;
			adjList[actualNow].add(V-1);
			adjList[V-1].add(actualNow);
			res[V-1][actualNow]= INF;
			res[actualNow][V-1]=INF;
			}
	
		s=0;
	t=V-1;
		int maxFlow = edmondsKarp();
	System.out.println(maxFlow);
	}
}
}
