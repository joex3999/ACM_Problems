

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;





public class UVA_4524_InterstarTransport {

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
		System.out.print(((char)(j+65))+" ");
	}


	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int s =Integer.parseInt(st.nextToken());
	int p = Integer.parseInt(st.nextToken());
	V = s ;
	adjMatrix = new int [V][V];
	for(int i =0 ;i<V;i++){
		for (int j =0 ;j<V;j++){
			adjMatrix[i][j] = (int)1000000000;
		}
	}
	for(int i=0 ; i<p ; i++){
	
		st = new StringTokenizer(br.readLine());
		int first = st.nextToken().charAt(0)-65;
		int second = st.nextToken().charAt(0)-65;
	int cost = Integer.parseInt(st.nextToken());
	adjMatrix[first][second]= cost ;
	adjMatrix[second][first]= cost ;
	}
	floyd();
	int bla = Integer.parseInt(br.readLine());
	for(int i =0 ;i<bla;i++){
		st = new StringTokenizer(br.readLine());
		int from = st.nextToken().charAt(0)-65;
		int to = st.nextToken().charAt(0)-65;
		printPath(from,to);
		System.out.println();
	}
}
}
