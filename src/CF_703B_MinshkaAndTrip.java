

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
// try changing int to long and see what would happen 
public class CF_703B_MinshkaAndTrip {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		String line = br.readLine();
		int[] capitals = new int[k];
		int[] cities = new int[n];

		HashSet<Integer> capitalsSet = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; st.hasMoreTokens(); i++) {
			int now = Integer.parseInt(st.nextToken());
			capitals[i] = now;
		
			capitalsSet.add(now-1);
		}

		int totalSum = 0;
		int sumOfCities = 0;
		st = new StringTokenizer(line);
		int before = Integer.parseInt(st.nextToken());
		cities[0] = before;
		sumOfCities+=before;
		for (int i = 1; i < n ; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
	
			totalSum += cities[i] * cities[i - 1];
			sumOfCities += cities[i];
		}
		totalSum += cities[n - 1] * cities[0];

		for (int i = 0; i < capitals.length; i++) { // n2s 2l 2bl wl b3d lw 2l
													// b3d msh capital //
													// special case if first
													// item or last item
			int nowPosition = capitals[i] - 1;
	
			if (nowPosition == n - 1) {
				totalSum -= cities[nowPosition] * cities[nowPosition - 1];
				if (!capitalsSet.contains(0)) {
					totalSum -= cities[0] * cities[nowPosition];
				}
				int nowSubSum = sumOfCities - cities[nowPosition];
				totalSum += nowSubSum * cities[nowPosition];
				sumOfCities=nowSubSum;
				continue;
			}
			if (nowPosition == 0) {
		
				totalSum -= cities[nowPosition] * cities[n - 1];
						if (!capitalsSet.contains(nowPosition+1)) {
					totalSum -= cities[nowPosition + 1] * cities[nowPosition];
				}
								int nowSubSum = sumOfCities - cities[nowPosition];
				totalSum += nowSubSum * cities[nowPosition];
sumOfCities = nowSubSum;

				continue;
			}
	
			totalSum -= cities[nowPosition] * cities[nowPosition - 1];
		
			//System.out.println(capitalsSet.contains(nowPosition+1));
			if (!capitalsSet.contains(nowPosition+1)) {
			
					totalSum -= cities[nowPosition + 1] * cities[nowPosition];
				
			}
			int nowSubSum = sumOfCities - cities[nowPosition];
			totalSum += nowSubSum *cities[nowPosition];
			sumOfCities= nowSubSum;

		}
	
System.out.println(totalSum);
	}

}
