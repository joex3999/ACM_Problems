
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_719B_AnatolyAndCockroaches {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] taken = new boolean[n];
		char[] arr = br.readLine().toCharArray();
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int c4=0;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				if(arr[i]=='b')
				c3++;
				else
					c1++;
			}else{
				if(arr[i]=='r')
					c4++;
					else
					c2++;
			}
		
		}
		System.out.println(Math.min(Math.max(c1,c2), Math.max(c3, c4)));
	}
}
