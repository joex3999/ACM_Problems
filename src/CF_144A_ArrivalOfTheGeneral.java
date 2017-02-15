

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_144A_ArrivalOfTheGeneral {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	st = new StringTokenizer(br.readLine());
	int [] arr = new int [n];
  for(int i =0 ; i<n;i++){
	  arr[i] = Integer.parseInt(st.nextToken());
	  
  }
  int min =(int) Double.POSITIVE_INFINITY ;
  int max = -1 ;
  int minindex = 0 ;
  int maxindex = 0 ;
  for(int i =0 ;i<n;i++){
	  if(arr[i]>max){
		  max = arr[i];
		  maxindex = i ;
	  }
	  if(arr[i]<=min){
		  min=arr[i];
		  minindex=i;
	  }
  }
  int result = 0 ;
  if(maxindex>=minindex){
	  result = -1 ;  // in case they are common in 1 switch
  }
  result += maxindex + (n-minindex-1);
  System.out.println(result);
}
}
