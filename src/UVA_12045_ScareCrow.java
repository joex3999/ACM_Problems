

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_12045_ScareCrow {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cases = Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++){
            br.readLine();
            String str=br.readLine();
            int counter=0;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='.'){
                    counter++;
                    j+=2;
                }
            }
            String ans=String.format("Case %d: %d", i+1,counter);	
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
