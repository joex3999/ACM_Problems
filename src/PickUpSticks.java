




import java.io.BufferedReader;
import java.io.InputStreamReader;

 class PickUpSticks {
	
	class LineSegment {

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
	 
	 
	 

	  class Line {

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

	  
	   class Point implements Comparable<Point>{

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
			
		
			
			boolean between(Point p, Point q)
			{
				return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
						&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
			}
			
			
			Point rotate(double angle)
			{
				double c = Math.cos(angle), s = Math.sin(angle);
				return new Point(x * c - y * s, x * s + y * c);
			}
			// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x
			
			







	 
	 
	   }
public static void main(String []args) throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
	String s = br.readLine();
	while(!s.equals("0")){
		PickUpSticks aaaa = new PickUpSticks();
		int num = Integer.parseInt(s);
		LineSegment [] lines = new LineSegment [num];
		for(int i = 0 ; i <num ; i++){
			String []linee = br.readLine().split(" ");
			 
			Point begin = aaaa.new Point(Double.parseDouble(linee[0]),Double.parseDouble(linee[1]));
			Point  end = aaaa.new Point(Double.parseDouble(linee[2]),Double.parseDouble(linee[3]));
LineSegment temp = aaaa.new LineSegment (begin,end);
lines[i] = temp ;
		}
		String result = "Top sticks:";
		boolean [] x = new boolean [num];
	
		for(int i = 0 ; i <num;i++){
			for (int j =i +1  ; j<num ;j++){
				if(lines[i].intersect(lines[j])){
					x[i]= true;
					break;
					
				}
			}
		}
		
		for(int i = 0 ; i<x.length;i++){
			if(x[i]==false){
				result += " " + (i+1) + ",";
			}
		}
	result = result.substring(0, result.length()-1);
	result += ".";
	System.out.println(result);
	s = br.readLine();	
	}
}}
