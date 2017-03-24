import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
  
public class UVA_12532_IntervalProduct {
    static long K, N;
    static int [] bs = new int[100 * 1000 + 5];
    static int [] tree = new int[100 * 1000 + 5];
     
    static int read(int idx){
        int sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
     
    static void update(int idx, long val){
        while(idx <= N){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }
     
 
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
         
        String l;
        String [] sp;
        int idx ,value, st, e;
         
        while((l = br.readLine()) != null){
            sp = l.split(" ");
            N = Integer.parseInt(sp[0]);
            K = Integer.parseInt(sp[1]);
             
            Arrays.fill(tree, 0);
            sp = br.readLine().split(" ");
            for (int i = 1; i <= N; i++){
                if(Integer.parseInt(sp[i-1]) == 0)
                    update(i, -1000000);
                else if(Integer.parseInt(sp[i-1]) < 0)
                    update(i, 1);
            }
             
            for (int i = 0; i < K; i++) {
                sp = br.readLine().split(" ");
                if(sp[0].matches("C")){
                    idx = Integer.parseInt(sp[1]);
                    value = Integer.parseInt(sp[2]);
                    int v = read(idx) - read(idx - 1);
                    update(idx, - v);
                    if(value < 0){
                        update(idx, 1);
                    }else if(value == 0){
                        update(idx, -1000000);
                    }
                }else{
                    st = Integer.parseInt(sp[1]);
                    e = Integer.parseInt(sp[2]);
                     
                    int res = read(e) - read(st - 1);
                     
                    if(res >= 0){
                        out.append((res % 2 == 0 ? "+" : "-"));
                    }else{
                        out.append("0");
                    }
                }
            }
            out.append("\n");
        }
        System.out.print(out);
         
    }
  
}