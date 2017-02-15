

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_716A_CrazyComputer {
public static void main(String[]args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int C = Integer.parseInt(st.nextToken());
int [] arr = new int [N];
 st = new StringTokenizer(br.readLine());
for(int i =0 ; i<N ; i++){
	arr[i] = Integer.parseInt(st.nextToken()); 
}
int before = arr[0];
int counter = 1 ; 
for(int i= 1 ; i<N ; i++){
	int now = arr[i];

	if(now-before>C){

		counter = 1 ;
	}else{
		counter ++;
	}
	before = now ;
}
System.out.println(counter);
}
}
