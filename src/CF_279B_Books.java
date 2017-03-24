import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_279B_Books {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		int[] books = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			books[i] = Integer.parseInt(st.nextToken());
		}
		int soFar = 0;
		int start = 0;
		int result = 0;
		int finish = 0;
		while (finish < n) {
			soFar += books[finish++];
			while (soFar > t) {
				soFar -= books[start++];
			}
			if (result < finish - start) {
				result = finish - start;
			}

		}

		System.out.println(result);
	}
}
