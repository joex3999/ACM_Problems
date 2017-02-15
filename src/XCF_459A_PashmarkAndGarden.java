

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// not Done ... it consists of mostly  useless if  conditions
public class XCF_459A_PashmarkAndGarden {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int x1 = Integer.parseInt(st.nextToken());
int y1 = Integer.parseInt(st.nextToken());
int x2 = Integer.parseInt(st.nextToken());
int y2 = Integer.parseInt(st.nextToken());
if(x2>x1 && y2>y1){
	System.out.println(x1 + " " + y2 + " "+ x2 + " " + y1);
}else{
	if(x2==x1 ){
		System.out.println(y2 +" " + y2 +" " + y2 + " "+ x1);
	}else{
		if(x2>x1 && y2==y1){
			System.out.println(x1+" "+x2 + " ");
		}
	}
}

}
}
