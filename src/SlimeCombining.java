

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SlimeCombining {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String result = "";
		for (int i = 1; i < 33; i++) {

			if ((n & ((1 << 1) - 1)) == 1) {
				if(i==1)
					result= ""+i;
				else
				result = i +" "+ result;
			}
			n = n >> 1;

		}
		System.out.println(result);
	}

}
