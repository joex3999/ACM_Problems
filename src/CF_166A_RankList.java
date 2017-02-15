

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_166A_RankList {
	static class Pair implements Comparable {
		int s;
		int p;

		public Pair(int x, int y) {
			s = x;
			p = y;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			if (p.s == this.s) {
				return this.p <= p.p ? -1 : (this.p == p.p ? 0 : 1);
			}

			return this.s <= p.s ? 1 : -1;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Pair[] ranks = new Pair[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ranks[i] = new Pair(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));

		}

		Arrays.sort(ranks);

		Pair theOne = ranks[k - 1];

		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (theOne.s == ranks[i].s && theOne.p == ranks[i].p) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
