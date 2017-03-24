import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_706C_HardProblem {
	static String[] arr;
	static int[] cost;
	static int n;

	public static boolean check(String a, boolean aReverse, String b,
			boolean bReverse) {
		int aIndex = 0, aIncr = 1, aEnd = a.length();
		if (aReverse) {
			aIndex = a.length() - 1;
			aIncr = -1;
			aEnd = -1;
		}

		int bIndex = 0, bIncr = 1, bEnd = b.length();
		if (bReverse) {
			bIndex = b.length() - 1;
			bIncr = -1;
			bEnd = -1;
		}

		while (aIndex != aEnd && bIndex != bEnd) {
			if (a.charAt(aIndex) > b.charAt(bIndex)) {
				return true;
			} else if (a.charAt(aIndex) < b.charAt(bIndex)) {
				return false;
			} else {
				aIndex += aIncr;
				bIndex += bIncr;
			}
		}
		return aIndex != aEnd;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int MAX = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		cost = new int[n];
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		arr = new String[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}
		int[][] dp = new int[n][2];
		for (int i = 0; i < n; i++) {
			dp[i][0] = dp[i][1] = MAX;
		}
		dp[0][0] = 0;
		dp[0][1] = cost[0];
		boolean failed = false;
		for (int i = 1; i < n; i++) {
			String now = arr[i];
			String prev = arr[i - 1];
			if (!check(prev, false, now, false)) {
				dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
			}
			if (!check(prev, true, now, false)) {
				dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
			}
			if (!check(prev, false, now, true)) {
				dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + cost[i]);
			}
			if (!check(prev, true, now, true)) {
				dp[i][1] = Math.min(dp[i][1], dp[i - 1][1] + cost[i]);
			}
			if (dp[i][0] == MAX && dp[i][1] == MAX) {
				failed = true;
				break;
			}
		}
		if (failed) {
			System.out.println("-1");
		} else
			System.out.println(Math.min(dp[n - 1][0], dp[n - 1][1]));

	}
}
