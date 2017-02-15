




import java.io.BufferedReader;
import java.io.InputStreamReader;

 class UVA_11639_GuradTheLand{
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
		}}
	
static class Rectangle {

		static final double EPS = 1e-9;
		
		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }

		double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

		boolean contains(Point p)
		{
			return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
		}

		boolean notOnBorder(Point p){
			return p.x != ur.x && p.x != ll.x && p.y!=ur.y && p.y != ll.y;
		}
		Rectangle intersect(Rectangle r)
		{
			Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
			Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
			if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
				return new Rectangle(ll, ur);
			return null;
		}
		
	}

	
	
	public static void main(String[]args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int counter = 1 ;
		while(n--!=0){
		String [] temp1 = br.readLine().split(" ");
		String [] temp2 = br.readLine().split(" ");
		int xl1 = Integer.parseInt(temp1[0]);
		int yl1 = Integer.parseInt(temp1[1]);
		int xr1 = Integer.parseInt(temp1[2]);
		int yu1 = Integer.parseInt(temp1[3]);
		
		int xl2 = Integer.parseInt(temp2[0]);
		int yl2 = Integer.parseInt(temp2[1]);
		int xr2 = Integer.parseInt(temp2[2]);
		int yu2 = Integer.parseInt(temp2[3]);
		Point ll1 = new Point (xl1,yl1);
		Point ur1 = new Point(xr1,yu1);
		
		Point ll2 = new Point (xl2,yl2);
		Point ur2 = new Point(xr2,yu2);
		
		Rectangle first = new Rectangle(ll1,ur1);
		Rectangle second = new Rectangle (ll2,ur2);
		Rectangle intersect = first.intersect(second);
		double Area1 = 0;
	if(first.intersect(second)!=null){
	    Area1 = intersect.area();}
		int Area2 =  (int)(first.area() +second.area()- Area1-Area1);
		int Area2H =  (int)(first.area() +second.area()-Area1);
	
				int Area3 = (int) (100*100 - Area2H) ;
		if(Area1 == first.area()){
			Area2 = (int)(second.area()-Area1);
		}
		if(Area1==second.area()){
			Area2 = (int)(first.area()-Area1);
		}
		System.out.println("Night "+counter+ ": " +(int)Area1+" "+ Area2 +" "+Area3 +"");
		counter++;
	}}

}
