

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// Only Use long on x ..  if u used an int it will fail cause he may add lots of 10^9 .. that why it used to fail on test 4  
public class CF_686A_FreeIceCream {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long x = Integer.parseInt(st.nextToken());
		int dissapointed = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			if (c=='+') {
				x += Long.parseLong(st.nextToken());
			} else {
				if(c=='-'){
				long temp = Long.parseLong(st.nextToken());
				if (x - temp >= 0) {
					x -= temp;
				} else {
					dissapointed += 1;
				}
			}
				}

		}
		System.out.println((int)Double.POSITIVE_INFINITY);

		System.out.print(x);
		//sad
		System.out.print(" "+dissapointed);
	}
}
