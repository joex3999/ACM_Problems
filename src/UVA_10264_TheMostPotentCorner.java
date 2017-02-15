

import java.io.BufferedReader;
import java.io.InputStreamReader;
// Challenging one .!!!
// my Favorite yet .. solved it Fast and AC verdict from first Time <3 <3 <3 <3 //2/7/2017 propably not my favorite anymore
public class UVA_10264_TheMostPotentCorner {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = null ;
StringBuilder sb = new StringBuilder ();
boolean first = true ;

while((s=br.readLine())!=null){
	int n = Integer.parseInt(s);
	int lines = (int)Math.pow(2, n);
	int [] list = new int [lines];
	
	for(int i =0 ; i<lines;i++){
		list[i] = Integer.parseInt(br.readLine());
	}
	int [] potencies = new int [lines];
	for(int i =0 ; i <lines;i++){
		int xor = 1 ;
		int temp = 0 ; 
		for(int j =0 ; j<n; j++){
			temp+=list[i^xor];
		xor<<=1;
		}
		potencies[i]= temp;
	}
	
	int max = (int) Double.NEGATIVE_INFINITY;
	for(int i =0 ; i <lines;i++){
		int potency = potencies[i];
		int xor = 1 ;
		for(int j = 0 ;j<n;j++){
			int neighbourpoten = potencies[i^xor];
			if(neighbourpoten+potency>max){
				max = neighbourpoten + potency;
			}
			xor<<=1;
		}
	}
if(first){
	first = false ;
	sb.append(max);
}else{
	sb.append("\n"+max);
}
	
}
System.out.println(sb.toString());

}
}
