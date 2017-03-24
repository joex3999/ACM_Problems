
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CF_343B_AlternatingCurrent {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char[] arr = line.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (!stack.isEmpty() && arr[i] == stack.peek()) {
				stack.pop();
			} else {
				stack.push(arr[i]);
			}
		}

		System.out.println(stack.isEmpty() ? "Yes" : "No");
		br.close();
		System.exit(0);

	}
}
