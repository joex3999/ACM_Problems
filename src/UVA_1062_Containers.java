

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
// proud of this solution altho it was sort of easy 
// amazing run time  0.05 of a second
public class UVA_1062_Containers {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		int casee = 1;
		StringBuilder sb = new StringBuilder();
		boolean first = true;
		while (!(s = br.readLine()).equals("end")) {
			ArrayList<Stack> list = new ArrayList<Stack>();
			String line = s;
			Stack temp = new Stack();
			temp.push(line.charAt(0));
			list.add(temp);
			for (int i = 1; i < line.length(); i++) {
				char now = line.charAt(i);
				boolean found = false;
				for (int j = 0; j < list.size(); j++) {
					Stack sta = list.get(j);
					if (now <= (char) sta.peek()) { // might be here
						sta.push(now);
						found = true;
						break;
					}

				}
				if (!found) {
					Stack temp2 = new Stack();
					temp2.push(now);
					list.add(temp2);
				}
			}
			
if(first){
	String format = String.format("Case %s: %s",casee++,list.size());
	sb.append(format);
	first = false ;
}else{
	String format = String.format("\nCase %s: %s",casee++,list.size());
	sb.append(format);
}
		}
		System.out.println(sb.toString());
	}
}
