

import java.util.Scanner;

public class MahersTest {
public static void main(String []args){
	Scanner sc = new Scanner(System.in);
	String gg = sc.nextLine();
	int x ;
	char y;
	for(int i = 0 ; i<gg.length();i++){
	x	= gg.charAt(0)+20;
		y = (char) x	;
		System.out.print(y);
		gg.substring(2);
	}
}
}
