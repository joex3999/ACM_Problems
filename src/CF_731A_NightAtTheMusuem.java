
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CF_731A_NightAtTheMusuem {
public static void main(String[] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
char[] arr =  br.readLine().toCharArray();
char now = 'a';

int answer = 0 ;
for(int i =0 ; i<arr.length;i++){

	answer+=Math.min(Math.abs((now)-(arr[i])),26-Math.abs((now)-(arr[i])));
	now = arr[i];
}
System.out.println(answer);
}
}
