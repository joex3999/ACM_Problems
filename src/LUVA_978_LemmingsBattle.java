

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// submitted :https://github.com/sfmunera/uva/blob/master/UVa00978_LemmingsBattle.java
// check later
public class LUVA_978_LemmingsBattle {
	static public class compare implements Comparator<Integer> {

		@Override
		public int compare(Integer first, Integer second) {
			int x = (int) first;
			int y = (int) second;
			if (x > y) {
				return -1;
			}
			if (y > x) {
				return 1;
			}
			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean first = true ;
		StringBuilder sb = new StringBuilder();
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			int SG = Integer.parseInt(st.nextToken());
			int SB = Integer.parseInt(st.nextToken());
			Comparator<Integer> comm = new compare();
			PriorityQueue<Integer> green = new PriorityQueue<Integer>(comm);
			PriorityQueue<Integer> blue = new PriorityQueue<Integer>(comm);

			for (int i = 0; i < SG; i++) {
				green.add(Integer.parseInt(br.readLine()));
			}
			for (int h = 0; h < SB; h++) {
				blue.add(Integer.parseInt(br.readLine()));
			}

			while (green.size() > 0 && blue.size() > 0) {
				ArrayList<Integer> greener = new ArrayList<Integer>();
				ArrayList<Integer> bluee = new ArrayList<Integer>();

				for (int i = 0; i < 5; i++) {
					int g = 0;
					int b = 0;
					if (green.isEmpty() || blue.isEmpty()) {
						break;
					}

					g = green.poll();

					b = blue.poll();

					if (g > b) {
						greener.add(g - b);
					} else {
						if (g < b) {
							bluee.add(b - g);
						}
					}
				}
				while (!greener.isEmpty()) {
					green.add(greener.get(0));
					greener.remove(0);
				}
				while (!bluee.isEmpty()) {
					blue.add(bluee.get(0));
					bluee.remove(0);
				}
			}								if(first){
											first = false; 
											if (green.isEmpty() && blue.isEmpty()) {
												sb.append("green and blue died");
												continue;
											}
											
											
											
											if (green.isEmpty()) {
												sb.append("blue wins");
												for (int s : blue) {
													sb.append("\n"+s);
												}
											} 
											
											
											else
											{
												if (blue.isEmpty()) {
													sb.append("green wins");
													for (int s : green) {
														sb.append("\n"+s);
													}
												} else {
								
												}
											}}else{
												// asdasdasd
												if (green.isEmpty() && blue.isEmpty()) {
													sb.append("\n\ngreen and blue died");
													continue;
												}
												
												
												
												if (green.isEmpty()) {
													sb.append("\n\nblue wins");
													for (int s : blue) {
														sb.append("\n"+s);
													}
												} 
												
												
												else
												{
													if (blue.isEmpty()) {
														sb.append("\n\ngreen wins");
														for (int s : green) {
															sb.append("\n"+s);
														}
													} else {
									
													}
												}
											}

		}
	System.out.println(sb.toString());
	}
}
