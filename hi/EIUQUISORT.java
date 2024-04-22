import java.util.*;
import java.io.*;

public class EIUQUISORT {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		
		quickSort(array, 0, n - 1);
		for (int num : array) {
			str.append(num).append("\n");
		}
		System.out.print(str);
	}

	static void quickSort(int[] array, int start, int end) {
		if (start < end) {
			int pivot = partition(array, start, end);
			quickSort(array, start, pivot - 1);
			quickSort(array, pivot + 1, end);
		}
	}

	static int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (array[j] < pivot) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		i++;
		int temp = array[end];
		array[end] = array[i];
		array[i] = temp;
		return i;
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
