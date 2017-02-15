

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// backtracking to trace the answer . could not do it maby change approach to buttom up DP ?
public class XUVA_10130_SuperSale {
 static Pair[] arr ;
 static int preCompute[][];
	public static class Pair{
		int value ;
		int weight ;
		public Pair(int a ,int b ){
			value = a ;
			weight = b ;
		}
	}
	
	public static int KnapSack(int id , int weight){

		
	if(weight==0)
		return 0;
	if(id==arr.length)
	return 0 ;
	Pair now = arr[id];
	
	if(preCompute[id][weight]!=-1){

	return preCompute[id][weight];}
	if(now.weight>weight)
		return KnapSack(id+1,weight);
	
	return preCompute[id][weight]= Math.max(KnapSack(id+1,weight), now.value+KnapSack(id+1,weight-now.weight));
	
	}
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
int T = Integer.parseInt(br.readLine());
while(T-->0){
	int n = Integer.parseInt(br.readLine());
 arr = new Pair[n];
for(int i =0 ; i<n;i++){
	StringTokenizer st = new StringTokenizer(br.readLine());
	arr[i] = new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
}	
 preCompute = new int[1005][35];
for(int i=0 ; i<1005;i++){
	Arrays.fill(preCompute[i], -1);
}

int KnapSackValue = 0 ;
int G = Integer.parseInt(br.readLine());
for(int i =0 ; i<G;i++){
	int weight = Integer.parseInt(br.readLine());
	int valuenow = KnapSack(0,weight);
	KnapSackValue+=valuenow;
	
}
sb.append(KnapSackValue+"\n");
}
sb.replace(sb.length()-1, sb.length(), "");
System.out.println(sb.toString());
}
}
