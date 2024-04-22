import java.util.*;
import java.io.*;

public class EISTOCK {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfTrans = reader.nextInt();
		Map<Integer, Item> items = new HashMap<>();
		for (int i = 0; i < numberOfTrans; i++) {
			String status = reader.next();
			int id = reader.nextInt();
			long quantity = reader.nextLong();
			long price = reader.nextLong();

			if (!items.containsKey(id)) {
				if (status.equalsIgnoreCase("+")) {
					items.put(id, new Item(id));
				}
			}

			Item item = items.get(id);

			if (status.equalsIgnoreCase("+")) {
				item.calculateImportValue(price, quantity);
			} else if (status.equalsIgnoreCase("-")) {
				if (item != null) {
					if (quantity <= item.getQuantity()) {
						item.calculateExportValue(price, quantity);
					}
				}
			}
		}
		List<Item> itemsList = new ArrayList<>(items.values());
		Comparator<Item> itemComparator = (s1, s2) -> {
			var compare = s1.getId() - s2.getId();
			return compare;
		};
		Collections.sort(itemsList, itemComparator);
		for (Item item : itemsList) {
			str.append(item.toString()).append("\n");
		}
		System.out.print(str);

	}

	static class Item {
		private int id;
		private long quantity;
		private long importBalance;
		private long exportBalance;

		public Item(int id) {
			this.id = id;
			this.quantity = 0;
			this.importBalance = 0;
			this.exportBalance = 0;

		}

		public long calculateImportValue(long importValue, long quantity) {
			importBalance += importValue * quantity;
			this.quantity += quantity;
			return importBalance;
		}

		public long calculateExportValue(long exportValue, long quantity) {
			exportBalance += exportValue * quantity;
			this.quantity -= quantity;
			return exportBalance;

		}

		public int getId() {
			return id;
		}

		public long getQuantity() {
			return quantity;
		}

		public String toString() {
			return id + " " + importBalance + " " + exportBalance;
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
