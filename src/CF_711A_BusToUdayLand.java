

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_711A_BusToUdayLand {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
StringBuilder sb = new StringBuilder();
StringBuilder result = new StringBuilder();
boolean found = false ;
for(int i =0 ; i<n;i++){
	String line = br.readLine();
	StringTokenizer st = new StringTokenizer(line,"| ");
	String first = st.nextToken();
	

	String third = st.nextToken();

	if(first.equals("OO")&&!found){
		result.append("++|"+third+"\n");
	found = true ;
	}else{
		if(third.equals("OO")&&!found){
			result.append(first+"|++\n");
		found = true ;
		}else{
			result.append(line+"\n");
		
		}
	}
}
if(found){
	sb.append("YES\n");
	sb.append(result);
}else{
	sb.append("NO\n");
}
sb.replace(sb.length()-1, sb.length(), "");
System.out.println(sb.toString());
}
}
