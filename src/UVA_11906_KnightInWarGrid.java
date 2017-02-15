

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11906_KnightInWarGrid {
	static int[][] grid;
	static int [][] kgrid;
	static int R, C, M, N;
	static int[] dx = new int[8];
	static int[] dy = new int[8];
	static int evenNumber;
	static int oddNumber;

	static boolean valid(int i, int j) {
		return i >= 0 && j >=0 && i < R && j < C &&grid[i][j]!=4;
	}

	static void dfs2(int i, int j) {
		grid[i][j] = 1;
		
		for (int k = 0; k < 8; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
				if (valid(x, y)) {
kgrid[i][j]++;

if(grid[x][y]!=1)
					dfs2(x, y);
				}
			
		}
	
		if(kgrid[i][j]%2==0)
			evenNumber++;
		else
			oddNumber++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int casee = 0 ;
		while (c-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			evenNumber = 0 ;
			oddNumber = 0;
			grid = new int[R][C];
			kgrid= new int[R][C];
			dx[0] = M;
			dx[1] = N;
			dy[0] = N;
			dy[1] = M;
			dx[2]=-M;
			dy[2]=N;
			dx[3]=N;
			dy[3]=-M;
			dx[4]=M;
			dy[4]=-N;
			dx[5]=-N;
			dy[5]=M;
			dx[6]=-M;
			dy[6]=-N;
			dx[7]=-N;
			dy[7]=-M;
			
			int W = Integer.parseInt(br.readLine());
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				grid[x][y] = 4;
			}
		dfs2(0,0);
	sb.append(String.format("Case %s: %s %s\n", ++casee,evenNumber,oddNumber));
		}
		sb.replace(sb.length()-1, sb.length(), "");
		System.out.println(sb.toString());
	}
}
