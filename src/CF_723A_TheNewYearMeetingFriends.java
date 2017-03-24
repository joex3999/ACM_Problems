
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class CF_723A_TheNewYearMeetingFriends {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer (br.readLine());
int first = Integer.parseInt(st.nextToken());
int second = Integer.parseInt(st.nextToken());
int third = Integer.parseInt(st.nextToken());
int min = Integer.MAX_VALUE;
for(int i =1 ; i<=100;i++){
	int value = Math.abs(i-first)+ Math.abs(i-second)+Math.abs(i-third);
min = Math.min(min,value);
}
System.out.println(min);
}
}
