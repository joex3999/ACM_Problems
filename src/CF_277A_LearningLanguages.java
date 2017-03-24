

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_277A_LearningLanguages {

	public static  class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;
		
		public UnionFind(int N) 
		{
			 p = new int[N];
			 rank = new int[N];
			 setSize = new int[N];
			 numSets = N;
			 for (int i = 0; i < N; i++) {  p[i] = i; setSize[i] = 1; }
		}
		
		public int findSet(int i) 
		{ 
			if (p[i] == i) return i;
			else return p[i] = findSet(p[i]);
		 }
		
		public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }
		
		public void unionSet(int i, int j) 
		{ 
			 if (isSameSet(i, j)) 
				 return;
			 numSets--; 
			 int x = findSet(i), y = findSet(j);
			 // rank is used to keep the tree short
			 if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y]; }
			 else
			 {	p[x] = y; setSize[y] += setSize[x];
			 	if(rank[x] == rank[y]) rank[y]++; 
			 } 
		}
		
		public int numDisjointSets() { return numSets; }
		
		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	
	int m = Integer.parseInt(st.nextToken());
	int V = n+m ;
UnionFind union = new UnionFind(V);

	for(int i =0 ; i<n;i++){
		st = new StringTokenizer(br.readLine());
		int line = Integer.parseInt(st.nextToken());
		for(int j=0;j<line;j++){
		int now = Integer.parseInt(st.nextToken())-1+n;
		union.unionSet(i,now);

		}
	}
	int result = 0 ;
	for(int i =0 ; i<n;i++){
		for ( int j=i ; j<n;j++){
			if(!union.isSameSet(i, j)){
				result ++ ;
				union.unionSet(i, j);
			}
		}
	}

System.out.println(result);

}
}
