

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_733A_GrassHopper {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int result = 1;
		int temp = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'A' || arr[i] == 'O' || arr[i] == 'E'
					|| arr[i] == 'U' || arr[i] == 'I' || arr[i] == 'Y') {
				temp = 1;

			} else {
				temp++;
				result = Math.max(result, temp);
			}

		}
		System.out.println(result);
	}
}
