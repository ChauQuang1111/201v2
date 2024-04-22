import java.util.*;
import java.io.*;

public class EIUGIFT1 {
	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int numberOfGifts = reader.nextInt();
		int numberOfGWP = reader.nextInt();
		double[] sizeOfGift = new double[numberOfGifts];
		double[] sizeOfGWP = new double[numberOfGWP];

		for (int i = 0; i < numberOfGifts; i++) {
			sizeOfGift[i] = reader.nextDouble();
		}
		for (int j = 0; j < numberOfGWP; j++) {
			sizeOfGWP[j] = reader.nextDouble();
		}

		Arrays.sort(sizeOfGift);
		Arrays.sort(sizeOfGWP);

		int count = 0;
		int i = 0;
		int j = 0;
		for (; i < numberOfGifts && j < numberOfGWP;) {
			if (sizeOfGWP[j] / sizeOfGift[i] <= 3 && sizeOfGWP[j] / sizeOfGift[i] >= 2) {
				count++;
				i++;
				j++;
			} else if (sizeOfGWP[j] / sizeOfGift[i] > 3) {
				i++;
			} else if (sizeOfGWP[j] / sizeOfGift[i] < 2) {
				j++;
			}
		}

		System.out.print(count);
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
