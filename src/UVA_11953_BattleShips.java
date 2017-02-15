

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_11953_BattleShips {
	static char [][] grid ;
	static int numberofShips ;
	static boolean first = true ;
	static int V ;
	static void dfs(int x,int y )				//O(V + E) adjList, O(V^2) adjMat	
	{
		if(first){
if(grid[x][y]=='x'){
	grid[x][y]='.';
	
		numberofShips++;
		first=false;
	
}else{
	return ;
}}else{
	if(grid[x][y]=='x'||(grid[x][y]=='@')){
		grid[x][y]='.';
		
			
		
	}else{
		return ;
	}
}
if(x+1<V)
	dfs(x+1,y);
	if(y+1<V)
		dfs(x,y+1);
		if(y-1>=0)
			dfs(x,y-1);
			if(x-1>=0)
				dfs(x-1,y);

	}
	
public static void main(String[]args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	int ctr = 1 ;
	StringBuilder sb = new StringBuilder();
	while(T-->0){
		numberofShips = 0 ;
		V = Integer.parseInt(br.readLine());
	grid = new char [V][V];
	for(int i =0 ; i<V;i++){
		grid[i] = br.readLine().toCharArray();
	}
	for(int i=0 ; i<V;i++){
		for(int j = 0 ;j<V;j++){
			first = true ;
			dfs(i,j);
		}
	}
  String format = String.format("Case %s: %s\n",ctr++,numberofShips);
  sb.append(format);
	}
	sb.replace(sb.length()-1, sb.length(), "");
	System.out.println(sb.toString());
}
}
