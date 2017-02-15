

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// without begin it wont make a difference .  because it is as if you just cut off one cycle of the binary search iterations 
public class CF_165B_BurningMidNightOil {
	public static int valid (int num ,int divisor,int lines ){
		int numSoFar = 0; 
		for(int i=0 ; i<700;i++){
	
			int temp =(int) num/(int)Math.pow(divisor, i);
	
			if(temp!=0){
				numSoFar+=temp;
			}else{
				break;
			}
		}
	
	if(numSoFar>=lines){
		return 1 ;
	}
	return 0 ;
	
	}
	
	
	
   static public int binarySearch(int begin,int n,int divisor) 
    {
         int low = begin;
         int high = n;
          int middle = 0;
         while(high > low) {
 
              middle = (low + high) / 2;
          
             if(valid(middle,divisor,n)==0) {
                 low = middle+1;
             }
             if(valid(middle,divisor,n)==1 ){
                 high = middle;
             }
    
             if(low==high){
            	 break;
             }
        }
         
        return high;
   }
public static void main(String[]args)throws Exception{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int n = Integer.parseInt(st.nextToken());
int div = Integer.parseInt(st.nextToken());
System.out.println(binarySearch(n/2,n,div));
}
}
