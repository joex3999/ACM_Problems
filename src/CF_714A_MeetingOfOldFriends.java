

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class CF_714A_MeetingOfOldFriends {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	BigInteger l1 = new BigInteger(st.nextToken());
	BigInteger r1 = new BigInteger(st.nextToken());
	BigInteger l2 = new BigInteger(st.nextToken());
	BigInteger r2 = new BigInteger(st.nextToken());
	BigInteger k = new BigInteger(st.nextToken());
	

BigInteger L1 = l1.compareTo(l2)==1?l2:l1;
	BigInteger R1 = r1.compareTo(r2)==1?r2:r1;
	BigInteger L2 = l1.compareTo(l2)==1?l1:l2;
	BigInteger R2 = r1.compareTo(r2)==1?r1:r2;

	//case 1 
	 BigInteger answer = new BigInteger("0") ;
	if(R1.compareTo(L2)==-1){

	}
	//case 2 
	if(R1.compareTo(L2)>=0&&L1.compareTo(L2)==-1){

	answer = R1.subtract(L2).add( new BigInteger("1"));

		if(k.compareTo(L2)>=0&&k.compareTo(R1)<=0){
	
		answer = answer.subtract(new BigInteger("1"));
	}
	}
	//case 3 
	if(R1.compareTo(L2)>=0&&L1.compareTo(L2)>=0&&R1.compareTo(R2)<=0&&L1.compareTo(R2)<=0){
		answer= R1.subtract(L1).add(new BigInteger("1"));
		if(k.compareTo(L1)>=0&&k.compareTo(R1)<=0)
			answer = answer.subtract(new BigInteger("1"));
	}
	//case 4 
	if(L1.compareTo(R2)>0){
		
	}
	System.out.println(answer);
}
}
