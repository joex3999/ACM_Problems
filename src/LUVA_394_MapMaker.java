

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
// answer from https://github.com/fernandohbc/MyPCS/blob/master/uvaonlinejudge/src/volume_iii/P394_Mapmaker.java 
// copied to test . check later
public class LUVA_394_MapMaker {



    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        StringTokenizer st = tokenizeNextLine();

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        Map<String, Arrayy> arrayMap = new HashMap<String, Arrayy>();

        for (int i = 0; i < n; i++) {
            st = tokenizeNextLine();
            String arrayName = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int bounds[] = new int[2 * d];
            for (int bd = 0; bd < 2 * d; bd++) {
                bounds[bd] = Integer.parseInt(st.nextToken());
            }

            Arrayy array = new Arrayy(b, size, d, bounds);
            arrayMap.put(arrayName, array);
        }

        for (int i = 0; i < r; i++) {
            st = tokenizeNextLine();
            String arrayName = st.nextToken();
            ArrayList<Integer> arguments = new ArrayList<Integer>();
            while (st.hasMoreTokens()) {
                arguments.add(Integer.parseInt(st.nextToken()));
            }

            Arrayy array = arrayMap.get(arrayName);
            if (array != null) {
                int pos = array.calcPos(arguments);
                System.out.println(arrayName + arguments + " = " + pos);
            }
        }
    }

    private static StringTokenizer tokenizeNextLine() {
        return new StringTokenizer(scn.nextLine());
    }
}

class Arrayy {

    private final int c[];

    public Arrayy(int b, int size, int d, int[] bounds) {
        this.c = new int[d + 1];
        this.c[d] = size;

        for (int i = d - 1; i > 0; i--) {
            this.c[i] = this.c[i + 1] * (bounds[2 * i + 1] - bounds[2 * i] + 1);
        }

        this.c[0] = b;
        for (int i = 1; i <= d; i++) {
            this.c[0] -= this.c[i] * bounds[2 * i - 2];
        }
    }

    public int calcPos(ArrayList<Integer> arguments) {
        int pos = this.c[0];
        for (int i = 0; i < arguments.size(); i++) {
            pos += this.c[i + 1] * arguments.get(i);
        }
        return pos;
    }

}

