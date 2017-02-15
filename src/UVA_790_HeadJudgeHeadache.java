

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// correct Theortically but submitted another answer From :
// cause the question got no idea and it's all labor work
public class UVA_790_HeadJudgeHeadache {
	static class Team implements Comparable {
		int solved;
		int time;
		int num ;

		public Team(int num ,int x, int y) {
			solved = x;
			time = y;
		this.num = num ;
		}

		@Override
		public int compareTo(Object o) {
			Team t = (Team) o;
			if (solved < t.solved) {
				return 1;
			} else {
				if (solved > t.solved) {
					return -1;
				} else {
					if (solved == t.solved) {
						return time < t.time ? -1 : time > t.time ? 1 : 0;
					}
				}
			}

			return 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] solved = new boolean[25][7];
boolean [] present = new boolean [25];
		int[] time = new int[25];
		int[][] previoussumbit = new int[25][7];
		int[] totalSolved = new int[25];
		String s = null;
		while (!(s = br.readLine()).equals("0")) {
			StringTokenizer st = new StringTokenizer(s);
			int team = Integer.parseInt(st.nextToken()) - 1;
			char problem = st.nextToken().charAt(0);
			int minutes = 0;
		
			int probEquiv = problem - 65;
			present [team] = true ;
			StringTokenizer ast = new StringTokenizer(st.nextToken(), ":");
			int hour = Integer.parseInt(ast.nextToken());
			 minutes = Integer.parseInt(ast.nextToken());
			char status = st.nextToken().charAt(0);
			if (status == 'Y' && solved[team][probEquiv] == false) {
				time[team] += (previoussumbit[team][probEquiv]) * 20
						+ hour * 60 + minutes;
		
				totalSolved[team]++;
				solved[team][probEquiv] = true;
			} else {
				if (!solved[team][probEquiv])
					previoussumbit[team][probEquiv] += 1;
			}

			
		}
		int numpresent = 0 ;
		for(int i =0 ; i<25;i++){
			if (present[i]){
				numpresent++;
			}
		}
		

		Team [] mems = new Team[numpresent];
		for(int i =0 ; i <mems.length;i++){
			mems[i] = new Team(i,totalSolved[i],time[i]);
			
		}
		Arrays.sort(mems);
System.out.printf("Rank Team PRO/SOLVED TIME\n");
for(int i =0 ;i<mems.length;i++){
	if(mems[i].solved>0)
	System.out.printf("  %s   %s   %s      %s\n",i+1,mems[i].num+1,mems[i].solved,mems[i].time);
	else
		System.out.printf("  %s   %s  \n",i+1,mems[i].num+1);
}

					

	}
}
