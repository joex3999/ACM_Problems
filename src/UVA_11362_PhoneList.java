
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 // https://f0rth3r3c0rd.wordpress.com/2012/02/15/uva-11362-phone-list/
public class UVA_11362_PhoneList {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(in.readLine().trim());
        while (tc-- > 0) {
            String[] arr = new String[Integer.parseInt(in.readLine().trim())];
            for (int i = 0; i < arr.length; i++)
                arr[i] = in.readLine().trim();
            Arrays.sort(arr);
            boolean flag = false;
            for (int i = 0; i < arr.length - 1 && !flag; i++) {
                if (arr[i].length() <= arr[i + 1].length()
                        && arr[i].equals(arr[i + 1].subSequence(0,
                                arr[i].length())))
                    flag = true;
            }
            if (flag)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}