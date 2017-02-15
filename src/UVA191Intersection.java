

import java.io.BufferedReader;
import java.io.InputStreamReader;

 class UVA191Intersection {
	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		public double x, y;                  

		public Point(double a, double b) { x = a; y = b; }  
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; } }
	

 static  class LineSegment {

	Point p, q;
	
	public LineSegment(Point a, Point b) { p = a; q = b; }
	

	public boolean intersect(LineSegment ls)
	{
		Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
		if(l1.parallel(l2))
		{
			if(l1.same(l2))
				return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
			return false;
		}
		Point c = l1.intersect(l2);
		return c.between(p, q) && c.between(ls.p, ls.q);
	}

}

static  class Line {

	static final double INF = 1e9, EPS = 1e-9;
	
	public double a, b, c;
	
	public Line(Point p, Point q)
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
	
	public Point intersect(Line l)
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
		
	
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader ( new InputStreamReader (System.in));
	int n = Integer.parseInt(br.readLine());
	
	for(int i = 0 ; i<n; i ++){
	String []line = br.readLine().split(" ");
	int xstart = Integer.parseInt(line[0]);
	int ystart = Integer.parseInt(line[1]);
	int xend = Integer.parseInt(line[2]);
	int yend  = Integer.parseInt(line[3]);
	int xleft = Integer.parseInt(line[4]);
	int ytop = Integer.parseInt(line[5]);
	int xright  = Integer.parseInt(line[6]);
	int ybuttom = Integer.parseInt(line[7]);
	Point start = new Point (xstart,ystart);
	Point end = new Point (xend,yend);
	Point first = new Point(xleft,ytop);
	Point second = new Point(xright,ytop);
	Point third = new Point (xright,ybuttom);
	Point fourth = new Point (xleft,ybuttom);
	LineSegment Mline = new LineSegment(start,end);
	LineSegment firstline = new LineSegment (first,second);
	LineSegment secondline = new LineSegment(second,third);
	LineSegment thirdline = new LineSegment(third,fourth);
	LineSegment fourthline = new LineSegment(fourth,first);
	if(Mline.intersect(firstline)|| Mline.intersect(secondline)||Mline.intersect(thirdline)||Mline.intersect(fourthline)){
		System.out.println("T");
	}else{
		System.out.println("F");
	}
	
	
	}
}
}
