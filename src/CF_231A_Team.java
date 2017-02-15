

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_231A_Team {
public static void main (String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
	int n = Integer.parseInt(br.readLine());
	int counter = 0 ;
     for(int i =0 ; i<n; i ++){
    	 String []s = br.readLine().split(" ");
    	 int x = Integer.parseInt(s[0]);
    	 int y = Integer.parseInt(s[1]);
    	 int z = Integer.parseInt(s[2]);
    	 if((x==1 && y ==1) ||( x==1 && z==1 )||( y ==1 && z==1) ){
    		 counter ++;
    	 }
     }
     
     
     
     System.out.println(counter);
    }
}
