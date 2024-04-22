import java.util.*;
import java.io.*;

public class EIUTRANS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = reader.nextInt();
		int m = reader.nextInt();
		Map<String, String> words = new HashMap<>();
		for (int i = 0; i<m; i++) {
			String wordA = reader.next();
			String wordB = reader.next();
			words.put(wordA, wordB);
		}
		String[] sendingWords =  reader.nextLine().split(" ");
		for (String word : sendingWords) {
			if (words.containsKey(word)) {
				if (word.length() <= words.get(word).length()) {
					result.append(word).append(" ");
				} else {
					result.append(words.get(word)).append(" ");
				}
			}
		}
		System.out.print(result);
		
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
