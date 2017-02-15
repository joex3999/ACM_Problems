

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11496_MusicalLoop {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		StringBuilder sb = new StringBuilder();
		boolean first = true ;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			int result = 0 ;
			for(int i =0 ; i<n;i++){
				if(i!=0&&i!=n-1){
					if((arr[i]<arr[i+1]&&arr[i]<arr[i-1])||(arr[i]>arr[i+1]&&arr[i]>arr[i-1]))
						result++;
			
					
				}
				
				if(i==0)
					if((arr[0]<arr[1]&&arr[0]<arr[n-1])||(arr[0]>arr[1]&&arr[0]>arr[n-1]))
						result++;
				
				if(i==n-1)
					if((arr[n-1]<arr[0]&&arr[n-1]<arr[n-2])||(arr[n-1]>arr[0]&&arr[n-1]>arr[n-2]))
						result++;
				
			}
			if(first){
				sb.append(""+result);
				first = false ;
			}else{
				sb.append("\n"+result);
			}
			
		}
		System.out.println(sb.toString());
	}
}
