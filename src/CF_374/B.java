package CF_374;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	StringBuilder sb = new StringBuilder();
	helper [] arr = new helper [n];

	for(int i =0 ; i<n;i++){
		arr[i] = new helper(br.readLine());

	}
	String Password = br.readLine();
	int passwordL = Password.length();
Arrays.sort(arr);

int worstTime = 1;
int bestTime = 1;
boolean first = true ;
boolean oneTime = true ;
int index = Integer.MAX_VALUE ;

for(int i =0 ; i<n;i++){

	if(arr[i].x.length()<=passwordL){
		worstTime++;
	}
	if(arr[i].x.length()<passwordL){
	bestTime++;	
	}
	if(arr[i].x.length()==passwordL)
		index = Math.min(index, i);
	
	if(!first){
	if(arr[i].x.length()<passwordL&&i%m==0)
		bestTime+=5;
	if(arr[i].x.length()<=passwordL&&i%m==0)
		worstTime+=5;
	}else{
		first = false ;
	}
	
	
	
}

if(index%m==0&&index!=0)
	bestTime+=5;
sb.append(bestTime + " " + (worstTime-1));
System.out.println(sb.toString());
}
public static class helper implements Comparable{
	String x ;
	public helper(String g){
		x = g ;
	}
	@Override
	public int compareTo(Object arg0) {
		String o = ((helper)arg0).x;
		if(x.length()>o.length())
			return 1 ;
	
			
		if(x.length()<o.length())
			return -1 ;
	return 0 ;}
}
}
