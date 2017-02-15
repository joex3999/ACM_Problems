
import java.util.*;
import java.io.*;
public class CF_732A_BuyAShovel {
public static void main(String[]args)throws Exception{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int k = Integer.parseInt(st.nextToken());
int r = Integer.parseInt(st.nextToken());
int i =0 ;
	for( i=1 ; i<=10;i++){
	double number = i*k;
	double AfterN = (number-r)/10;
	double After = number/10;
	if(AfterN-(int)AfterN==0)
		break;
	if(After -(int)After==0)
		break;
	}
	System.out.println(i);
}
}
