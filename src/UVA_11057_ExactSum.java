

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_11057_ExactSum {
	static int []arr;
	static int []arr2;
	static boolean binarySearch(int key){
		int low = 0 ;
		int high = arr.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(arr[mid]==key){
				return true ;
			}
			if(arr[mid]<key){
				low = mid+1 ;
			}
			if(arr[mid]>key){
				high = mid-1;
			}
			
		}
		return false ;
	}
	
	static boolean binarySearch2(int key){
		int low = 0 ;
		int high = arr2.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(arr2[mid]==key){
				return true ;
			}
			if(arr2[mid]<key){
				low = mid+1 ;
			}
			if(arr2[mid]>key){
				high = mid-1;
			}
			
		}
		return false ;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		boolean first = true ;
		while ((line = br.readLine()) != null) {
			if(first){
	
			}else{
				line=br.readLine();
			}
			int n = Integer.parseInt(line);
			StringTokenizer st = new StringTokenizer(br.readLine());
			 arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());

			}

			int m = Integer.parseInt(br.readLine());
			
			
			Arrays.sort(arr);
			int diff =(int) Double.POSITIVE_INFINITY;
			int price1 = 0 ;
			int price2 = 0 ;
			for(int i =0 ;i<n;i++){
				int hold = arr[i];
				int key = m - hold ;
				if(key==hold){
					arr2= new int [n];
					arr2=Arrays.copyOf(arr, n);
					arr2[i]=-1;
					if(binarySearch2(key)){
						
						if(Math.abs(hold-key)<diff){
							price1 = hold ;
							price2 = key ;
							diff = Math.abs(hold-key);
						}
					}
				}else{
				if(binarySearch(key)){
					
					if(Math.abs(hold-key)<diff){
						price1 = hold ;
						price2 = key ;
						diff = Math.abs(hold-key);
					}
				}
			}
				}
		int result1 =Math.min(price1, price2);
		int result2 = Math.max(price1,price2);
		if(first){
	System.out.printf("Peter should buy books whose prices are %s and %s.",result1,result2);
	first = false ;
		}else{
			System.out.printf("\n\nPeter should buy books whose prices are %s and %s.",result1,result2);
		}
		}
	}
}
