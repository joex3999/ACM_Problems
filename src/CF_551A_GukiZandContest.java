

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_551A_GukiZandContest {
public static void main(String[]args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
int [] arr = new int [n];
StringTokenizer st = new StringTokenizer (br.readLine());
for(int i =0 ; i<n;i++){
	arr[i]=Integer.parseInt(st.nextToken());
	
}

for(int i =0 ; i<n ; i++){
	int counter = 1;
	for(int j =0 ;j<n;j++){
		if(arr[i]<arr[j]){
			counter ++ ;
		}
	}
	
	if(i==0){
		System.out.print(counter);
	}else{
System.out.print(" "+counter);
}
	
}


}
}
