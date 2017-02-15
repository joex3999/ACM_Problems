

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;



public class XUVA_837_LightandTransparencies {
	
	
	static  class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		public double x, y;                  

		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
		
		public Point(double a, double b) { x = a; y = b; }  
		
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
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
		}
		
		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}
				
	}


	
	
	
	
	static class LineSegment {

		Point p, q;
		double g ;
		
		public LineSegment(Point a, Point b, double G) { p = a; q = b; g = G;}
		

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

	
	
	
public static void main (String []args)throws Exception{
	BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	while(n--!=0){
		String result = "" ;
		String useless = br.readLine();
		int num = Integer.parseInt(br.readLine());
		LineSegment [] lines = new LineSegment [num];
		double [] xaxis = new double [num*2];
		int j = 0 ;
		for(int i =0 ; i<num ; i++){
			String []s = br.readLine().split(" ");
			Point p = new Point(Double.parseDouble(s[0]),Double.parseDouble("0"));
			Point q = new Point(Double.parseDouble(s[2]),Double.parseDouble("0"));
			LineSegment ss = new LineSegment(p,q,Double.parseDouble(s[4]));
			lines[i] = ss;
			xaxis[j]= Double.parseDouble(s[0]);
			xaxis[j+1]= Double.parseDouble(s[2]);
		
			j+=2;
			
		}
		Arrays.sort(xaxis);
	double lastfactor = 0 ;
		double factor = 1.000 ;
		int counter = 0 ;
		result = result + "\n-inf " + xaxis[0] + " 1.000\n";
		for (int i =0 ; i<xaxis.length;i++){
			Point p1 = new Point(xaxis[i],0);
			Point q1 = new Point(xaxis[i+1],0);
		LineSegment test = new LineSegment(p1,q1,0);
		
		for(j = 0 ;j<lines.length;j++){
			if(lines[j].p.x==p1.x || lines[j].p.x==q1.x ||lines[j].q.x==q1.x||lines[j].q.x==p1.x)
				continue;
			
			if(test.intersect(lines[j])){
				if(i==0)
				System.out.println(lines[j].g);
				factor *= lines[j].g;
						if(i==0)
							System.out.println(lines[j].p.x + "    " +lines[j].q.x);
			}
			
			
		}
result += xaxis[i] +" "+ xaxis[i+1] + " " + factor  + "\n";		
		
if(i+1 == xaxis.length-1){
	result += xaxis[i+1] +" "+ "+inf" + " " + "1.000";
break;
}

		}
		System.out.println(result);
		
	}
}
}
