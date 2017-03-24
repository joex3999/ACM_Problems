
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class HR_BonAppetit {
public static void main(String[]args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int k = Integer.parseInt(st.nextToken());
	st = new StringTokenizer(br.readLine());
	int AnnaShouldPay  = 0 ;

	for(int i =0 ; i<n;i++){
		if(i==k){
			st.nextToken();
			continue;
	
		}AnnaShouldPay+=Integer.parseInt(st.nextToken());
	
	}
	AnnaShouldPay/=2;
	int check  = Integer.parseInt(br.readLine());
	if(check==AnnaShouldPay)
		System.out.println("Bon Appetit");
	else
		System.out.println((check-AnnaShouldPay));
		
	
}
}
