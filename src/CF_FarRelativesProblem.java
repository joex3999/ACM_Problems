import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CF_FarRelativesProblem {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] males = new int [367];
		int [] females = new int [367];
		Arrays.fill(males, 0);
		Arrays.fill(females, 0);
		for(int i =0 ; i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int begin = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			for(int j = begin ; j<=end;j++){
				if(c=='M')
				{
					males[j]++;
				}else{
					females[j]++;
				}
			}
		}
		int answer = 0 ;
		for(int i =0 ; i <=366 ; i++){
			int minimum = Math.min(males[i], females[i]);
				answer = Math.max(answer, minimum*2);
		}
	sb.append(answer);
	System.out.println(sb.toString());
	}
}

