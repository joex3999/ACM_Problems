
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_25A_IQtest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int x = Integer.parseInt(temp[0]);
		int y = Integer.parseInt(temp[1]);
		int z = Integer.parseInt(temp[2]);
		boolean evenness = false;	
		if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 0 && z % 2 == 0)
				|| (y % 2 == 0 && z % 2 == 0)) {
			evenness = true;
		}
		if (evenness) {
			for (int i = 0; i < temp.length; i++) {
				if (!(Integer.parseInt(temp[i]) % 2 == 0)) {
					System.out.println(i + 1);
					break;
				}

			}
		} else {
			for (int i = 0; i < temp.length; i++) {
				if ((Integer.parseInt(temp[i]) % 2 == 0)) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	}
}
