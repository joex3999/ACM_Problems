
import java.util.*;
import java.io.*;
public class TC_ABBAdiv1_canObtain {
public static void main(String[]args)throws Exception{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = br.readLine();
String g = br.readLine();
	String x = canObtain(s,g);
	System.out.println(x);
	
}

public static  String canObtain(String x , String y) {
String moding = y ;
boolean truee = false ;
	while(!moding.equals(x)&&moding.length()>0){
		System.out.println(moding);
		if(moding.charAt(moding.length()-1)=='A')
		moding = moding.substring(0, moding.length()-1);
		else
			if(moding.charAt(moding.length()-1)=='B')
				moding = reverse(moding.substring(1, moding.length()));
	if(moding.equals(x))
		truee = true ;
	
	}
	
	if(truee)
		return "Possible";
		else 
			return "Impossible";

}
//
//public static String solve(String x , String y) {
//	if(x.length()>=y.length()&&!x.equals(y))
//		return "Impossible";
//	if(x.equals(y))
//		return "Possible";
//	
//	String first =solve(reverse(x+"B"),y);
//	String second = solve(x+"A",y);
//	if(first.equals("Possible")|| second.equals("Possible"))
//		return "Possible";
//		else
//			return "Impossible";
//}

public static String reverse(String y ){
	String result = "";
	for(int i =0 ; i<y.length();i++){
		result = y.charAt(i)+result; 
	}
	return result ;
}


}
