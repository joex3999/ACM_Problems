
//
//it passed all the tests in the problem and udebug but it still got wrong answer 
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_594_1Little2Little3LittleEndians {
	static int Convert(int n ){
		int result = 0 ;
		for(int i=0 ; i<4;i++){
			int msk = (1<<8)-1;
			
			int temp = n&msk;
			
			n=(n>>8);
			
			result = result | temp;
		
			if(i!=3)
			result = (result<<8);
		}
		return result;
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String s = null;
boolean first = true ;
while((s=br.readLine())!=null){
	int n = Integer.parseInt(s);
	int g = Convert(n);
if(first){
	System.out.printf("%s converts to %s",n,g);
	first = false ;
}else
	System.out.printf("\n%s converts to %s",n,g);
	
}
}
}
                                                     