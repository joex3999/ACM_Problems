
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;
// Sol : https://github.com/milon/UVa/blob/master/Volume-9/UVa_902.java 
// same approach exactly but gave Runtime verdict ;
public class UVA_902_PasswordSearch{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String str = input.next();
			HashMap<String,Integer> suru = new HashMap<String,Integer>();
			for(int i=0;i<str.length()-n+1;i++){
				String sub = str.substring(i,i+n);
				if(suru.containsKey(sub))
					suru.put(str.substring(i,i+n),suru.get(sub)+1);
				else
					suru.put(str.substring(i,i+n),1);
				}
			Set milon = suru.entrySet();
			Iterator it = milon.iterator();
			String ret = new String();
			int max = Integer.MIN_VALUE;
			while(it.hasNext()){
				Map.Entry k = (Map.Entry)it.next();
				String key = (String)k.getKey();
				int val = (Integer)k.getValue();
				if(val>max){
					max=val;
					ret=key;
					}
				}
			System.out.println(ret);
			}
		}
	}