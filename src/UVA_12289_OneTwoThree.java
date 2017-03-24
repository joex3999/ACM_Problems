	
	
	import java.io.BufferedReader;
import java.io.InputStreamReader;
	
	public class UVA_12289_OneTwoThree {
	public static void main(String []args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int x = Integer.parseInt(br.readLine());
	  while(x-->0){
		  String s = br.readLine();
		  if(s.length()<=3){
		  if((s.charAt(0)=='o' && s.charAt(1)=='n')||(s.charAt(0)=='o' && s.charAt(2)=='e')||(s.charAt(1)=='n' && s.charAt(2)=='e')){
			  System.out.println(1);
			  continue;
		  }
		  if((s.charAt(1)=='w'&&s.charAt(2)=='o')||(s.charAt(0)=='t'&&s.charAt(1)=='w')||(s.charAt(0)=='t'&&s.charAt(2)=='o')){
			  System.out.println(2);
			  continue;
		  }}
		  System.out.println(3);
	  }
	}
	}
