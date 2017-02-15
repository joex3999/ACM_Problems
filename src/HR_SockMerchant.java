

import java.io.*;
import java.util.StringTokenizer;
public class HR_SockMerchant {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
boolean [] Allsocks = new boolean [101];
StringTokenizer st = new StringTokenizer(br.readLine());
int answer = 0 ; 
for(int i =0 ; i<n;i++){
	int number = Integer.parseInt(st.nextToken());
	if(Allsocks[number]){
	 Allsocks[number] = false ;
	 answer ++;
	}else{
		Allsocks[number]= true ;
	}
}

System.out.println(answer);
}


}
