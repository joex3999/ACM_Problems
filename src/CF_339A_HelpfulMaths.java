import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class CF_339A_HelpfulMaths  {

public static void main(String[] args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine(),"+");
	ArrayList<Integer> x = new ArrayList<Integer>();
while(st.hasMoreTokens()){
	x.add(Integer.parseInt(st.nextToken()));
}
Collections.sort(x);
StringBuilder sb = new StringBuilder();
sb.append(x.get(0));
for(int i=1 ; i<x.size();i++){
	sb.append("+"+x.get(i));
}
System.out.println(sb.toString());
}
}