
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class CF_727A_Transformation {
public static void main(String[] args) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	new Stack<Integer>();
	StringTokenizer st = new StringTokenizer(br.readLine());
	int begin = Integer.parseInt(st.nextToken());
	int end = Integer.parseInt(st.nextToken());
	int endf = end;
	String result = "";
	int resultnum = 1 ;
	boolean gotit = false ;
	while(true){
String temp= (""+end) ;
char last = temp.charAt(temp.length()-1);

		if(begin==end){
			gotit= true ;
			break;}
		
		if(end<2)
			break;
			
		resultnum = resultnum+1;
		if(end%2==0)
		{
			end = end/2;
			result = end + " " + result;
			continue ;
		}
		
			if(last=='1'){
			end = end/10;
			result = end + " " +result;
			continue ;
			}else{
				break;
			}
			
			
	}
	
	result = result +endf;
	if(gotit){
		System.out.println("YES");
		System.out.println(resultnum);
		System.out.println(result);
	}else
	{
		System.out.println("NO");
	}

}}
