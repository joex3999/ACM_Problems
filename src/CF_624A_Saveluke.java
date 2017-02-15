

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//do it laaateer
// online sOlution  :   #include <cstdio>
							//
							//int main() {
							//  int d, l, v1, v2;
							//  scanf("%d%d%d%d", &d, &l, &v1, &v2);
							//  printf("%.17f\n", double(l - d) / (v1 + v2));
							//  return 0;
							//}

public class CF_624A_Saveluke {
public static void main(String[]ags)throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int d = Integer.parseInt(st.nextToken());
	int l = Integer.parseInt(st.nextToken());
	int v1 = Integer.parseInt(st.nextToken());
	int v2 = Integer.parseInt(st.nextToken());
	System.out.printf("%.17f\n",(double)(l-d) / (v1+v2) );
}
}
