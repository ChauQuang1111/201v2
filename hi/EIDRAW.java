import java.util.*;
import java.io.*;

public class EIDRAW {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int h = reader.nextInt();
		if (h >= 1 && h <= 1000) {
			int i = (h * 2) - 2;
			int j = 0;
			int k = 0;
			while (i >= 0) {
				drawSpace2(j);
				str.append("\\");
				drawSpace1(i);
				str.append("/");
				drawSpace2(k);
				str.append("\\");
				drawSpace1(i);
				str.append("/");
				drawSpace2(j);
				str.append("\n");
				i -= 2;
				j++;
				k += 2;
			}
			System.out.print(str);
		} else {
			str.append(0);
			System.out.print(str);
		}

	}

	public static void drawSpace1(int n) {
		for (int i = 1; i <= n; i++) {
			str.append(" ");
		}
	}

	public static void drawSpace2(int n) {
		for (int i = 1; i <= n; i++) {
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
