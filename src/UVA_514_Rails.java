

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class UVA_514_Rails {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		StringBuilder sb = new StringBuilder();
		boolean first = true ;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			String s = null;
		if(!first)sb.append("\n");
			while (!(s = br.readLine()).equals("0")) {
				StringTokenizer st = new StringTokenizer(s);
				Stack stack = new Stack();
				int now = Integer.parseInt(st.nextToken());
				for(int i =1; i<=n;i++){
					stack.push(i);
				
				
					while(!stack.isEmpty()&&(int)stack.peek()==now){
						stack.pop();
						if(st.hasMoreTokens())
							now = Integer.parseInt(st.nextToken());
					}
				}
				if(first){
			if(stack.isEmpty()){
				sb.append("Yes");
			}else{
			sb.append("No");
			}
			
				first = false ;
				}else{
				if(stack.isEmpty()){
					sb.append("\nYes");
				}else{
				sb.append("\nNo");
				}
		
			}
			
			}
	
		}
	
	System.out.println(sb.toString());
	System.out.println();}
}
