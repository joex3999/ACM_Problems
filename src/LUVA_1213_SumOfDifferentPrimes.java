

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LUVA_1213_SumOfDifferentPrimes {
	static int size ;
	static int [] Primes;
	static int [][] memset;
	private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}
//	public static int solve(int index,int size ,int number){
//		
//	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int x = 22 ;
	int number = 0 ;
	Primes = new int [188];
	int j = 0 ;
	for(int i=0;i<=1120;i++){
if(isPrime(i)){
	Primes[j] = i ;
	j++;
}
	}


	while(true){
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
size = Integer.parseInt(st.nextToken());
	memset = new int [190][1125];
	for(int i =0 ; i <190;i++)
		Arrays.fill(memset[i], -1);
//	int result = solve(0,k,n);
	}
}
}
