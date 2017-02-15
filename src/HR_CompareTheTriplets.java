
import java.io.*;
import java.util.*;
public class HR_CompareTheTriplets {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer Al = new StringTokenizer(br.readLine());
	StringTokenizer Bo = new StringTokenizer (br.readLine());
	int A= 0 ;
	int B = 0 ;
	for(int i=0 ;i<3;i++){
		int first = Integer.parseInt(Al.nextToken());
		int second = Integer.parseInt(Bo.nextToken());
		if(first==second)
			continue ;
		if(first<second)
			B++;
		if(first>second)
			A++;
	}
	System.out.println(A + " " + B);
}
}
