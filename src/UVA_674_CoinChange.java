

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVA_674_CoinChange {
	static int [][]result ;
	static int [] coins = {50,25,10,5,1};
	public static int ways (int type , int V){

		if(V==0)
			return 1 ;
		if(V<0)
			return 0 ;
		if(type == 5)
			return 0;
			if(result[type][V]!=-1){
			
			return result[type][V];}
		//System.out.println("in");
		return result[type][V]=ways(type+1,V) + ways(type,V-coins[type]);
		
	}
public static void main(String[]args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String n = null ; 
	result = new int[6] [7600];
	for(int i =0 ; i<6;i++){
		Arrays.fill(result[i],-1);
	}
	ways(0,7489);
	while((n=br.readLine())!=null){
		int now = Integer.parseInt(n);
		System.out.println(ways(0,now));
	}
}
}
