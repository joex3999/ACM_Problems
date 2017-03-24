

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//https://omarsebres.wordpress.com/2012/07/08/11413-fill-the-containers/
// can't grasp the idea to solve this problem with
public class XQUVA_11413_FillTheContainers {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		while ((s = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int [] containers = new int [m];
			int [] vessels = new int [n];
		
			for(int i =0 ; i<n;i++){
				vessels[i]= Integer.parseInt(st.nextToken());
			}
			Arrays.sort(vessels);
		if(m>=n){
			System.out.println(vessels[vessels.length-1]);
			return ;
		}
			
			for(int i=0 ; i<m;i++){
				containers[i] = vessels[vessels.length-1-i];
			}
			
			for(int i =m ;i<vessels.length;i++){
				for(int j =0 ; j<containers.length;j++){
					
				}
			}
			
				
		}
	}
}
