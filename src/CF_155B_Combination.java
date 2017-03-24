

// WRONG ANSWER . THE OTHER 1 is CORRECT
// here you tried to make 2 arrays sorted according to the count , and the value held . you iterate on the count array with respect to the value held in both
// the arrays. it got Wrong Answer in test 3 in Codeforces
public class CF_155B_Combination {
	static class Pair implements Comparable {
		int x;
		int index;
		int y ;
		public Pair(int x, int y , int ind) {
			this.x = x;
			this.index = ind;
			this.y =y;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			if (this.x == p.x) {
				return 0;
			}
			if (this.x > p.x) {
				return -1;
			} else {
				return 1;
		
			}

		}

	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		Pair [] pairs1 = new Pair[n];
//		Pair []pairs2 = new Pair[n];
//		for(int i =0 ; i<n;i++){
//			int g = sc.nextInt();
//			int y = sc.nextInt();
//			pairs1[i] = new Pair(g,y,i);
//			pairs2[i]= new Pair(y,g,i);
//		}
//
//	
//	Arrays.sort(pairs1);
//	Arrays.sort(pairs2);
//if(pairs2[0].x==0){
//	
//	System.out.println(pairs1[0].x);
//return ;
//}
//
//int count = 1; 
//int result=0 ;
//HashSet used = new HashSet();
//	for(int i =0 ;i<pairs2.length&&count>0;i++){
//		if(!used.contains(pairs2[i].index)){
//		count+=pairs2[i].x;
//		count--;
//		result+=pairs2[i].y;
//	
//		used.add(pairs2[i].index);
//		for(int j =0 ;j<pairs1.length&&count>1;j++){
//		
//			if(!used.contains(pairs1[j].index)){
//				count--;
//result+= pairs1[j].x;
//count += pairs1[j].y;
//used.add(pairs1[j].index);
//			}
//		}
//	}
//		}
//	System.out.println(result);
//	
//	
//	
//	
//	}
}}
