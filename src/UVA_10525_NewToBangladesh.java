

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// correct answer + fault in udebug but WA verdict so i submitted : https://saicheems.wordpress.com/2013/07/27/uva-10525-new-to-bangladesh/
public class UVA_10525_NewToBangladesh {
	static Pair[][] adjMatrix;
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
				for(int j = 0; j < V; j++){
						if(adjMatrix[i][j].sum > adjMatrix[i][k].sum + adjMatrix[k][j].sum)
					{	adjMatrix[i][j].time = adjMatrix[i][k].time + adjMatrix[k][j].time;
						adjMatrix[i][j].length = adjMatrix[i][k].length + adjMatrix[k][j].length;
						adjMatrix[i][j].sum = adjMatrix[i][k].sum+adjMatrix[k][j].sum;
						p[i][j] = p[k][j];
					}}
	}
	
	static void printPath(int i, int j)
	{
		if(i!=j) printPath(i,p[i][j]);
		System.out.print(j+" ");
	}
	static public class Pair{
		long time ;
		long length;
		long sum ;
		public Pair(int t , int l){
			time = t ;
			length = l;
			if(t==(int)Double.POSITIVE_INFINITY){
				
			sum = (int)Double.POSITIVE_INFINITY; }else{
			
				sum = t+l;
			}
		}
	}
public static void main(String[]args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int c = Integer.parseInt(br.readLine());
StringBuilder sb = new StringBuilder();
while(c-->0){
	br.readLine();
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	V= n ;
	adjMatrix = new Pair [n][n];
	Pair [] g = new Pair [n];
	int inf = (int) Double.POSITIVE_INFINITY;
	Pair f = new Pair(inf,inf);
	//Arrays.fill(g, f); // change this approach
	//Arrays.fill(adjMatrix, g);
	
for(int i =0 ; i<V;i++){
	for (int vv =0 ; vv<V;vv++){
		adjMatrix[i][vv] = new Pair((int)Double.POSITIVE_INFINITY,(int)Double.POSITIVE_INFINITY);
	}
	
}	


	for(int i =0 ; i<m;i++){
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		int cc = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
	
		adjMatrix[a][b] = new Pair(cc,d);
		adjMatrix[b][a]= new Pair(cc,d);

	}


	floyd();
	int p = Integer.parseInt(br.readLine());
	while(p-->0){
		 st =  new StringTokenizer(br.readLine());
	int source = Integer.parseInt(st.nextToken())-1;
	int dest = Integer.parseInt(st.nextToken())-1;
	
	Pair gg = adjMatrix[source][dest];
	String format ;
	if(gg.length==(int)Double.POSITIVE_INFINITY){
		format = "No Path.\n";
	}else{
		
	
 format = String.format("Distance and time to reach destination is %s & %s.\n",gg.length,gg.time);
	}sb.append(format);

	}
	sb.replace(sb.length()-1, sb.length(), "");
	sb.append("\n\n");
}
sb.replace(sb.length()-2, sb.length(), "");
System.out.println(sb.toString());
}
}	
