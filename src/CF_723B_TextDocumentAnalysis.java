

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_723B_TextDocumentAnalysis {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		boolean inPar = false;
		int longestWord = Integer.MIN_VALUE;
		int currentLength = 0;
		int wordsIn = 0;
		for (int i = 0; i < n; i++) {
			char now = arr[i];
			if(now=='_'&&inPar){
				if(currentLength>0)
					wordsIn++;
			currentLength = 0 ;
			}
			if (now == '_' && !inPar) {
				longestWord = Math.max(currentLength, longestWord);
				currentLength = 0;
			}
			if (now != '_' && now != '(' && now != ')')
				currentLength++;
			if (now == ')') {
				if (currentLength > 0)
					wordsIn++;
				currentLength = 0 ;
			inPar = false ;
			}
			if (now == '(') {
				inPar = true;
				longestWord = Math.max(currentLength, longestWord);
				
				currentLength = 0;
			}
			
		}
	longestWord = Math.max(currentLength,longestWord);
		System.out.println(String.format("%s %s", longestWord,wordsIn));
	}

}
