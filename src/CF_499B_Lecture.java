

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_499B_Lecture {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder result = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String firstString = st.nextToken();
			String secondString = st.nextToken();
			map.put(firstString, secondString);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			String now = st.nextToken();
			String nowMirror = map.get(now);
			String resultT = nowMirror.length() >= now.length() ? now
					: nowMirror;
			result.append(resultT + " ");
		}
		System.out.println(result.replace(result.length() - 1, result.length(),
				""));
	}
}
