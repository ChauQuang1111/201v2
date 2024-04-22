import java.util.*;
import java.io.*;

public class EIUPREIU {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {

		int n = reader.nextInt();
		if (n % 2 == 0 && n <= 1000) {
			str.append(" ");
			print1(n);
			for (int i = 0; i < (4 + n / 2 + 1); i++) {
				str.append(" ");
			}
			str.append("\n");
			for (int i = 1; i <= (n - 2) / 2; i++) {
				str.append("|");
				print2(n);
				str.append(" | |");
				print2(n);
				str.append("|");
				str.append("\n");
			}
			str.append("|");
			print1(n);
			str.append(" | |");
			print2(n);
			str.append("|");
			str.append("\n");
			for (int i = 1; i <= (n - 2) / 2; i++) {
				str.append("|");
				print2(n);
				str.append(" | |");
				print2(n);
				str.append("|");
				str.append("\n");
			}
			str.append("|");
			print1(n);
			str.append(" | |");
			print1(n);
			str.append("|");
			str.append("\n");
			System.out.print(str);
		} else {
			str.append(0);
		}

	}

	public static void print1(int n) {
		for (int i = 1; i <= n / 2; i++) {
			str.append("_");
		}
	}

	public static void print2(int n) {
		for (int i = 1; i <= n / 2; i++) {
			str.append(" ");
		}
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
