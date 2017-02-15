import java.util.*;
import java.io.*;

public class CF_158B_Taxi {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int numberOf1s = 0;
		int numberOf2s = 0;
		int numberOf3s = 0;
		int result = 0;
		for (int i = 0; i < n; i++) {
			int now = arr[i];
			if (arr[i] == 1) {
				if (numberOf3s > 0){
					numberOf3s--;
					result++;}
				else if (numberOf2s > 0) {
					numberOf2s--;
					numberOf3s++;
				} else {
					if(numberOf1s>0){
						numberOf1s--;
						numberOf2s++;
					}else
						numberOf1s++;
				}

			} else {
				if (arr[i] == 2) {
					if (numberOf2s > 0){
						numberOf2s--;
						result++;}
					else if (numberOf1s > 0) {
						numberOf1s--;
						numberOf3s++;
					} else {
						numberOf2s++;
					}
				} else {
					if (arr[i] == 3) {
						if (numberOf1s > 0){
							numberOf1s--;
							result++;}
						 else {
							numberOf3s++;
						}

					} else {
						result++;
					}
				}
			}
		}
		System.out.println(result+numberOf1s+numberOf2s+numberOf3s);
	}
}
