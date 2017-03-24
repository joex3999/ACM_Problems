import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class XCF_740A_AlyonaAndCopybooks {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		BigInteger a = new BigInteger(""+Integer.parseInt(st.nextToken()));
		BigInteger b = new BigInteger(""+Integer.parseInt(st.nextToken()));
		BigInteger c = new BigInteger(""+Integer.parseInt(st.nextToken()));
		int addition = 0 ;
	BigInteger rubles = new BigInteger(""+0);
	
		while (true) {
			if ((n+addition) %4 == 0)
				break;
			
			addition++;
		}



		while (addition > 0) {
			//c < 3 * a  	(c < b + a)
			if (addition >= 3 && (c.compareTo(a.multiply(new BigInteger(""+3)))<0&& (c.compareTo(b.add(a)))<0)) {
				addition -= 3;
				rubles = rubles.add(c);
			} else {
				if (addition >= 2 && b.compareTo(a.multiply(new BigInteger(""+2)))<0) {
					addition -= 2;
					rubles = rubles.add(b);
				} else {
				
					addition -= 1;
					rubles =rubles.add(a);
				
				}
			}
		}

		
		System.out.println(rubles);
	}
}