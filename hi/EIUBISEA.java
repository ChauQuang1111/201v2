import java.util.*;
import java.io.*;

public class EIUBISEA {

	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = reader.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < m; i++) {
			str.append(binarySearch(arr, reader.nextInt())).append(" ");
		}
		System.out.print(str);
		
	}
	
	public static int binarySearch(int arr[], int k) {
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
            int mid = start + (end - start) / 2;
			if (arr[mid] == k ) {
				while (mid >= 0 && arr[mid] == k) {
					mid--;
				}
				return mid + 1;
			} else if (arr[mid] < k) {
				start = mid + 1;
			} else {
				end = mid -1;
			}
		}
		
		return -1;
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
