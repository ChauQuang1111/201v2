import java.util.*;
import java.io.*;

public class EIUGIFTS {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int items = reader.nextInt();
		long money = reader.nextLong();
		long[] price = new long[items];

		for (int i = 0; i < items; i++) {
			price[i] = reader.nextLong();
		}
		Arrays.sort(price);
		int i = 0;
		int j = items - 1;
		long max = 0;
		long diff = Math.abs(price[i] - price[j]);
		for (; i < j;) {
			if (price[i] + price[j] < money) {
				if (max < price[i] + price[j]) {
					max = price[i] + price[j];
					diff = Math.abs(price[i] - price[j]);
				} else if (max == price[i] + price[j]) {
					diff = Math.min(diff, Math.abs(price[i] - price[j]));
				}
				i++;
			} else if (price[i] + price[j] == money) {
				max = price[i] + price[j];
				diff = Math.abs(price[j] - price[i]);
				i++;
				j--;
			} else {
				j--;
			}
		}
		if (max == 0) {
			System.out.print("-1" + " " + "-1");
		} else {
			System.out.print(max + " " + diff);
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
