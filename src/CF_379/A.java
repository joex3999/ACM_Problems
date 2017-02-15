package CF_379;

import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int A = 0;
		int D = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i)=='D')
				D++;
			else
				A++;
		}
		if(A==D)
			System.out.println("Friendship");
		else
			if(A>D)
				System.out.println("Anton");
			else System.out.println("Danik");
	}
}
