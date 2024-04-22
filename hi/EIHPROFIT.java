import java.util.*;
import java.io.*;

public class EIHPROFIT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfItems = reader.nextInt();
		int numberOfShowingItems = reader.nextInt();
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < numberOfItems; i++) {
			int itemID = reader.nextInt();
			String itemName = reader.next();
			int itemPrice = reader.nextInt();
			int itemCost = reader.nextInt();
			int itemQuantity = reader.nextInt();
			Item item = new Item(itemID, itemName, itemPrice, itemCost, itemQuantity);
			items.add(item);
		}
		Comparator<Item> itemComparator = (s1, s2) -> {
			int compare = s2.calculateProfit() - s1.calculateProfit();
			if (compare == 0) {
				compare = s1.getItemID() - s2.getItemID();
			}
			return compare;
		};
		Collections.sort(items, itemComparator);
		int kthProfit = items.get(numberOfShowingItems - 1).calculateProfit();
		for (Item item : items) {
			if (item.calculateProfit() >= kthProfit) {
				str.append(item.getItemID()).append(" ").append(item.getItemName()).append(" ")
						.append(item.calculateProfit()).append("\n");
			}
		}
		System.out.println(str);

	}

	static class Item {
		private int itemID;
		private String itemName;
		private int itemPrice;
		private int itemCost;
		private int itemQuantity;

		public Item(int itemID, String itemName, int itemPrice, int itemCost, int itemQuantity) {
			this.itemID = itemID;
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemCost = itemCost;
			this.itemQuantity = itemQuantity;
		}

		public int getItemID() {
			return itemID;
		}

		public String getItemName() {
			return itemName;
		}

		public int calculateProfit() {
			int profit = 0;
			profit = (this.itemPrice - this.itemCost) * this.itemQuantity;
			return profit;
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
