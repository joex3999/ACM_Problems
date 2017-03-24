
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class HR_CamelCase {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	char[] arr = br.readLine().toCharArray();
	int answer = 1 ;
	
	for(int i =1 ; i<arr.length;i++){
	int value = arr[i];
	
	if(value>=65&&value<=90)
		answer++;
	}
	
	System.out.println(answer);
}
}
