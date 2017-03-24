

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SunnyMountains {
	static final double EPS = 1e-9;
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	int C = Integer.parseInt( br.readLine());
	while(C>0){
		int numPoints = Integer.parseInt(br.readLine());
		Point[] x  = new Point[numPoints];
		for(int i = 0 ; i<numPoints ; i++){
			String [] temp = br.readLine().split(" ");
			 double X = Double.parseDouble(temp[0]);
			double Y = Double.parseDouble(temp[1]);
			Point g = new Point (X,Y);
			x[i] = g;
		}
		Arrays.sort(x);
	
double totalDistance = 0.0 ;

double max = 0.0 ;
		for(int l = x.length-2 ; l>=0;--l){
			if(x[l].y>max){
//				Line tempp = new Line (x[l],x[l+1]);
//				
//				Point temp1 = new Point ((tempp.c-tempp.b*max.y)/tempp.a,max.y);
//				
//				double first = temp1.dist(x[l]);
//				double second = x[l+1].dist(x[l]);
//				double finals = second-first ;
//				System.out.println("Distance   " + totalDistance);
//				totalDistance +=finals;
				double y0= x[l].y;
				 double y1= x[l+1].y;
				 double x0 = x[l].x ;
				 double x1 = x[l+1].x;
				double m = (y1 - y0) / (x1 - x0);
				double b = y0 - m * x0;
				
			double	yc = max;
				double xc = (yc - b) / m;
				
				double dx = x0 - xc;
				double dy = y0 - yc;
				totalDistance += Math.sqrt(dx * dx + dy * dy);
				max=x[l].y;
			}
		}
		System.out.printf("%.2f",totalDistance);
		C--;}
	
}
static class Point implements Comparable<Point> {
	double x, y;
	
	public Point(double x, double y) {
		this.x = x; this.y = y;
	}
	
	@Override
	public int compareTo(Point p)
	{
		if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
		if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
		return 0;
	}
	
}



}
