import java.util.*;
import java.io.*;

public class EILINKED {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		int n = reader.nextInt();
		int m = reader.nextInt();
		for (int i = 0; i < n; i++) {
			linkedList.insertAtEnd(reader.nextInt());
		}
		for (int i = 0; i < m; i++) {
			String command = reader.next();
			switch (command) {
			case "getAt":
				int index = reader.nextInt();
				str.append(linkedList.getAt(index)).append("\n");
				break;
			case "firstIndexOf":
				int value1 = reader.nextInt();
				str.append(linkedList.firstIndexOf(value1)).append("\n");
				break;
			case "lastIndexOf":
				int value2 = reader.nextInt();
				str.append(linkedList.lastIndexOf(value2)).append("\n");
				break;
			case "size":
				str.append(linkedList.size()).append("\n");
				break;
			case "sum":
				str.append(linkedList.sum()).append("\n");
				break;
			case "average":
				str.append(linkedList.average()).append("\n");
				break;
			case "removeAt":
				int index1 = reader.nextInt();
				linkedList.removeAt(index1);
				break;
			case "removeFirst":
				int value3 = reader.nextInt();
				linkedList.removeFirst(value3);
				break;
			case "insertAt":
				int index2 = reader.nextInt();
				int value4 = reader.nextInt();
				linkedList.insertAt(index2, value4);
				break;
			default:
				break;
			}
		}
		System.out.print(str);
	}

	static class LinkedList<T extends Number> {
		private class LinkedNode<U extends Number> {
			U number;
			LinkedNode<U> next;

			public LinkedNode(U number) {
				this.number = number;
			}
		}

		LinkedNode<T> head = null;
		LinkedNode<T> tail = null;
		int size = 0;

		public void insertAtEnd(T number) {
			LinkedNode<T> newNode = new LinkedNode<>(number);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
			size++;
		}

		public T getAt(int index) {
			if (index < 0 || index >= size) {
				return null;
			}

			LinkedNode<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current.number;
		}

		public int firstIndexOf(T number) {
			LinkedNode<T> current = head;
			int index = 0;
			while (current != null) {
				if (current.number.equals(number)) {
					return index;
				}
				current = current.next;
				index++;
			}
			return -1;
		}

		public int lastIndexOf(int value) {
			LinkedNode<T> current = head;
			int index = 0;
			int temp = -1;
			while (current != null) {
				if (current.number.equals(value)) {
					temp = index;
				}
				current = current.next;
				index++;
			}
			return temp;
		}

		public void removeFirst(int number) {
			if (head == null) {
				return;
			}

			if (head.number.equals(number)) {
				head = head.next;
				size--;
				return;
			}

			LinkedNode<T> current = head;
			while (current.next != null && !current.next.number.equals(number)) {
				current = current.next;
			}
			if (current.next != null) {
				current.next = current.next.next;
				size--;
			}
		}

		public void removeAt(int index) {
			if (index < 0 || index >= size || head == null) {
				return;
			}

			if (index == 0) {
				head = head.next;
				size--;
				return;
			}

			LinkedNode<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			if (current.next != null) {
				current.next = current.next.next;
				size--;
			}
		}

		public void insertAt(int index, T number) {
			if (index < 0 || index > size) {
				return;
			}

			LinkedNode<T> newNode = new LinkedNode<>(number);
			if (index == 0) {
				newNode.next = head;
				head = newNode;
				size++;
				return;
			}

			LinkedNode<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
			size++;
		}

		public int size() {
			return size;
		}

		public double sum() {
			double sum = 0;
			LinkedNode<T> current = head;
			while (current != null) {
				sum += current.number.doubleValue();
				current = current.next;
			}
			return sum;
		}

		public double average() {
			if (size == 0) {
				return 0;
			}
			return sum() / size;
		}
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;

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
					tokenizer = new StringTokenizer(reader.readLine());
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
