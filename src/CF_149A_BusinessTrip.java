

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_149A_BusinessTrip {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int k = Integer.parseInt(st.nextToken());
	st = new StringTokenizer(br.readLine());
	int [] a =new int [12];
	for(int i =0 ; i<12 ; i++){
		a[i] = Integer.parseInt(st.nextToken());
	}
	Arrays.sort(a);
	int result =0;
	int helper = 0 ;
	boolean gotit = false ;
	for(int i =0 ; i<=12 ; i++){
		if(helper>=k){
		gotit = true ;
			break;
		}
		result ++;
if(12-1-i>=0)
		helper+=a[12-1-i];
		
	}
	if(gotit)
System.out.println(result);
	else
		System.out.println("-1");
}
}
