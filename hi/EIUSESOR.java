import java.util.*;
import java.io.*;

public class EIUSESOR {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int N = reader.nextInt();
		String dataType = reader.next();
		if (dataType.equals("double")) {
			Double[] array = new Double[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextDouble();
			}
			bubbleSort(array);
			for (int i = 0; i < array.length; i++) {
				str.append(array[i]).append(" ");
			}
		} else if (dataType.equals("int")) {
			Integer[] array = new Integer[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextInt();
			}
			bubbleSort(array);
			for (int i = 0; i < array.length; i++) {
				str.append(array[i]).append(" ");
			}
		} else if (dataType.equals("long")) {
			Long[] array = new Long[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextLong();
			}
			bubbleSort(array);
			for (int i = 0; i < array.length; i++) {
				str.append(array[i]).append(" ");
			}
		} else if (dataType.equals("float")) {
			Float[] array = new Float[N];
			for (int i = 0; i < N; i++) {
				array[i] = reader.nextFloat();
			}
			bubbleSort(array);
			for (int i = 0; i < array.length; i++) {
				str.append(array[i]).append(" ");
			}
		}

		System.out.println(str);

	}

	static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			T currentMinimum = array[i];
			int tempPosition = i;
			for (int j = i; j < n; j++) {
				if (array[j].compareTo(currentMinimum) < 0) {
					currentMinimum = array[j];
					tempPosition = j;
				}
			}
			T temp = array[i];
			array[i] = array[tempPosition];
			array[tempPosition] = temp;
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

		public float nextFloat() {
			return Float.parseFloat(next());
		}
	}
}