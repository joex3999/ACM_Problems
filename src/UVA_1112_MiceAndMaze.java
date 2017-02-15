

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_1112_MiceAndMaze {
	static int[][] adjMatrix;
	static int[][] p;
	static int V;
	
	static void floyd()
	{
		//adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise
		
		p = new int[V][V];		//to find the parent on the shortest path
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				p[i][j] = i;
		
		for(int k = 0; k < V; k++)
			for(int i = 0; i < V; i++)
				for(int j = 0; j < V; j++)
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
					{
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						p[i][j] = p[k][j];
					}
	}
	
	static void printPath(int i, int j)
	{
		if(i!=j) printPath(i,p[i][j]);
		System.out.print(j+" ");
	}
	public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int C  = Integer.parseInt(br.readLine());
	while(C-->0){
		br.readLine();
		int N = Integer.parseInt(br.readLine());
		V=N ;
		int E = Integer.parseInt(br.readLine())-1;
		int T = Integer.parseInt(br.readLine());
		adjMatrix = new int [V][V];
		for(int i =0 ; i<V;i++){
			for(int j =0 ;j<V;j++){
				adjMatrix[i][j] = 100000000;
			}
		}
		int M = Integer.parseInt(br.readLine());
		for(int i =0 ; i <M;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
int a = Integer.parseInt(st.nextToken())-1;
int b = Integer.parseInt(st.nextToken())-1;
int time = Integer.parseInt(st.nextToken());
adjMatrix[a][b] = time ;
		}
		floyd();
		int answer =1;
		for(int i =0 ; i<V;i++){
		if(i==E)
			continue;
				if(adjMatrix[i][E]<=T){
					answer++;
				}
			
		}
		
		sb.append(answer+"\n\n");
	}
	sb.replace(sb.length()-2, sb.length(), "");
	System.out.println(sb.toString());
}
}
