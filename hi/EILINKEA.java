import java.util.*;
import java.io.*;

public class EILINKEA {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
	    LinkedList<Integer> linkedList = new LinkedList<Integer>();
	    int index = reader.nextInt();
	    int n = reader.nextInt();
	    for (int i = 0; i < n; i++) {
	        String command = reader.next();
	        if (command.equals("insertAt")) {
	            int index0 = reader.nextInt();
	            int value = reader.nextInt();
	            linkedList.insertAt(index0, value);
	        } else if (command.equals("getAt")) {
	            int index1 = reader.nextInt();
	            Integer result = linkedList.getAt(index1);
	            if (result != null) {
	                str.append(result).append("\n");
	            } else {
	                str.append("null\n");
	            }
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

		public void insertAt(int index, T number) {
			LinkedNode<T> newNode = new LinkedNode<>(number);
			newNode.next = head;
			head = newNode;
		}

		public T getAt(int index) {
			if (index < 0) {
				return null;
			}

			LinkedNode<T> current = head;

			for (int i = 0; i < index && current != null; i++) {
				current = current.next;
			}

			if (current != null) {
				return current.number;
			} else {
				return null;
			}
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
