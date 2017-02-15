
import java.util.*;
import java.io.*;
public class CF_AmmanCPC_F_Exchange {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	StringBuilder sb = new StringBuilder();
	while(T-->0){
		String s = br.readLine();
		char[] arr = s.toCharArray();
		ArrayList<Character> sorted = new ArrayList<Character>();
		HashSet noDup = new HashSet();
		for(int i =0 ;i<arr.length;i++)
		{
			if(!noDup.contains(arr[i]))
				sorted.add(arr[i]);
		}
	Collections.sort(sorted);
	char min = arr[0];
	char replaced = 'a';
		for(int i =0 ; i<sorted.size();i++)
		{
			if(arr[i]!=sorted.get(i)){
				min = sorted.get(i);
				replaced = arr[i];
				break;
			}	
			
		}
		
		 for(int i =0 ;i<arr.length;i++){
			 char now = arr[i];
			 if(now==replaced)
				 arr[i] = min;
		if(now == min)
			arr[i] = replaced;
		
		 sb.append(arr[i]);
		 }
		 
	
			
		 sb.append("\n");
	}
	
	System.out.println(sb.replace(sb.length()-1, sb.length(), "").toString());
}
}
