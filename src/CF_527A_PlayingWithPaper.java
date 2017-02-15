

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// not done 
public class CF_527A_PlayingWithPaper {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer (br.readLine());
long A = Long.parseLong(st.nextToken());
long B = Long.parseLong(st.nextToken());
int result = 0;
while(A-B>0){
	result += A / B;
    A %= B;
    long temp = A ;
    A = B ;
    B = A ;
}
System.out.println(result);
}
}
