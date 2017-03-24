



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CF617 {
	
	 class Circle { 	//equation: (x-c.x)^2 + (y-c.y)^2 = r^2

		static final double EPS = 1e-9;
		
		Point c;
		double r;

		Circle(Point p, double k) { c = p; r = k; }

		int inside(Point p)	//1 for inside, 0 for border, -1 for outside
		{
			double d = p.dist(c);

			return d + EPS < r ? 1 : Math.abs(d - r) < EPS ? 0 : -1;
		}
	 }
	
 class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		public double x, y;                  

		public Point(double a, double b) { x = a; y = b; }  
		
		@Override
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x < p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y < p.y ? 1 : -1;
			return 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		 double sq(double x) { return x * x; }}
		
public static void main(String []args)throws Exception{
	CF617 helper = new CF617 ();
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	String [] temp = br.readLine().split(" ");
	int r1 = 0 ;
	int r2 = 0;
	int n = Integer.parseInt(temp[0]);
	int x1 = Integer.parseInt(temp[1]); 
	int y1 = Integer.parseInt(temp[2]);
	int x2 = Integer.parseInt(temp[3]);
	int y2 = Integer.parseInt(temp[4]);
	Point Mid1 = helper.new Point (x1,y1);
	Point Mid2 = helper.new Point(x2,y2);
	Point [] points = new Point[n];
	for(int i = 0 ; i < n ; i++){
		String []temp2 =  br.readLine().split(" ");
		int x = Integer.parseInt(temp2[0]);
		int y = Integer.parseInt(temp2[1]);
		Point g = helper.new Point (x,y);
		points[i] = g ;
	}
	Arrays.sort(points);
	Circle c1 = helper.new Circle(Mid1,r1);
	Circle c2 = helper.new Circle(Mid2,r2);
	if(c2.c.x>c1.c.x || c2.c.x == c1.c.x && c2.c.y > c1.c.y ){
		Circle tempC = c1 ;
		c1 = c2 ;
		c2 = tempC ;
	}
	for(int i = 0 ; i<points.length;i++){

		if(c1.inside(points[i])==-1 && c2.inside(points[i])==-1){
			if(c1.c.dist(points[i])<c2.c.dist(points[i])){
				c1.r = c1.c.dist(points[i]);
			}else{
				c2.r = c2.c.dist(points[i]);
			}
		}
	}	
	int result = (int)(c1.r*c1.r + c2.r*c2.r);
	System.out.println(result);
	
}
}
