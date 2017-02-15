

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_750_8Queens {
	 static int [] queens = new int [8];
	 static int lineCounter = 0 ;
	 static int y ;
	 static int x ;
	 
	 static boolean valid (int r , int c ){
		 for(int i =0 ;i<c;i++){
			 if(queens[i]==r)
				 return false ;
		 }
		 return true ;
	 }
	 
	static void backtrack(int n){
		if(n==8&&queens[y]==x){
			System.out.printf(" %2d       %d",++lineCounter,queens[0]+1);
			for(int j = 1 ;j <8;j++) System.out.printf(" %d",queens[j]+1);
			
			System.out.printf("\n");
			return ;
		}
		for(int r=0 ; r<8 ; r++){
			if(valid(r,n)){
				queens[n]= r ;
				backtrack(n+1);
			
			}
		}
	}
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 String []temp =br.readLine().split(" ");
  x = Integer.parseInt(temp[0]);
 y = Integer.parseInt(temp[1]);
 lineCounter = 0;
 x--;
 y--;
 
 System.out.printf("SOLN       COLUMN\n");
 System.out.printf(" #      1 2 3 4 5 6 7 8\n\n");
 backtrack(0);
}
}
