

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
//http://mypaper.pchome.com.tw/zerojudge/post/1324839770
public class UVA_11348_Exhibition {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int casee = 1;
		boolean first = true;
		StringBuilder sb = new StringBuilder();
		while (k-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] uniques = new int [n];
			Double totaluniques = 0.0 ;
			ArrayList<HashSet> list = new ArrayList<HashSet>();
			ArrayList<int[]> list2 = new ArrayList<int[]>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int notuseless = Integer.parseInt(st.nextToken());
				HashSet temp = new HashSet();
				int[] temp2 = new int[notuseless];
				for (int j = 0; j < notuseless; j++) {
					int wa = Integer.parseInt(st.nextToken());
					temp.add(wa);
					temp2[j] = wa;
				}
				list2.add(temp2);
				list.add(temp);

			}

			for (int i = 0; i < list2.size(); i++) {
				System.out.println(list2.size());
				int[] now = list2.get(i);
				for (int j = 0; j < now.length; j++) {
					int noww = now[j];
					boolean ok = true;
					for (int mm = 0; mm < list.size(); mm++) {
						if (mm == i) {
							continue;
						}
						if (list.get(mm).contains(noww)) {
							ok = false;
						}
					}
					if (ok) {
						System.out.println(i);
						uniques[i]++;
					totaluniques++;
					}
				}
			}

		if(first){
			String format = String.format("Case %s:", casee++);
			sb.append(format);
		first = false ;
		}else{
			String format = String.format("\nCase %s:", casee++);
			sb.append(format);
		}
		
		for(int i =0 ; i <uniques.length;i++){
		 String format = String.format(" %.6f",(uniques[i]/totaluniques)*100);
		 format+="%";
		 sb.append(format);
		}
		
		}
		System.out.println(sb.toString());
	}
}
