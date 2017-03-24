

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
// correct solution : submitted "https://github.com/izharishaksa/UVa-Solution/blob/master/src/datastructures/builtin/Problem10226YES.java" tho ...
//  was tired . 
public class UVA_10226_HardwoodSpecies {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	br.readLine();
while(n-->0){
	String s = null ;
	int total= 0 ;
	HashMap<String,Integer> map = new HashMap<String,Integer>();
	ArrayList<String>list  = new ArrayList<String>();
	while(!(s=br.readLine()).equals("")&&!s.equals("bla")){
		total++;
	
		if(!map.containsKey(s)){
		list.add(s);
			map.put(s, 1);
		}else{
			int val = map.get(s);
			map.remove(s);

			map.put(s, val+1);
		}
	}
	System.out.println(total);
 Collections.sort(list);
 for(String x : list){
double res = (double)map.get(x)*100/total;
	 System.out.printf("%s %.4f\n",x,res);
 }

}
}
}
