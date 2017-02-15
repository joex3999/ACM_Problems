

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_466A_CheapTravel {
public static void main (String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m =Integer.parseInt(st.nextToken());
	int a =Integer.parseInt(st.nextToken());
	int b =Integer.parseInt(st.nextToken());
int result = 0  ; 
while(n>=m){
	n = n-m ;

	result +=b;

}

while(n>0){
	n--;
	result+=a;
}
System.out.println(result);

}
}
