package CF_374;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberOfIntegers = 0;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> answers = new ArrayList<Integer>();
		char[] arr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int counter = 0;
			if (arr[i] == 'B') {
				while (arr[i] == 'B') {
					counter++;
					if (i + 1 < n) {
						i++;
					} else {
						break;
					}
				}
				numberOfIntegers++;
				answers.add(counter);
			}

		}
		sb.append(numberOfIntegers);
		boolean first = true;
		for (int i = 0; i < answers.size(); i++) {
			if (first) {
				sb.append("\n");
		sb.append(answers.get(i)+" ");
				first = false;
			} else {
				sb.append(answers.get(i)+" ");
			}
		}
		if(numberOfIntegers!=0)
		System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
		else
			System.out.println(sb.toString());
	}
}
