

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//Wrong !!!
public class UVA_11003_Boxes_Alternative {
public static class Pair{
	int W ;
	int L;
	public Pair(int W,int L)
{
		this.W= W ;
		this.L = L;
		}
}
	public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
	while(true){
	int n = Integer.parseInt(br.readLine());
	if(n==0)
		break;
	Pair[] arr = new Pair[n];
	StringTokenizer st = new StringTokenizer("");
	for(int i =0 ; i<n;i++){
	st = new StringTokenizer(br.readLine());
		arr[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	}
	
	int max = Integer.MIN_VALUE;
	for(int i =0 ; i<n;i++){
		int minload = arr[i].L;
		int currentVal = 1 ;
		for(int j = i+1 ; j<n;j++){
			int lload = arr[j].L;
			int weight = arr[j].W;
			if(minload-weight>=0){
				currentVal++;
				minload= Math.min(minload-weight,lload);
			}
		}
		max = Math.max(currentVal, max);
	}
sb.append(max+"\n");
}
sb.replace(sb.length()-1, sb.length(),"");
System.out.println(sb.toString());
}
}
