

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_478A_InitalBet {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st = new StringTokenizer(br.readLine());
   int c1 = Integer.parseInt(st.nextToken());
   int c2 = Integer.parseInt(st.nextToken());
   int c3 = Integer.parseInt(st.nextToken());
   int c4 = Integer.parseInt(st.nextToken());
   int c5 = Integer.parseInt(st.nextToken());
if(c1==0&&c2==0&&c3==0&&c4==0&&c5==0)
	System.out.println("-1");
else {
if((c1+c2+c3+c4+c5)%5==0)
System.out.println((c1+c2+c3+c4+c5)/5);
else
	System.out.println("-1");
}}}
