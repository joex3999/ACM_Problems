

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class UVA_11988_BrokenKeyboard_aka_BeijuText {

		public static void main(String[] args) throws IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			String line;
			while ((line = in.readLine()) != null) {
				char[] stream = line.toCharArray();
				boolean begin = false;
				StringBuilder cur = new StringBuilder();
				Deque<String> total = new ArrayDeque<String>();
				
				for (char c : stream) {
					if (c == '[') {
						if (begin)
							total.offerFirst(cur.toString());
						else
							total.offerLast(cur.toString());
						cur = new StringBuilder();
						begin = true;
					} else if (c == ']') {
						if (begin)
							total.offerFirst(cur.toString());
						else
							total.offerLast(cur.toString());
						cur = new StringBuilder();
						begin = false;
					} else {
						cur.append(c);
					}
				}
				if (begin)
					total.offerFirst(cur.toString());
				else
					total.offerLast(cur.toString());
				
				StringBuilder res = new StringBuilder();
				while (!total.isEmpty())
					res.append(total.pollFirst());
				
				System.out.println(res.toString());
			}
			
			in.close();
			System.exit(0);
		}
	}

