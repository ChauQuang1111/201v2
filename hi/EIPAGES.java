import java.util.*;
import java.io.*;

public class EIPAGES {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {

		int count = 0;
		int n = reader.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = reader.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i < n; i++) {
			if (i < n - 1 && a[i] == a[i + 1] - 1 ) {
				count++;
			} else {
				if (count >= 2) {
					str.append(a[i - count]).append("-").append(a[i]).append(" ");
				} else {
					for (int j = i - count; j <= i; j++) {
						str.append(a[j]).append(" ");
					}
				}
				count = 0;
			}
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
