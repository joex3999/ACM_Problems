

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
// Taken from : http://sound-system-79.blogspot.com.eg/2015/04/uva-939-genes.html
// 
public class XUVA_939_Genes {
	static class Pair {
		String father;
		String mother;

		public Pair(String f, String s) {
			father = f;
			mother = s;

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> genes = new HashMap<String, String>();
		HashMap<String, Pair> parents = new HashMap<String, Pair>();
		HashSet<String> names = new HashSet<String>();
 ArrayList<String>arrange = new ArrayList<String>(); 
 StringBuilder sb = new StringBuilder();
 boolean firsst = true ;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String first = st.nextToken();
			if(!names.contains(first)){
				names.add(first);
				arrange.add(first);
			}
			String second = st.nextToken();
			if(!names.contains(second)&&!second.equals("dominant")&&!second.equals("recessive")&&!second.equals("non-existent")){
				names.add(second);
				arrange.add(second);
			}
			boolean in = true ;
			switch(second){
			case "dominant" :genes.put(first, "dominant"); break; 
			case "recessive":genes.put(first, "recessive");break ; 
			case "non-existent":genes.put(first, "non-existent");break ;
			default : in = false ; break;
			}
			if(!in){
				if(parents.containsKey(second)){
					Pair temp = parents.get(second);
					parents.put(second, new Pair(temp.father,first));
					String one = genes.get(temp.father);
					String secondo = genes.get(first);
					if((one.equals("dominant")&&secondo.equals("dominant"))||(one.equals("dominant")&&secondo.equals("recessive"))||(one.equals("recessive")&&secondo.equals("dominant"))){
						genes.put(second, "dominant");
					}else{
						if((one.equals("recessive")&&secondo.equals("recessive"))||one.equals("dominant")||secondo.equals("dominant")){
							genes.put(second, "recessive");
						}else{
							genes.put(second, "non=existent");
						}
					}
				}else{
					parents.put(second, new Pair(first,"temp"));
				}
			}
			
		}
		
		Collections.sort(arrange);
		for(String g :arrange){
			if(firsst){
			String format = String.format("%s %s",g,genes.get(g));
			firsst = false ;
			sb.append(format);
			}else {
				String format = String.format("\n%s %s",g,genes.get(g));
			sb.append(format);	
			}
			}
		
		System.out.println(sb.toString());
	}
}
