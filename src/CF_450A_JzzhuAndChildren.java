

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_450A_JzzhuAndChildren {
public static void main(String []args)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  double max = Integer.parseInt(st.nextToken());
st = new StringTokenizer(br.readLine());
double maxi = 0;
int index = 0;
for(int i =0 ; i<n;i++){
	double gg = Integer.parseInt(st.nextToken());

	if(Math.ceil(maxi/max)<=Math.ceil(gg/max)){
		maxi=gg;
		index = i+1 ;
	}
	
}
System.out.println(index);
}
}
