

import java.util.Arrays;
import java.util.Scanner;



public class CF_155b_Combinationn {
	static class Pair implements Comparable {
		int x;

		int y;

		public Pair(int x, int y) {
			this.x = x;

			this.y = y;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			if (p.y == this.y) {
				if (p.x == this.x) {
					return 0;
				} else {
					if (this.x < p.x) {
						return 1;
					}
					if (this.x > p.x) {
						return -1;
					}
				}
			}
		
				if (this.y < p.y) {
					return 1;
				}
				if (this.y > p.y) {
					return -1;
				}
				return 0;
			}

		

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pair[] arr = new Pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
int result =0;
int count = 1 ;
for(int i =0 ;i<n&&count>0;i++){
	result+= arr[i].x;
	count--;
	count+= arr[i].y;
	}
System.out.println(result);
	
	}
}
