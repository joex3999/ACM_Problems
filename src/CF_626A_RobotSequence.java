

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF_626A_RobotSequence {
	
	static class Pair{
		int x ;
		int y ;
		public Pair(int a ,int b ){
			x = a ;
			b = y ;
		}
		
		public  void increaseX(){
			x++;
		}
		public void increaseY(){
			y++;
		}
		public void decreaseX(){
			x--;
		}
		public void decreaseY(){
			y--;
		}
		
	}
	
	
	static Pair shift(String s ,Pair p){
		Pair result = p;
		for(int i =0 ; i<s.length();i++){
			switch(s.charAt(i)){
			case'U' :result.increaseY();;break;
			case'D': result.decreaseY();;break;
			case'L':result.decreaseX();;;break;
			case'R':result.increaseX();;break;
			}
		}
	return result ;
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	String s = br.readLine();
	int result = 0;
	

	for(int i =0 ; i <n ; i++){
		for(int j =i+2 ;j<n+1;j++){
			Pair temp = shift(s.substring(i, j),new Pair(0,0));
			if(temp.x==0 && temp.y==0){
				result ++ ;
			}
		}
	}


System.out.println(result);
}
}
