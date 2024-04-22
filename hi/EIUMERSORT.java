import java.util.*;
import java.io.*;

public class EIUMERSORT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		mergeSort(array, 0, n - 1);
		for (int num : array) {
			str.append(num).append("\n");
		}
		System.out.print(str);

	}

	static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	static void merge(int[] array, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++) {
			L[i] = array[left + i];
		}
		for (int j = 0; j < n2; j++) {
			R[j] = array[mid + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
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
