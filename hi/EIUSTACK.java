import java.util.*;
import java.io.*;

class ArrayStack<T extends Number> {
	private Object[] data;
	private int capacity;
	private int size;

	public ArrayStack(int capacity) {
		this.data = new Object[capacity];
		this.capacity = capacity;
		this.size = size;
	}

	public int count() {
		return size;
	}

	public double sum() {
		double sum = 0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				sum += ((Number) data[i]).doubleValue();
			}
			return Double.valueOf(sum);
		} else {
			return 0;
		}
	}

	public double average() {
		double avr = 0;
		double sum = 0;
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				sum += ((Number) data[i]).doubleValue();
			}
			return sum / size;
		} else {
			return 0;
		}
	}

	public void push(T number) {
		if (number != null) {
			if (size < capacity) {
				data[size++] = number;
			} else {
				System.out.println("Stack is full. Cannot push " + number);
			}
		} else {
			System.out.println("Cannot push null to the stack.");
		}
	}

	public T peek() {
		if (size > 0) {
			return (T) data[size - 1];
		} else {
			System.out.println("Stack is empty. Cannot peek.");
			return null;
		}
	}

	public T pop() {
		if (size > 0) {
			T value = (T) data[--size];
			data[size] = null;
			return value;
		} else {
			System.out.println("Stack is empty. Cannot peek.");
			return null;
		}
	}

}

public class EIUSTACK {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		int m = reader.nextInt();
		int k = reader.nextInt();
		ArrayStack<Number> stack = new ArrayStack<>(n);
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
				result.append(stack.sum()).append("\n");
				break;
			case "average":
				result.append(stack.average()).append("\n");
				break;
			default:
				result.append("Invalid command.").append("\n");
			}
		}

		System.out.print(result);

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
