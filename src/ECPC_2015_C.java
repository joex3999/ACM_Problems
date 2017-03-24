

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ECPC_2015_C {
	public static class UnionFind {
		int[] p, rank, setSize;
		int numSets;

		public UnionFind(int N) {
			p = new int[N];
			rank = new int[N];
			setSize = new int[N];
			numSets = N;
			for (int i = 0; i < N; i++) {
				p[i] = i;
				setSize[i] = 1;
			}
		}

		public int findSet(int i) {
			if (p[i] == i)
				return i;
			else
				return p[i] = findSet(p[i]);
		}

		public Boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (isSameSet(i, j))
				return;
			numSets--;
			int x = findSet(i), y = findSet(j);
			// rank is used to keep the tree short
			if (rank[x] > rank[y]) {
				p[y] = x;
				setSize[x] += setSize[y];
			} else {
				p[x] = y;
				setSize[y] += setSize[x];
				if (rank[x] == rank[y])
					rank[y]++;
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize[findSet(i)];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			UnionFind uf = new UnionFind(n);
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int status = Integer.parseInt(st.nextToken());
				if (status == 1) {
uf.unionSet(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);

				} else {

				}
			}
		}
	}
}
