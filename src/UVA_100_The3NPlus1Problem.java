

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_100_The3NPlus1Problem {
	static public int func(int g ){
		ArrayList<Integer> temp = new ArrayList<Integer> ();
		temp.add(g);
	while(g!=1){
		if (g%2!=0){
			g = 3*g+1;
		}else{
			g = g/2;
		}
	temp.add(g);
	}
	return temp.size();
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String s =null ;
	boolean first = true ;
	StringBuilder sb = new StringBuilder();
	while((s=br.readLine())!=null){
	StringTokenizer st = new StringTokenizer(s);
	
	int a = Integer.parseInt(st.nextToken());
	int b = Integer.parseInt(st.nextToken());
	int max = func(a) ;
	int f = Math.max(a, b);
	int h = Math.min(a, b);
	for(int i = h ; i<=f ; i++){
		max = Math.max(max, func(i));
	}
	if(first){
	
		sb.append(a + " " + b + " "+max);
	first = false ;
	}else{
		sb.append("\n"+a+" "+b+" "+max);
	}
	

	
}
	System.out.println(sb.toString());
}
}
