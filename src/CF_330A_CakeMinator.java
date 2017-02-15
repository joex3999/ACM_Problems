

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_330A_CakeMinator {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());
boolean [][]cakes = new boolean [a][b];
boolean [][]berr = new boolean [a][b];
int result = 0;
for(int i =0 ;i<a;i++){
	st = new StringTokenizer(br.readLine());
	String g = st.nextToken();
	for(int j =0 ;j<b;j++){
		char s = g.charAt(j);
	
		if(s=='S'){
			berr[i][j]=true;
			cakes[i][j]=false;
	
		}else{
			berr[i][j]=false;
		cakes[i][j]=true;
		}
	}
}
//rows first 
for(int i=0 ; i <a ;i++){
	
	boolean atleast = false ;
	boolean berrr = false ;
	for(int j=0;j<b;j++ ){
		if(cakes[i][j]){
			atleast = true ;
			}
		if(berr[i][j]){
		
			berrr=true;}
	}
	if(atleast&&!berrr){
	result+=b ;
	for(int k =0;k<b;k++){
		cakes[i][k]=false;
	}
	}
}

// columns next 
for(int j = 0 ; j<b;j++){
	boolean atleast = false ;
	boolean berrr = false ;
	for(int i=0 ;i<a;i++){
		if(cakes[i][j]){
			atleast=true ;
			}
		if(berr[i][j]){
			berrr=true;}
	}
	
	if(atleast&&!berrr){

	for(int g = 0 ; g<a;g++){
		if(cakes[g][j]){
			result+=1;
		}
	}
	}
}

System.out.println(result);
}
}
