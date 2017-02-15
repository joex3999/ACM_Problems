

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// this is a challenging 1 ... at least for me on 6/27/2016
// got close :  http://sound-system-79.blogspot.com.eg/2015/01/uva-434-mattys-blocks.html
public class LUVA_434_MattysBlocks {
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int testcases = Integer.parseInt(br.readLine());
	StringBuilder sb = new StringBuilder();
	boolean first = true ;
	while(testcases-->0){
	int k = Integer.parseInt(br.readLine());
	int [] front = new int [k];
	int [] right= new int [k];
	int righttot = 0;
	int fronttot = 0;
	StringTokenizer st = new StringTokenizer(br.readLine());
	for(int i =0 ; i<k;i++){
		front[i]= Integer.parseInt(st.nextToken());
		fronttot +=front[i];
	}
	st = new StringTokenizer(br.readLine());
	for(int i =0 ; i<k;i++){
	 right[i]= Integer.parseInt(st.nextToken());
	 righttot+=right[i];
	}
	int LeastBlocks = Math.max(fronttot, righttot);
	int ExtraBlocks = 0;
	for(int i =0 ;i<k;i++){
		int block = right[i];
	
		while(block-->0){
			int added = -2 ; // there could be aprob due to block --	
			for(int j = 0 ;j<k;j++){
				if(front[j]>=block){
					added++;
				}
			}
			if(added>0)
			ExtraBlocks += added ;
		}
	}
	
	if(ExtraBlocks==-1||ExtraBlocks==-2){
		ExtraBlocks = 0 ;
	}
	
	if(first){
	String formatted = String.format("Matty needs at least %s blocks, and can add at most %s extra blocks.",LeastBlocks,ExtraBlocks);
	sb.append(formatted);
	first = false ;
	}else{
		String formatted = String.format("\nMatty needs at least %s blocks, and can add at most %s extra blocks.", LeastBlocks,ExtraBlocks);
sb.append(formatted);
	}
}
	System.out.println(sb.toString());}
}
