

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_489B_BerSUBall {
public static void main(String []args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int [] boys = new int [n];
	StringTokenizer st = new StringTokenizer(br.readLine());
	for(int i =0 ; i<n;i++){
		boys[i] = Integer.parseInt(st.nextToken());
		
	}
	
	int m = Integer.parseInt(br.readLine());
	int [] girls = new int [m];
	st = new StringTokenizer(br.readLine());
	for(int i =0 ; i <m;i++){
		girls[i] = Integer.parseInt(st.nextToken());
	}
	Arrays.sort(girls);
Arrays.sort(boys);
int max = Math.max(m, n);
int b = 0 ;
int g = 0 ;
int result = 0 ;
for(int i =0 ; i <max;i++){
	if(b>=n)
		break;
	if(g>=m)
		break;
	int boy = boys[b];
	int girl = girls [g];

	
if(Math.abs(boy-girl)<=1){
	result++;
	b++;
	g++;
}else{
	if(boy>girl)
		g++;
	else
		if(girl>boy)
		b++;	
}
}
System.out.println(result);
}
}
