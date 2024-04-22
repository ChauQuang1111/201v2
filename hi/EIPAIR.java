import java.util.*;
import java.io.*;

public class EIPAIR {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int testcase = reader.nextInt();
		int cases = 0;
		while (cases < testcase) {
			int n = reader.nextInt();
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>((l1, l2) -> l1.compareTo(l2));
			for (int j = 0; j < n; j++) {
				int number = reader.nextInt();
				map.put(number, map.getOrDefault(number, 0) + 1);
			}
			long total = 0;
			for (int value : map.keySet()) {
					int occurrence = map.get(value);
					total += (long) occurrence * (occurrence - 1) / 2;
			}
			str.append(total).append("\n");
			cases++;
		}
		System.out.print(str);
	}


	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}

}
