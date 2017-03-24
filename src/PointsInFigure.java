


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class PointsInFigure {
	abstract class Figure {
abstract boolean contains(Point p);
	}

	 class Vector {

		double x, y;

		Vector(double a, double b) {
			x = a;
			y = b;
		}

		Vector(Point a, Point b) {
			this(b.x - a.x, b.y - a.y);
		}

		Vector scale(double s) {
			return new Vector(x * s, y * s);
		} // s is a non-negative value

		double dot(Vector v) {
			return (x * v.x + y * v.y);
		}

		double cross(Vector v) {
			return x * v.y - y * v.x;
		}

		double norm2() {
			return x * x + y * y;
		}

		Vector reverse() {
			return new Vector(-x, -y);
		}

		Vector normalize() {
			double d = Math.sqrt(norm2());
			return scale(1 / d);
		}
	}

 static class Point implements Comparable<Point> {

		static final double EPS = 1e-9;

		public double x, y;

		public Point(double a, double b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(Point p) {
			if (Math.abs(x - p.x) > EPS)
				return x > p.x ? 1 : -1;
			if (Math.abs(y - p.y) > EPS)
				return y > p.y ? 1 : -1;
			return 0;
		}

		public double dist(Point p) {
			return Math.sqrt(sq(x - p.x) + sq(y - p.y));
		}

		double sq(double x) {
			return x * x;
		}
	 static boolean ccw(Point p, Point q, Point r)
		{
			PointsInFigure gg = new PointsInFigure ();
			return gg.new Vector(p, q).cross(gg.new Vector(p, r)) > 0;
		}
	}

	

	 class Circle extends Figure{ // equation: (x-c.x)^2 + (y-c.y)^2 = r^2

		static final double EPS = 1e-9;

		Point c;
		double r;

		Circle(Point p, double k) {
			c = p;
			r = k;
		}

		int inside(Point p) // 1 for inside, 0 for border, -1 for outside
		{
			double d = p.dist(c);

			return d + EPS < r ? 1 : Math.abs(d - r) < EPS ? 0 : -1;
		}
		@Override
		boolean contains(Point p ){
			double d = p.dist(c);
			if(d+EPS<r)
				return true ;
//if(Math.abs(d-r)<EPS)
//	return true ;

return false ;
			
		}
	}

	 class Rectangle extends Figure{

		static final double EPS = 1e-9;

		Point ll, ur;

		Rectangle(Point a, Point b) {
			ll = a;
			ur = b;
		}

		double area() {
			return (ur.x - ll.x) * (ur.y - ll.y);
		}

		@Override
		boolean contains(Point p) {
			return p.x < ur.x + EPS && p.x + EPS > ll.x && p.y < ur.y + EPS
					&& p.y + EPS > ll.y && notOnBorder(p);
		}
		boolean notOnBorder(Point p){
			return p.x != ur.x && p.x != ll.x && p.y!=ur.y && p.y != ll.y;
		}
	}

 class Triangle extends Figure {

		static final double EPS = 1e-9;

		Point a, b, c;
		double ab, bc, ca;

		Triangle(Point p, Point q, Point r) // counter clockwise
		{
			a = p;
			if (Point.ccw(p, q, r)) {
				b = q;
				c = r;
			} else {
				b = r;
				c = q;
			}

			ab = a.dist(b);
			bc = b.dist(c);
			ca = c.dist(a);
		}

		@Override
		boolean contains(Point p) {
			// a = p1 b = p2 c = p3
			double alpha = ((b.y - c.y) * (p.x - c.x) + (c.x - b.x)
					* (p.y - c.y))
					/ ((b.y - c.y) * (a.x - c.x) + (c.x - b.x) * (a.y - c.y));
			double beta = ((c.y - a.y) * (p.x - c.x) + (a.x - c.x)
					* (p.y - c.y))
					/ ((b.y - c.y) * (a.x - c.x) + (c.x - b.x) * (a.y - c.y));
			double gamma = 1.0f - alpha - beta;
			if (alpha > 0 && beta > 0 && gamma > 0) {
				return true;

			}
			return false;
			/*
			 * float alpha = ((p2.y - p3.y)*(p.x - p3.x) + (p3.x - p2.x)*(p.y -
			 * p3.y)) / ((p2.y - p3.y)*(p1.x - p3.x) + (p3.x - p2.x)*(p1.y -
			 * p3.y)); float beta = ((p3.y - p1.y)*(p.x - p3.x) + (p1.x -
			 * p3.x)*(p.y - p3.y)) / ((p2.y - p3.y)*(p1.x - p3.x) + (p3.x -
			 * p2.x)*(p1.y - p3.y)); float gamma = 1.0f - alpha - beta;
			 */
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PointsInFigure helper = new PointsInFigure ();
		Figure [] List = new Figure [10];
		String pap = null ;
		for(int i = 0 ; i<10 && (!(pap=br.readLine()).equals("*")) ; i++){
			String []line = pap.split(" ");
			if(line[0].equals("r")){
				double xul = Double.parseDouble(line[1]);
				double yul = Double.parseDouble(line[2]);
				double xlr = Double.parseDouble(line[3]);
				double ylr = Double.parseDouble(line[4]);
				Point lL = new Point (xul,ylr);
				Point ur = new Point (xlr,yul);
				List[i] = helper.new Rectangle (lL,ur);
			}
			if(line[0].equals("c")){
				double x = Double.parseDouble(line[1]);
				double y = Double.parseDouble(line[2]);
				double r = Double.parseDouble(line[3]);
				List[i] = helper.new Circle(new Point (x,y),r);
			}
			if(line[0].equals("t")){
				double x1 = Double.parseDouble(line[1]);
				double y1 = Double.parseDouble(line[2]);
				double x2 = Double.parseDouble(line[3]);
				double y2 = Double.parseDouble(line[4]);
				double x3 = Double.parseDouble(line[5]);
				double y3 = Double.parseDouble(line[6]);
				Point a = new Point (x1,y1);
				
				Point b = new Point(x2,y2); 
				
				Point c = new Point (x3,y3);
				List[i] = helper.new Triangle (a,b,c);
			}
		}


		
String input = br.readLine() ;
int ctr = 0 ;
while (true ){
	String [] tempp = input.split(" ");
	ctr ++ ;
	boolean contained = false ;
	double x = Double.parseDouble(tempp[0]);
	double y = Double.parseDouble(tempp[1]);
	Point g = new Point (x,y);
	for(int i =0 ; i<9;i++){
		if(List[i]!=null&&List[i].contains(g)){
			System.out.printf("\nPoint %s is contained in figure %s",ctr,i+1);
			
			contained = true ;
		}
	}
			if(!contained){
				System.out.printf("\nPoint %s is not contained in any figure ",ctr);
			
			}
input = br.readLine();
String [] aaa = input.split(" ");
double bla = Double.parseDouble(aaa[0]);
if(bla == 9999.9){
	break;
}
}

	}
}
