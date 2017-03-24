

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;


public class UselessTilePackers {

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
		static boolean ccw(Point p, Point q, Point r) {
			UselessTilePackers gg = new UselessTilePackers();
			return gg.new Vector(p, q).cross(gg.new Vector(p, r)) > 0;
		}

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

	}

	class Polygon {
		// Cases to handle: collinear points, polygons with n < 3

		static final double EPS = 1e-9;

		Point[] g; // first point = last point, counter-clockwise representation

		Polygon(Point[] o) {
			g = o;
		}

		double perimeter() {
			double sum = 0.0;
			for (int i = 0; i < g.length - 1; ++i)
				sum += g[i].dist(g[i + 1]);
			return sum;
		}

		double area() // clockwise/anti-clockwise check, for convex/concave
						// polygons
		{
			double area = 0.0;
			for (int i = 0; i < g.length - 1; ++i)
				area += g[i].x * g[i + 1].y - g[i].y * g[i + 1].x;
			return Math.abs(area) / 2.0; // negative value in case of clockwise
		}

		Polygon convexHull(Point[] points) // all points are unique, remove
											// duplicates, edit ccw to accept
											// collinear points
		{
			int n = points.length;
			Arrays.sort(points);
			Point[] ans = new Point[n << 1];
			int size = 0, start = 0;

			for (int i = 0; i < n; i++) {
				Point p = points[i];
				while (size - start >= 2
						&& !Point.ccw(ans[size - 2], ans[size - 1], p))
					--size;
				ans[size++] = p;
			}
			start = --size;

			for (int i = n - 1; i >= 0; i--) {
				Point p = points[i];
				while (size - start >= 2
						&& !Point.ccw(ans[size - 2], ans[size - 1], p))
					--size;
				ans[size++] = p;
			}
			// if(size < 0) size = 0 for empty set of points
			return new Polygon(Arrays.copyOf(ans, size));
		}

	}


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int s = 0;
		UselessTilePackers wa = new UselessTilePackers();
		 StringBuilder sb = new StringBuilder();
	        NumberFormat nf = NumberFormat.getInstance(Locale.US);
		int counter = 1 ;
		while ((s = Integer.parseInt(br.readLine())) != 0) {
			Point[] points = new Point[s]; // check the extra point problem ;
			new Point(0, 0);
		
			for (int i = 0; i < s; i++) {

				String[] temp = br.readLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				Point g = new Point(x, y);
				points[i] = g;
				if (i == 0) {
				}
			}

			Polygon temp2 = wa.new Polygon(points);
			double areaa = temp2.area();


	

			Polygon temp = wa.new Polygon(points);
			temp = temp.convexHull(points);
			double Area = temp.area();
		
//		System.out.println("Tile #" + counter );
//		
//	
//		System.out.printf("Wasted Space = %.2f ", ((Area - areaa )/Area )*100);
//		System.out.print("%");
//		counter ++ ;
		 sb.append("Tile #" + counter + "\n");
        sb.append("Wasted Space = " + nf.format(100 - (Area * 100) / areaa) + " %\n\n");
        counter ++ ;

		}
		System.out.println(sb);
	}
}
