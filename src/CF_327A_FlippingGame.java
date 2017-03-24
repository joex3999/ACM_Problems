

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_327A_FlippingGame {
public static void main(String[]args)throws Exception{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n  = Integer.parseInt(br.readLine());
StringTokenizer st = new StringTokenizer(br.readLine());
int [] arr = new int [n];
for(int i =0 ; i<n;i++){
	arr[i] = Integer.parseInt(st.nextToken());
}
int totalmax = 0 ;
for(int i =0 ; i<n;i++){
	for( int j = i ;j<n;j++){
		int max = 0 ;
		for( int k =0; k<n;k++){
			if(k>=i&&k<=j){
				if(1-arr[k]==1)
					max++;
			}else{
				if(arr[k]==1)
					max++;
			}
		}
	if(max>totalmax)
		totalmax=max;
	}
}
System.out.println(totalmax);
}
}
