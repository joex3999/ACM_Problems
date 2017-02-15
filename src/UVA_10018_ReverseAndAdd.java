

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_10018_ReverseAndAdd {
	static boolean palindrome(String x) {
		int length = x.length();
		for (int i = 0; i < length / 2; i++) {
			if (x.charAt(i) != x.charAt(length - i -1 )) {
				return false;
			}

		}
		return true;
	}

	static String reverse(String x) {
		String result = "";
		for (int i = 0; i < x.length(); i++) {
			result = x.charAt(i) + result;
		}
		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int counter = 0;

		while (x-- != 0) {
			long number = Long.parseLong(br.readLine());
			while(!palindrome("" + number)) {
				long res = Long.parseLong(reverse("" + number));
				number = res + number;
				counter++;
			}
			System.out.println(counter + " " + number);
			counter = 0;
		}

	}
}
