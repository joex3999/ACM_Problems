 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class UVA_725_Division {
    static boolean [] v = new boolean [10];
     
    static boolean isOk(int n){
        int x;
        if(n < 10000 && v[0])
            return false;
        if(n < 10000)
            v[0] = true;
        while(n > 0){
            x = (n % 10);
            if(v[x])
                return false;
            v[x] = true;
            n /= 10;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n;
        int max = 0;
        String s1,s2;
        boolean first = true;
        boolean f;
        while((n = Integer.parseInt(br.readLine())) != 0){
            if(!first)
                out.append("\n");
            first = false;
            f = false;
            max =  98765 /n ;
            for (int j = 1234; j <= max; j++){
                Arrays.fill(v, false);
                if(isOk(j) && isOk(j * n)){
                    s1 = String.format("%05d", (j*n));
                    s2 = String.format("%05d", j);
                    out.append(s1 + " / " + s2 + " = " + n + "\n");
                    f = true;
                }
            }
            if(!f)
                out.append("There are no solutions for " + n + ".\n");
        }
        System.out.print(out);
    }
}