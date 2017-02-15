

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_270A_FancyFence {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	while(n-->0){
		int g = Integer.parseInt(br.readLine());
		//((360%(180-g))==0 )?System.out.printf("YES\n"):System.out.printf("NO\n");
		if(360%(180-g)==0){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
}
}
