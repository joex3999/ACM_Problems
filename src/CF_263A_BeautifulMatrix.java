

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_263A_BeautifulMatrix {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	StringTokenizer st ;
int xpos =0;
int ypos =0;
boolean found = false ;
for(int i =0 ; i <5 ; i++){
	st = new StringTokenizer(br.readLine());
	for(int h=0 ; h<5;h++){
		int gg = Integer.parseInt(st.nextToken());
		if(gg==1){
			xpos=h;
			ypos=i;
		found = true ;	
			break;
		}
	}
if(found){
	break;
}
}

int xStep = Math.abs(2-ypos);
int yStep = Math.abs(2-xpos);
System.out.println(xStep+yStep);

}
}
