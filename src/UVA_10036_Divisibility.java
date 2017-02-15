
import java.io.*;

public class UVA_10036_Divisibility {
	
	static int N, K;
	static int[] numbers;
	static int[][] memo;
	// tested print writer and fileReader on it 
	static int solve(int i, int sum) {
		if (i == N && sum != 0)
			return 0;
		if (i == N && sum == 0)
			return 1;
		
		if (memo[i][sum] != -1)
			return memo[i][sum];

		return memo[i][sum] = solve(i + 1, Math.abs(sum + numbers[i]) % K) |   solve(i + 1, Math.abs(sum - numbers[i]) % K);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("new1.txt"));
		PrintWriter writer = new PrintWriter("thefile2.txt");

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		int MAXN = 10005;
		int MAXM = 105;
		memo = new int[MAXN][MAXM];
		
		while (T-- > 0) {
			String[] parts = in.readLine().split("[ ]+");
			N = Integer.parseInt(parts[0]);
			K = Integer.parseInt(parts[1]);
			
			numbers = new int[N];
			parts = in.readLine().split("[ ]+");
			for (int i = 0; i < N; ++i)
				numbers[i] = Integer.parseInt(parts[i]);
			
			for (int i = 0; i < MAXN; ++i)
				for (int j = 0; j < MAXM; ++j)
					memo[i][j] = -1;
			
			int ans = solve(0, 0);
			if (ans > 0)
				sb.append("Divisible\n");
			
			else
				sb.append("Not divisible\n");
		}
		sb.replace(sb.length()-1, sb.length(), "");
	writer.append(sb.toString());
		writer.close();
		in.close();
		System.exit(0);
	}
}