	
	
	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
	public class CF_501A_Contest {
	public static void main(String[]args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int misha = Math.max((3*a)/10, a-(a/250)*c) ;
	    int vasya = Math.max((3*b)/10, b-(b/250)*d) ;
	    if(misha==vasya){
	    	System.out.println("Tie");
	    }if(misha>vasya){
	    	System.out.println("Misha");
	    }if(vasya>misha){
	    	System.out.println("Vasya");
	    }
	}
	}
