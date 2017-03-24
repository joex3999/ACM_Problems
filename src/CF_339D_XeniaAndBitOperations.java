

import java.util.Scanner;

public class CF_339D_XeniaAndBitOperations {
	
	
public static void main(String[]args)throws Exception{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//String [] line = br.readLine().split(" ");
		int nt = sc.nextInt();
		int m = sc.nextInt();
		int n = (int)Math.pow(2, nt);
		//String [] secondline = br.readLine().split(" ");
		int N = 1; while(N < n) N <<= 1;
		int []in = new int [N+1];
			
		for(int i =1 ; i<=n;i++){

			in[i] = sc.nextInt();
		
		}
		SegmentTree2 tree = new SegmentTree2(in);
		tree.printTree();
		while(m--!=0){
			int p = sc.nextInt();
			int b = sc.nextInt();
			in[p]=b;
			tree = new SegmentTree2(in);
			tree.printTree();
			System.out.println(tree.query(1, N+2));
			
		}
		
	}
	


	

	//Range Sum Query (with lazy propagation)
	// XOR Tree (Special for 339-D)
	static class SegmentTree2 {		// 1-based DS, OOP
		
		int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
		int[] array, sTree, lazy;
		
		SegmentTree2(int[] in)		
		{
			array = in; N = in.length - 1;
			sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
			lazy = new int[N<<1];
			build(1,1,N,N);
		}
		void change_point(int index, int val)			// O(log n)
		{
			index += N - 1;				
			sTree[index] = val;			
			while(index>1)				
			{
				index >>= 1;
				sTree[index] = sTree[index<<1] + sTree[(index<<1) + 1];		
			}
		}
		
		void build(int node, int b, int e,int c)	// O(n)
		{
			
			if(b == e)					
				sTree[node] = array[b];
			else						
			{
				if(!(c%2==0)){
				
				build(node<<1,b,(b+e)/2,c-1);
				build((node<<1)+1,(b+e)/2+1,e,c-1);
				sTree[node] = sTree[node<<1]+sTree[(node<<1)+1];
				}else{
				
					build(node<<1,b,(b+e)/2,c-1);
					build((node<<1)+1,(b+e)/2+1,e,c-1);
					sTree[node] = sTree[node<<1]^sTree[(node<<1)+1];
					System.out.printf("Result : %s from %s and %s ",sTree[node],sTree[node<<1],sTree[(node<<1)+1]);
				
				}
				}
		}
		
		
		void update_point(int index, int val)			// O(log n)
		{
			index += N - 1;				
			sTree[index] += val;			
			while(index>1)				
			{
				index >>= 1;
				sTree[index] = sTree[index<<1] + sTree[(index<<1) + 1];		
			}
		}
		
		
		void update_range(int i, int j, int val)		// O(log n) 
		{
			update_range(1,1,N,i,j,val);
		}
		
		void update_range(int node, int b, int e, int i, int j, int val)
		{
			if(i > e || j < b)		
				return;
			if(b >= i && e <= j)		
			{
				sTree[node] += (e-b+1)*val;			
				lazy[node] += val;				
			}							
			else		
			{
				propagate(node, b, e);
				update_range(node<<1,b,(b+e)/2,i,j,val);
				update_range((node<<1)+1,(b+e)/2+1,e,i,j,val);
				sTree[node] = sTree[node<<1] + sTree[(node<<1)+1];		
			}
			
		}
		void propagate(int node, int b, int e)		
		{
			int mid = (b+e)/2;
			lazy[node<<1] += lazy[node];
			lazy[(node<<1)+1] += lazy[node];
			sTree[node<<1] += (mid-b+1)*lazy[node];		
			sTree[(node<<1)+1] += (e-mid)*lazy[node];		
			lazy[node] = 0;
		}
		
		int query(int i, int j)
		{
			return query(1,1,N,i,j);
		}
		
		int query(int node, int b, int e, int i, int j)	// O(log n)
		{
			if(i>e || j <b)
				return 0;		
			if(b>= i && e <= j)
				return sTree[node];
			propagate(node, b, e);
			int q1 = query(node<<1,b,(b+e)/2,i,j);
			int q2 = query((node<<1)+1,(b+e)/2+1,e,i,j);
			return q1 + q2;	
					
		}
		
		void printTree(){
			for(int i =0 ; i<sTree.length;i++){
				System.out.printf("(%s,%s)",i,sTree[i]);
			}
			System.out.println();
		}
		void printLazy(){
			for(int i =0 ;i<lazy.length;i++){
				System.out.printf("(%s,%s)",i,lazy[i]);
			}
			System.out.println();
		}}
				
		

	
	

}
