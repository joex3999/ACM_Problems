

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// right answer but presentation error ; submitted Another Code cause i didnt know the presentation Error
public class UVA_11360_HavingFunWithMatrices {
	static int[][] arr;

	static String print2D(int[][] n) {

StringBuilder br = new StringBuilder();

		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
		
				br.append(n[i][j]);
			}
			if (!(i == n.length - 1||i==n.length-1))
				br.append("\n");
		}
		return br.toString();
	}

	static public int[][] transpose() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
	
			}
		}

		return arr;
	}

	static public int[][] row(int a, int b) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[a - 1][i];
			arr[a - 1][i] = arr[b - 1][i];
			arr[b - 1][i] = temp;
		}
		return arr;
	}

	static public int[][] col(int a, int b) {
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i][a - 1];
			arr[i][a - 1] = arr[i][b - 1];
			arr[i][b - 1] = temp;
		}
		return arr;
	}

	static public int[][] inc() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]+1==10){
					arr[i][j]=0;
				}else{
					arr[i][j]++;
				}
			}
		}
		return arr;
	}

	static public int[][] dec() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]-1==-1){
					arr[i][j]=9;
				}else{
					arr[i][j]--;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int casee = 1 ;
		boolean first = true ;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				for (int j = 0; j < n; j++) {

					arr[i][j] = Character.getNumericValue(line.charAt(j));
				}

			}

		

			int m = Integer.parseInt(br.readLine());
			for (int g = 0; g < m; g++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				switch (st.nextToken()) {
				case "transpose":
					arr = transpose(); break;
				case "row":
					arr = row(Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()));break;
				case "col":
					arr = col(Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()));break;
				case "inc":
					arr = inc();break;
				case "dec":
					arr = dec();break;

				}
			}
		
			if(first){
				first = false ;
			
				sb.append("Case #"+casee++ +"\n");
				sb.append(print2D(arr));
				
			}else{
			
				sb.append("\n\nCase #"+casee+++"\n");
				sb.append(print2D(arr));
			}
		}
	
		System.out.println(sb.toString());
	}
}
