import java.io.*;
import java.util.Scanner;

public class CF_282A_Bitpp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();


		int number = 0;
		while (n-- > 0) {
			char[] arr = sc.next().toCharArray();

			if (arr[1] == '+') {
				number++;
			} else {
				number--;
			}
		}
		System.out.println(number);
	}
}
