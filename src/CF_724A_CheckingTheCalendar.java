
import java.io.*;
import java.util.*;
public class CF_724A_CheckingTheCalendar {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String first = br.readLine();
	String second = br.readLine();
	String sa = "saturday";
	String su = "sunday";
	String mo = "monday";
	String tu = "tuesday";
	String wed = "wednesday";
	String thur = "thursday";
	String fri = "friday";
	boolean yes = false ;
	if(first.equals(sa)&&(second.equals(sa)||second.equals(mo)||second.equals(tu)))
		yes = true ;
	if(first.equals(su)&&(second.equals(su)||second.equals(tu)||second.equals(wed)))
		yes = true ;
	if(first.equals(mo)&&(second.equals(mo)||second.equals(wed)||second.equals(thur)))
		yes = true ;
	if(first.equals(tu)&&(second.equals(tu)||second.equals(thur)||second.equals(fri)))
		yes = true ;
	if(first.equals(wed)&&(second.equals(wed)||second.equals(fri)||second.equals(sa)))
		yes = true ;
	if(first.equals(thur)&&(second.equals(thur)||second.equals(sa)||second.equals(su)))
		yes = true ;
	if(first.equals(fri)&&(second.equals(fri)||second.equals(su)||second.equals(mo)))
		yes = true ;
	
	if(yes)
		System.out.println("YES");
	else 
		System.out.println("NO");
	
}
}
