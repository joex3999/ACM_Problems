

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GleamingTheCubes {
	static class Pair {
		int begin, end;

		 Pair(int L, int H) {
			begin = L;
			end = H;
		}
	}

	static class Cube {
		Pair x, y, z;

	 Cube(Pair g, Pair h, Pair j) {
			x = g;
			y = h;
			z = j;
		}
	int  Volume (){
		 int xaxis = x.end - x.begin;
		 int yaxis = y.end - y.begin;
		 int zaxis = z.end - z.begin;
		 return xaxis * yaxis * zaxis ;
	 }
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int greatestx = -9999999;
		int smallestdx=999999;
		int greatesty =-999999;
		int smallestdy = 999999999 ;
		int greatestz = -99999;
		int smallestdz= 99999999;
		while (!(s = br.readLine()).equals("0")) {
			String []ss = s.split(" ");
			int n = Integer.parseInt(ss[0]);
			Cube[] cubes = new Cube[n];
			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				int z = Integer.parseInt(temp[2]);
				int d = Integer.parseInt(temp[3]);
				Pair first = new Pair(x, x + d);
				Pair second = new Pair(y, y + d);
				Pair third = new Pair(z, z + d);
				Cube cubee = new Cube(first, second, third);
				cubes[i] = cubee;
//			if(x+d<smallestx||x>smallestdx){
//				System.out.println("0");
//				break;
//			}
//			if(y+d<smallesty||y>smallestdy){
//				System.out.println("0");
//			
//			break;}
//			if(z+d<smallestz||z>smallestdz){
//				System.out.println("0");
//		break;	}
				if(x>greatestx){
					greatestx = x ;
				}
				if(y>greatesty){
					greatesty = y;
					
				}
				if(z>greatestz){
					greatestz = z ;
				}
				if(x+d<smallestdx){
					smallestdx = x+d;
				}
				if(y+d<smallestdy){
					smallestdy = y+d;	
				}
				if(z+d<smallestdz){
					smallestdz = z+d;
				}
			}

			int xaxis = 	smallestdx - greatestx ;
			int yaxis = smallestdy - greatesty ;
			int zaxis = smallestdz - greatestz;
			System.out.println(xaxis*yaxis*zaxis);
			
			
		}
		
		
	}
}
