

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class XUVA_10446_TheMarriageInterview {
	static long[][] saved;
	static long[][]anothersave;
	static long count;

	public static long trib(int n, int back) {
		long sum = 0;
		int i;
		count++;
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
	
			
if(saved[n][back]!=-1){
	count--;
	count+= anothersave[n][back];
	return saved[n][back];
}

		for (i = 1; i <= back; i++)
			sum += trib(n - i, back);
anothersave[n][back]= count ;
		return  saved[n][back]=sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int casee = 0;
		StringBuilder sb = new StringBuilder();
		saved = new long[63][63];
anothersave = new long[63][63];
		for (int i = 0; i <= 60; i++){
	Arrays.fill(saved[i], -1);
	Arrays.fill(anothersave[i], -1);
		}
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());

			if (n > 60 && back > 60)
				return;
count =0 ;
trib(n,back);
System.out.println(count);
		}
	}
}
