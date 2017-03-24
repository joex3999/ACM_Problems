
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class CF_722A_BrokenClock {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
char[] arr = br.readLine().toCharArray();
StringBuilder sb = new StringBuilder();
boolean firstedited = false ;
boolean secondedited = false ;
if(n==12){

	int first = Character.getNumericValue(arr[0]);
int second =  Character.getNumericValue(arr[1]);
 firstedited = false ;

	if(first!=0||second!=0){
	if(first<0||first>1){
		sb.append(0);
		firstedited = true ; }
	else
		
		sb.append(first);
	
	if(!firstedited&&first==1&&(second>2||second<0)){
		sb.append(0);
		
	}else
		sb.append(second);
	}else{
		sb.append("01");
	}
	sb.append(":");
	
	int third = Character.getNumericValue(arr[3]);
	int fourth = Character.getNumericValue(arr[4]);
	if(third>5||third<0){
		sb.append(0);
	}else
		sb.append(third);
	
	sb.append(fourth);
		
	
	
	
	
}else{
	int first = Character.getNumericValue(arr[0]);
	int second=Character.getNumericValue(arr[1]);
	int third = Character.getNumericValue(arr[3]);
	int fourth = Character.getNumericValue(arr[4]);
	 firstedited = false ;
	if(first>2||first<0){
		sb.append(0);
		firstedited = true ;}
	else
		sb.append(first);
	if(!firstedited && first == 2&&((second>4||second<0)||(first==2&&second==4)))
		sb.append(0);
	else
		sb.append(second);
	
	sb.append(":");
	
	if(third>5||third<0){
		sb.append(0);
	}else
		sb.append(third);
	
	sb.append(fourth);
	
	
}
String ss = sb.toString();

if(ss.substring(0, 2).equals("00")&&n==12){
	if(firstedited){
	 sb.replace(0, 1, "1");
	}else
	if(secondedited)
		sb.replace(1, 2, "1");
}
System.out.println(sb.toString());

}
}
