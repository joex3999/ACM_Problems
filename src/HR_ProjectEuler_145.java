

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HR_ProjectEuler_145 {

	static int reverse (String s ){
		String result = "";
			
			for (int i =0 ; i<s.length();i++){
				result = s.charAt(i)+result;
			}
			
			return Integer.parseInt(result);
	}
	static boolean check(int n ){
	String s = "" + n ;
	
	int sol =reverse(s);
	int answer = sol + n ;
	String an = ""+answer;
	boolean increment = true ;
	for(int i =0 ; i<an.length();i++){
		int num = (int)an.charAt(i);

		if(num%2==0){
			increment = false ;
			break;
		}
	}
	if(increment)
		return true ;
	else 
		return false ;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine());
		for (int i = 0; i < g; i++) {
			String s = br.readLine();
			int now = Integer.parseInt(s);
			int result = 0;
	
			for (int j = 0; j < now; j++) {
			
			

				if (check(j)) {
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
