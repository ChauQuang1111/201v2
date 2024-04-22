import java.util.*;
import java.io.*;

public class EIPICNIC {

	static InputReader reader = new InputReader(System.in);

	public static void main(String[] args) {
		int group = reader.nextInt();
		StringBuilder str = new StringBuilder();
		int[] car = new int[5];
		for (int i = 0; i < group; i++) {
			int people = reader.nextInt();
			car[people]++;
		}
		int totalCar = 0;
		totalCar += car[4];
		if (car[3] >= car[1]) {
			totalCar += car[3];
			car[1] = 0;
		} else {
			totalCar += car[3];
			car[1] = car[1] - car[3];
		}
		if (car[2] % 2 == 0) {
			totalCar += car[2] / 2;
			totalCar += Math.ceil((double) car[1] / 4);
		} else {
			totalCar += car[2] / 2 + 1;
			if (car[1] != 0) {
				if (car[1] > 2) {
					totalCar += Math.ceil((double) (car[1] - 2) / 4);
				}
			}
		}
		str.append(totalCar);
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