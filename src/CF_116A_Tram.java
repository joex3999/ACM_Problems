
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF_116A_Tram {
public static void main(String[] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int max = Integer.MIN_VALUE;
	int current = 0 ;
	for(int i =0 ; i <n;i++){
		StringTokenizer st = new StringTokenizer(br.readLine());
		current-=Integer.parseInt(st.nextToken());
		
	current+=Integer.parseInt(st.nextToken());
	max= Math.max(max, current);
	}
	System.out.println(max);
}
}