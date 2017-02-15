
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// not done 
public class CF_1A_TheatreSquare {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		long m = Integer.parseInt(st.nextToken());
		long a = Integer.parseInt(st.nextToken());
		long length = (long) Math.ceil((double) n / a);
		long height = (long) Math.ceil((double) m / a);
		System.out.println(length * height);
	}
}
