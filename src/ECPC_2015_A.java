
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ECPC_2015_A {
	static int number ;

	static double AllPossible;
	static double Bigger;

	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0){
	    	AllPossible++;
	    
	    	int gg = Integer.parseInt(prefix);
	    	if(gg>number)
	    		Bigger++;
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine());
StringBuilder sb = new StringBuilder();
while(n-->0){
	String num = br.readLine();

	AllPossible = 0 ;
	Bigger = 0 ;
	number = Integer.parseInt(num);
	permutation(num);
	double answer = 1 ;
	boolean first = true  ;
	for(int i=0 ; i<Bigger;i++){
		answer = answer+(1/AllPossible)*answer;
	if(first){
		answer--;
	first=  false ;
	}
	}
	if(Bigger==0)
		answer=0;
	sb.append(String.format("%.9f\n", answer));

}
System.out.println(sb.replace(sb.length()-1, sb.length(), ""));
}
}
