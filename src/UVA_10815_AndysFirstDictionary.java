

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;



public class UVA_10815_AndysFirstDictionary {
	
	public static void main(String[] args) throws IOException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line, aux;
		HashSet<String> dictionary = new HashSet<String>();
		ArrayList<String> list = new ArrayList<String>();
		int i;
		while ((line = in.readLine()) != null)
		{
			aux = "";
			for (i=0; i<line.length(); i++)
			{
				if (Character.isLetter(line.charAt(i))){
					aux += line.charAt(i);
				}else{
					aux = aux.toLowerCase();
					if (aux.length() > 0){
						dictionary.add(aux);
					}
					aux = "";
				}
			}
			if (aux.length()> 0){
				aux = aux.toLowerCase();
				dictionary.add(aux);
			}
		}
		list.addAll(dictionary);
		Collections.sort(list);
		for (i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
}