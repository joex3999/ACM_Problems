
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA_10192_Vacation {
	static int [][]table;
public static void main(String[] args)throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb  = new StringBuilder();
int counter = 0 ;
while(true){
	String first = br.readLine();
	if(first.equals("#"))
		break;
	String second = br.readLine();
	sb.append(String.format("Case #%s: you can visit at most %s cities.",++counter,lcs(first,second).length()));
	sb.append("\n");
	
	
}
System.out.println(sb.replace(sb.length()-1, sb.length(), ""));

}
public static String lcs(String a, String b) {
    int[][] lengths = new int[a.length()+1][b.length()+1];
 
    // row 0 and column 0 are initialized to 0 already
 
    for (int i = 0; i < a.length(); i++)
        for (int j = 0; j < b.length(); j++)
            if (a.charAt(i) == b.charAt(j))
                lengths[i+1][j+1] = lengths[i][j] + 1;
            else
                lengths[i+1][j+1] =
                    Math.max(lengths[i+1][j], lengths[i][j+1]);
 
    // read the substring out from the matrix
    StringBuffer sb = new StringBuffer();
    for (int x = a.length(), y = b.length();
         x != 0 && y != 0; ) {
        if (lengths[x][y] == lengths[x-1][y])
            x--;
        else if (lengths[x][y] == lengths[x][y-1])
            y--;
        else {
            assert a.charAt(x-1) == b.charAt(y-1);
            sb.append(a.charAt(x-1));
            x--;
            y--;
        }
    }
 
    return sb.reverse().toString();
}

}
