

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;





public class UVA_10301_RingsAndGlue {
	public static  class Circle { 	//equation: (x-c.x)^2 + (y-c.y)^2 = r^2

		static final double EPS = 1e-9;
		
		Point c;
		double r;

		Circle(Point p, double k) { c = p; r = k; }

		int inside(Point p)	//1 for inside, 0 for border, -1 for outside
		{
			double d = p.dist(c);

			return d + EPS < r ? 1 : Math.abs(d - r) < EPS ? 0 : -1;
		}
		boolean intersect(Circle cir)
		{
			return c.dist(cir.c) <= r + cir.r + EPS && c.dist(cir.c) + EPS >= Math.abs(r - cir.r);
		}
	}
	public static  class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		public double x, y;                  

		public Point(double a, double b) { x = a; y = b; }  
		
		@Override
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		static double sq(double x) { return x * x; }
	}
	
	
	public static class UnionFind {                                              
		int[] p, rank, setSize;
		int numSets;
		int maxSize  ;
		public UnionFind(int N) 
		{
			 p = new int[N];
			 rank = new int[N];
			 setSize = new int[N];
			 numSets = N;
			 if(N>0){
				 maxSize=1;
			 }
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
			 if (rank[x] > rank[y]) { p[y] = x; setSize[x] += setSize[y];
			 if(setSize[x]>maxSize){
				 maxSize=setSize[x];}
			 }
			 else
			 {	p[x] = y; setSize[y] += setSize[x];
			 if(setSize[y]>maxSize){
				 maxSize=setSize[y];
			 }
			 	if(rank[x] == rank[y]) rank[y]++; 
			 } 
		}
		
		public int numDisjointSets() { return numSets; }
		
		public int sizeOfSet(int i) { return setSize[findSet(i)]; }
	}
	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	while(true){
		int n = Integer.parseInt(br.readLine());
		if(n==-1){
			break;
		}
	UnionFind union = new UnionFind(n);	
	HashMap<Circle,Integer> map1 = new HashMap<Circle,Integer>();
	HashMap<Integer,Circle> map2 = new HashMap<Integer,Circle>();
	ArrayList<Circle> list = new ArrayList<Circle>();
		for(int i=0 ; i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x= Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			double r = Double.parseDouble(st.nextToken());
		
			Circle neww = new Circle(new Point(x,y),r);
			list.add(neww);
			map1.put(neww,i);
			map2.put(i,neww);
		}
		for(int i=0 ; i<list.size();i++){
			Circle now = list.get(i);
			int equiv =map1.get(now); 
			for(int j =i+1 ;j<list.size();j++){
				Circle now2 = list.get(j);
			
				int equiv2 = map1.get(now2);
			if(now.intersect(now2)&&!union.isSameSet(equiv,equiv2)){
				union.unionSet(equiv, equiv2);
			}
			}
		}
		if(union.maxSize!=1)
sb.append(String.format("The largest component contains %s rings.\n", union.maxSize));
		else
			sb.append(String.format("The largest component contains %s ring.\n", union.maxSize));
	}
	sb.replace(sb.length()-1, sb.length(),"");
	System.out.println(sb.toString());
}
}
