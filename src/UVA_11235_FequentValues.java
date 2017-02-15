import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVA_11235_FequentValues {

	public static class SegmentTree { // 1-based DS, OOP // 1-based so leaves
										// are 2*p
		// and
		// 2*p+1

		int N; // the number of elements in the array as a power of 2 (i.e.
				// after
				// padding)
		int[] array, sTree, lazy;

		SegmentTree(int[] in) {
			array = in;
			N = in.length - 1;
			sTree = new int[N << 1]; // no. of nodes = 2*N - 1, we add one to
										// cross
										// out index zero
			lazy = new int[N << 1];
			build(1, 1, N);
		}

		void build(int node, int b, int e) // O(n)
		{
			if (b == e)
				sTree[node] = array[b];
			else {
				build(node << 1, b, (b + e) / 2); // 2*p,low,middle
				build((node << 1) + 1, (b + e) / 2 + 1, e); // 2*p+1 ,
															// middle+1,high
				sTree[node] = Math
						.max(sTree[node << 1], sTree[(node << 1) + 1]); // if
				// min
				// sum
				// stree
				// =
				// min(bothNodes);
			}
		}

		void change_point(int index, int val) // O(log n)
		{
			index += N - 1;
			sTree[index] = val;
			while (index > 1) {
				index >>= 1;// parent formula = (i-1)/2;-> i/2 here because 1
							// based
				sTree[index] = sTree[index << 1] + sTree[(index << 1) + 1];// if
																			// min
																			// sum
																			// stree
																			// =
																			// min(bothNodes);
			}
		}

		void update_point(int index, int val) // O(log n)
		{
			index += N - 1;
			sTree[index] += val;
			while (index > 1) {
				index >>= 1;// parent formula = (i-1)/2;-> i/2 here because 1
							// based
				sTree[index] = sTree[index << 1] + sTree[(index << 1) + 1];// if
																			// min
																			// sum
																			// stree
																			// =
																			// min(bothNodes);
			}
		}

		void update_range(int i, int j, int val) // O(log n)
		{
			update_range(1, 1, N, i, j, val);
		}

		void update_range(int node, int b, int e, int i, int j, int val) {// b
																			// minimum
																			// ,
																			// e
																			// maximum
																			// ,
																			// i
																			// min
																			// query
																			// ,
																			// j
																			// max
																			// query
			if (i > e || j < b)
				return;
			if (b >= i && e <= j) {
				sTree[node] += (e - b + 1) * val; // adding the new sum value
													// here for the node .
				lazy[node] += val;
			} else {
				propagate(node, b, e);
				update_range(node << 1, b, (b + e) / 2, i, j, val);
				update_range((node << 1) + 1, (b + e) / 2 + 1, e, i, j, val);
				sTree[node] = sTree[node << 1] + sTree[(node << 1) + 1];
			}

		}

		void propagate(int node, int b, int e) {
			int mid = (b + e) / 2;
			lazy[node << 1] += lazy[node]; // left = lazy of node
			lazy[(node << 1) + 1] += lazy[node]; // right = lazy of node ;
			sTree[node << 1] += (mid - b + 1) * lazy[node];// adding the new sum
															// value here for
															// the node .
			sTree[(node << 1) + 1] += (e - mid) * lazy[node];// adding the new
																// sum value
																// here for the
																// node .
			lazy[node] = 0;
		}

		int query(int i, int j) {
			return query(1, 1, N, i, j);
		}

		int query(int node, int b, int e, int i, int j) // O(log n)
		{
			if (i > e || j < b)
				return 0;
			if (b >= i && e <= j)
				return sTree[node];
			// propagate(node, b, e);
			int q1 = query(node << 1, b, (b + e) / 2, i, j);
			int q2 = query((node << 1) + 1, (b + e) / 2 + 1, e, i, j);
			return Math.max(q1, q2);// will return minimum in case of Min range

		}

		void printTree() {
			for (int i = 0; i < sTree.length; i++) {
				System.out.printf("(%s,%s)", i, sTree[i]);
			}
			System.out.println();
		}

		void printLazy() {
			for (int i = 0; i < lazy.length; i++) {
				System.out.printf("(%s,%s)", i, lazy[i]);
			}
			System.out.println();
		}
	}

	public static class Pair {
		int freq;
		int start;
		int end = 0;

		public Pair(int f, int s, int e) {
			freq = f;
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner("in.txt");
		StringBuilder sb = new StringBuilder();
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int m = sc.nextInt();
			int[] arr = new int[n];
			HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				if (map.containsKey(arr[i])) {
					Pair g = map.get(arr[i]);
					if (i == n - 1) {
						g.end = i;

					}
					map.remove(arr[i]);
					g.freq++;
					map.put(arr[i], g);
				} else {
					map.put(arr[i], new Pair(1, i, 0));
					if (i > 0) {
						Pair s = map.get(arr[i - 1]);
						map.remove(s);
						s.end = i - 1;

						map.put(arr[i - 1], s);
					}
				}
			}
			int N = 1;
			while (N < n)
				N <<= 1; // padding
			int[] list = new int[N + 1];
			for (int i = 1; i <= n; i++)
				list[i] = map.get(arr[i - 1]).freq;
			SegmentTree t = new SegmentTree(list);
			loop: for (int i = 0; i < m; i++) {
				int first = sc.nextInt();
				int second = sc.nextInt();
				int firstb = map.get(arr[first - 1]).start + 1;
				int firste = map.get(arr[first - 1]).end + 1;
				int secondb = map.get(arr[second - 1]).start + 1;
				int seconde = map.get(arr[second - 1]).end + 1;
				int max = Integer.MIN_VALUE;
				if (firstb < first) {
					if (firste > second) {
						sb.append(second - first + 1 + "\n");

						continue loop;
					}
					max = firste - first + 1;
					first = firste + 1;

				}
				if (seconde > second) {
					int val = second - secondb + 1;
					max = Math.max(val, max);
					second -= val;
				}
				int query = 0;
				if (first <= second)
					query = t.query(first, second);
				sb.append(Math.max(query, max) + "\n");
			}

		}
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(String s) throws Exception {
			br = new BufferedReader(new FileReader(s));
		}

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
