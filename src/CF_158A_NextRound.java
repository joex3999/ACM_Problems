import java.util.*;
import java.io.*;
public class CF_158A_NextRound {
public static void main(String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int n = Integer.parseInt(st.nextToken());
int k = Integer.parseInt(st.nextToken());
st = new StringTokenizer(br.readLine());
int []arr = new int [n];
int Pos = 0 ;
for(int i =0 ; st.hasMoreTokens();i++){
	arr[i] = Integer.parseInt(st.nextToken());
if(i+1==k){
	Pos = arr[i];
}
}

int result = 0 ;
for(int i =0 ; i <n;i++){
	if(arr[i]>0 && arr[i]>=Pos)
		result++;
}
System.out.println(result);
}
}
