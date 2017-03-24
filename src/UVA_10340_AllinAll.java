

import java.util.Scanner;

public class UVA_10340_AllinAll {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext()) {
			String s = in.next();
			String t = in.next();
			
			boolean isSubsequence = true;
			int k = 0;
			
			for (int i = 0; i < s.length(); ++i) {
				char c = s.charAt(i);
				while (k < t.length() && t.charAt(k) != c) ++k;
				if (k == t.length()) {
					isSubsequence = false;
					break;
				}
				++k;
			}
			System.out.println(isSubsequence ? "Yes" : "No");
		}
	}
}

