

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MOrtada_1 {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String [] line  = br.readLine().split(" ");
	boolean case1 = false ;// case 1 is x + " number" = "number ;
	boolean case2 = false ; // case 2 is "number" + x = "number";
	boolean case3 = false ;// case 3 is "number" + "number" = x ;
	if(line[0].equals("x")){
		case1= true ;
	}
	if(line[2].equals("x")){
		case2 = true ;
	}
	if(line[4].equals("x")){
		case3 = true ;
	}
if(case1){
	int y = Integer.parseInt(line[2]);
	int z = Integer.parseInt(line[4]);
	System.out.println(z-y);
	return ;
}

if(case2){
	int y = Integer.parseInt(line[0]);
	int z = Integer.parseInt(line[4]);
	System.out.println(z-y);
	return ;
}
if(case3){
	int y = Integer.parseInt(line[0]);
	int z = Integer.parseInt(line[2]);
	System.out.println(y+z);
	return;
}
	
	
}
}
