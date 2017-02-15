

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class UVA_10113_ExchangeRates {
	static int[][] adjMatrix;
	static int[][] p;
	static int V;
	static int s ;

	static void floyd() {
		// adjMatrix contains: directed edges, zero for i=j, INF (1B) otherwise

		p = new int[V][V]; // to find the parent on the shortest path
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				p[i][j] = i;

		for (int k = 0; k < V; k++)
			for (int i = 0; i < V; i++)
				for (int j = 0; j < V; j++)
					if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						p[i][j] = p[k][j];
					}
	}

	static void printPath(int i, int j) {
		if (i != j)
			printPath(i, p[i][j]);
		System.out.print(j + " ");
	}

	static public class Pair {
		String a;
		String b;

		public Pair(String g, String f) {
			a = g;
			b = f;
		}
	}

	public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
StringBuilder sb = new StringBuilder();
ArrayList<Pair> storage = new ArrayList<Pair>();
int tillNow  = 0 ;
HashSet<String> set = new HashSet<String>();
HashMap<Integer,String> map1 = new HashMap<Integer,String>();
HashMap<String,Integer>map2 = new HashMap<String,Integer>();
adjMatrix = new int [60][60];
V=60;
	while(true){
	StringTokenizer st = new StringTokenizer(br.readLine());
String begin = st.nextToken();
if(begin.equals(".")){
	break;
}
	if(begin.equals("!")){
		int value1 = Integer.parseInt(st.nextToken());
		String from = st.nextToken();
		st.nextToken();
		int value2 = Integer.parseInt(st.nextToken());
		String to = st.nextToken();
		if(!set.contains(from)){
			map1.put(tillNow,from );
			map2.put(from, tillNow++);
			set.add(from);
		}
		
		if(!set.contains(to)){
			map1.put(tillNow, to);
			map2.put(to, tillNow++);
			set.add(to);
			}
		int f = map2.get(from);
		int t = map2.get(to);
		adjMatrix[f][t] = value2;
		adjMatrix[t][f] = value1;
	}else{
		String s = st.nextToken();
		st.nextToken();
		String s2 = st.nextToken();
	Pair neww = new Pair(s,s2);
	storage.add(neww);
	}
	}
for(int i =0 ;i<V;i++){
	for(int j =0 ;j<V;j++){
		if(j==i){
			adjMatrix[i][j]=0;
		}else{
			if(adjMatrix[i][j]==0){
				adjMatrix[i][j]=1000000000;
			}
		}
		
	}
}
	

floyd();
for(int i =0 ; i<storage.size();i++){
	Pair now = storage.get(i);
	String f = now.a;
	String t = now.b;
	int from = map2.get(f);
	int to = map2.get(t);
	System.out.print(adjMatrix[from][to]);
	System.out.println(adjMatrix[to][from]);
}
}
}
