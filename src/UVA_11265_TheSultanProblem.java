


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

 class UVA_11265_TheSultanProblem {
	
static class Line {

		static final double INF = 1e9, EPS = 1e-9;
		
		 double a, b, c;
		
	Line(Point p, Point q)
		{
			if(Math.abs(p.x - q.x) < EPS) {	a = 1; b = 0; c = -p.x;	}
			else
			{
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}
						
		}
		
		Line(Point p, double m) { a = -m; b = 1; c =  -(a * p.x + p.y); } 
		
		boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
		
		boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }
		
		 Point intersect(Line l)
		{
			if(parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if(Math.abs(b) < EPS)
				 y = -l.a * x - l.c;
			else
				y = -a * x - c;
			
			return new Point(x, y);
		}}

	
	static class Polygon { 
		// Cases to handle: collinear points, polygons with n < 3

		static final double EPS = 1e-9;
		
		Point[] g; 			//first point = last point, counter-clockwise representation
		
		Polygon(Point[] o) { g = o; }

		double perimeter()
		{
			double sum = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
				sum += g[i].dist(g[i+1]);
			return sum;
		}
		
		double area() 		//clockwise/anti-clockwise check, for convex/concave polygons
		{
			double area = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
				area += g[i].x * g[i+1].y - g[i].y * g[i+1].x;
			return Math.abs(area) / 2.0;			//negative value in case of clockwise
		}

		boolean isConvex()
		{
			if(g.length <= 3) // point or line
				return false;
			boolean ccw = Point.ccw(g[g.length - 2], g[0], g[1]);		//edit ccw check to accept collinear points
			for(int i = 1; i < g.length - 1; ++i)
				if(Point.ccw(g[i-1], g[i], g[i+1]) != ccw)
					return false;
			return true;
		}
		
		Polygon cutPolygon(Point a, Point b)	//returns the left part of the polygon, swap a & b for the right part
		{
			Point[] ans = new Point[g.length<<1];
			Line l = new Line(a, b);
			Vector v = new Vector(a, b);
			
			int size = 0;
			for(int i = 0; i < g.length; ++i)
			{
				double left1 = v.cross(new Vector(a, g[i]));
				double left2 = i == g.length - 1 ? 0 : v.cross(new Vector(a, g[i+1]));

				if(left1 + EPS > 0)	
					ans[size++] = g[i];
				if(left1 * left2 + EPS < 0)
					ans[size++] = l.intersect(new Line(g[i], g[i+1]));
			}
			
			if(size != 0 && ans[0] != ans[size-1])	//necessary in case g[0] is not in the new polygon
				ans[size++] = ans[0];
			return new Polygon(Arrays.copyOf(ans, size));
		}
	
	}
	
	
static  class Vector {

	double x, y; 

	Vector(double a, double b) { x = a; y = b; }

	Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

	Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

	double dot(Vector v) { return (x * v.x + y * v.y); }

	double cross(Vector v) { return x * v.y - y * v.x; }

	double norm2() { return x * x + y * y; }

	Vector reverse() { return new Vector(-x, -y); }

	Vector normalize() 
	{ 
		double d = Math.sqrt(norm2());
		return scale(1 / d);
	}		
}

	
	
	 static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		 double x, y;                  

	 Point(double a, double b) { x = a; y = b; }  
		
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
		
		static boolean ccw(Point p, Point q, Point r)
		{
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}
		
	 }

	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String usefull = null ;
	int counter = 1; 
	boolean first = false ;
	while((usefull=br.readLine())!=null){
		if(!first){
			first = true ;
		}else {
			usefull=br.readLine();
			if(usefull==null){
				return;
			}
		}
	String [] s = usefull.split(" ");
	int N = Integer.parseInt(s[0]);
	int W = Integer.parseInt(s[1]);
	int H = Integer.parseInt(s[2]);
	int x = Integer.parseInt(s[3]);
	int y = Integer.parseInt(s[4]);

	Point position = new Point (x,y);
	Point [] pointsfirst = new Point[N];
	Point [] pointssecond = new Point[N];
	
	for (int i =0 ; i<N ; i++){
		String [] temp = br.readLine().split(" ");
		int x1 = Integer.parseInt(temp[0]);
		int y1 = Integer.parseInt(temp[1]);
		int x2 = Integer.parseInt(temp[2]);
		int y2 = Integer.parseInt(temp[3]);
		pointsfirst[i]=new Point(x1,y1);
		pointssecond[i]= new Point (x2,y2);
	}
	
	Point edge1 = new Point (0,0);
	Point edge2 = new Point(W,0);
	Point edge3 = new Point (W,H);
	Point edge4 = new Point (0,H);
	Point [] square = new Point [5];
	square[0]= edge1;
	square[1] = edge2;
	square[2]=edge3;
	square[3]=edge4;
	square[4]= edge1;
	Polygon SQ = new Polygon (square);
	for(int i = 0 ; i<N;i++){
		if(position.ccw(pointsfirst[i],pointssecond[i], position)){
			SQ = SQ.cutPolygon(pointsfirst[i], pointssecond[i]);
		}else{
			SQ=SQ.cutPolygon(pointssecond[i], pointsfirst[i]);
		}
	}
	System.out.printf("Case #%s: %.3f\n",counter++,SQ.area());

}}
}
