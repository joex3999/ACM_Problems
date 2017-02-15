

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CF_498A_CrazyTown {
	
	static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		public double x, y;                  

		public Point(double a, double b) { x = a; y = b; }  
		
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
		
		Point rotate(double angle)
		{
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Point(x * c - y * s, x * s + y * c);
		}
		// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x
		
		Point rotate(double theta, Point p)			//rotate around p
		{
			Vector v = new Vector(p, new Point(0, 0));
			return translate(v).rotate(theta).translate(v.reverse());
		}
		
		Point translate(Vector v) { return new Point(x + v.x , y + v.y); }
		
		Point reflectionPoint(Line l) 	//reflection point of p on line l
		{
			Point p = l.closestPoint(this);
			Vector v = new Vector(this, p);
			return this.translate(v).translate(v);
		}
		
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
		
		//returns true if it is on the line defined by a and b
		boolean onLine(Point a, Point b) 
		{
			if(a.compareTo(b) == 0) return compareTo(a) == 0;
			return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
		}
	}
	
	static class Vector {

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

	

	static class Line {

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
		
		public   Point intersect(Line l)
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
		}
		
		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}
				
	}
	
	
	
	
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String []temp1 = br.readLine().split(" ");
	int x1 = Integer.parseInt(temp1[0]);
	int y1 = Integer.parseInt(temp1[1]);
	String []temp2 = br.readLine().split(" ");
	int x2 = Integer.parseInt(temp2[0]);
	int y2 = Integer.parseInt(temp2[1]);
	int n = Integer.parseInt(br.readLine());
	Point X = new Point (x1,y1);
	Point Y = new Point (x2,y2);
	ArrayList<Line> lines = new ArrayList<Line>();
	for(int i =0 ;i<n;i++){
		String [] line = br.readLine().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		int c = Integer.parseInt(line[2]);
		int A =0 ;
		int B =0;
		int C =0 ;
		
		if(b!=0){
		Line l =  new Line(new Point(0,-c),(-a/b));
		lines.add(l);	
		}else{
			Line l = new Line(new Point(0,-c),-1);
			lines.add(l);
		}
	}
	ArrayList <Point> points = new ArrayList<Point>();
	for(int i =0 ; i<lines.size();i++){

		Line current = lines.get(i);
		for(int j = 1 ;j<lines.size();j++){
			if(current.intersect(lines.get(j))!=null){
	
				points.add(current.intersect(lines.get(j)));
			}
		}
	lines.remove(i);
	}
	
	
	int steps = 0 ;
	for( int i =0 ;i<points.size();i++){

		if(points.get(i).onLine(X, Y)){
			steps +=2;
		}
	}
	System.out.println(steps);
}
}
