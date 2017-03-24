
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class HR_MarsExploration {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
char[]arr = br.readLine().toCharArray();
int Wrong = 0 ;
for(int i=0 ; i<arr.length;i+=3){
	if(arr[i]!='S')
		Wrong++;
	if(arr[i+1]!='O')
		Wrong++;
	if(arr[i+2]!='S')
		Wrong++;
}
System.out.println(Wrong);
}
}
