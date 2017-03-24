

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_10878_DecodeTheTape {
	public static String BinaryToString(StringBuilder binary) {
		String x = binary.toString();
	System.out.println(x);
		int decimalvalue = Integer.parseInt(x, 2);
		System.out.println(decimalvalue);
		String g = Character.toString((char) decimalvalue);
		return g;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = null;
		StringBuilder answer = new StringBuilder();

		while ((n = br.readLine()) != null) {
			char[] arr = n.toCharArray();
			StringBuilder binary = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
	
				switch (arr[i]) {
				case ' ':
					binary.append("0");
					break;
				case 'o':
					binary.append("1");
					break;
				default:
					break;
				}
				
			}
			String value = BinaryToString(binary);
		
			answer.append(value);
			
		}
		System.out.println(answer.toString());
	}
}
