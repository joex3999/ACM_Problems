

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF_237A_FreeCash {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		HashSet all = new HashSet(n);

		int g = n;
		if(n==0){
			System.out.println(0);
			return;
		}
		int result = 1;
		while (g-- > 0) {
		
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			h = h * 1000;

			int m = Integer.parseInt(st.nextToken());
			int r = h+m;
		
			if (all.contains(r)) {
				result++;
			} else {
				all.add(r);
			}
		}

		System.out.println(result);
	}
}
