import java.util.*;
import java.io.*;

public class EISTACKS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder result = new StringBuilder();
	static double sum = 0;
	
	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		int k = reader.nextInt();
		ArrayStack<Integer> stack = new ArrayStack<>(n);
		for (int i = 0; i < m; i++) {
			stack.push(reader.nextInt());
		}
		for (int i = 0; i < k; i++) {
			String command = reader.next();
			switch (command) {
			case "peek":
				result.append(stack.peek()).append("\n");
				break;
			case "push":
				stack.push(reader.nextInt());
				break;
			case "pop":
				result.append(stack.pop()).append("\n");
				break;
			case "sum":
				result.append(sum).append("\n");
				break;
			case "average":
				result.append(sum/stack.getSize()).append("\n");
				break;
			default:
				result.append("Invalid command.").append("\n");
			}
		}

		System.out.print(result);
	}

	static class ArrayStack<T extends Number> {
		private Object[] data;
		private int capacity;
		private int size;

		public ArrayStack(int capacity) {
			this.data = new Object[capacity];
			this.capacity = capacity;
			this.size = 0;
		}
		
		public int getSize() {
			return size;
		}

		public int count() {
			return size;
		}

		@SuppressWarnings("unchecked")
		public void push(T number) {
			if (size < capacity) {
				data[size++] = number;
				sum += number.doubleValue();
			}
		}

		@SuppressWarnings("unchecked")
		public T peek() {
			if (size > 0) {
				return (T) data[size - 1];
			}
			return null;
		}

		@SuppressWarnings("unchecked")
		public T pop() {
			if (size > 0) {
				T value = (T) data[--size];
				sum -= ((Integer) data[size]).doubleValue();
				data[size] = null;
				return value;
			}
			return null;
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
