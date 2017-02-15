

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_990_DivingForGold {
	static int W;
	static int[][] Computed;
	static StringBuilder sb2;
	static Pair[] arr;
	static Pair2[][] parents;
	static int totalTreasure;
	//static int n

	public static class Pair {
		int value;
		int weight;

		public Pair(int a, int b) {
			value = b;
			weight = a;
		}
	}
	public static class Pair2 {
		int value;
		int weight;
		boolean taken ;

		public Pair2(int a, int b,boolean x ) {
			value = b;
			weight = a;
			taken = x ;
		}
	}

	static int KnapSack(int id, int weight) {
		if (id == arr.length)
			return 0;
		if (weight == 0)
			return 0;
		Pair now = arr[id];
		int realWeight = now.weight * 3 * W;
		if (Computed[id][weight] != -1)
			return Computed[id][weight];
		if (realWeight > weight)
			return KnapSack(id + 1, weight);
		int notake = KnapSack(id + 1, weight);
		int take = now.value + KnapSack(id + 1, weight - realWeight);
		if (notake < take) {
		parents[id][weight]= new Pair2(id+1,weight-realWeight,true);
			return Computed[id][weight] = take;
		} else {
			parents[id][weight]= new Pair2(id+1,weight-realWeight,false);
			return Computed[id][weight] = notake;
		}

	}
	public static void path(int value,int id){
		if(value<0||id==4/*changed it from n */)return ;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		StringBuilder sb  =new StringBuilder();
		while ((s = br.readLine()) != null) {
		if(s.equals("")){
			s=br.readLine();
			if(s==null)
				break;
		}
			StringTokenizer st = new StringTokenizer(s);
			int weight = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			// n = Integer.parseInt(br.readLine());
			 //arr = new Pair[n];
			for (int i = 0; i < 10 /*changed it from n */; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Pair(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			Computed = new int[35][1005];
			parents = new Pair2[35][1005];
			for (int i = 0; i < 35; i++) {
				Arrays.fill(Computed[i], -1);
			}
			sb2 = new StringBuilder();
			totalTreasure = 0 ;
			int result = KnapSack(0, weight);
			//sb2.replace(sb2.length()-1,sb2.length(), "");
			sb.append(result+"\n");
			sb.append(totalTreasure+"\n");
			sb.append(sb2+"\n\n");
		path(0,weight);
		}
		sb.replace(sb.length()-2, sb.length(), "");
		//System.out.println(sb.toString());
	}
}
