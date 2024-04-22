import java.util.*;
import java.io.*;

public class EI2121Q1M2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		Map<Integer, Integer> yearMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int specificYear = reader.nextInt();
			yearMap.put(specificYear, yearMap.getOrDefault(specificYear, 0) + 1);

		}
		List<Year> years = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : yearMap.entrySet()) {
			Year year = new Year(entry.getKey(), entry.getValue());
			years.add(year);
		}
		
		Comparator<Year> yearComparator = (s1, s2) -> {
			var compare = s1.getYear() - s2.getYear();
			return compare;
		};
		Collections.sort(years, yearComparator);
		for (Year year : years) {
			str.append(year.toString()).append("\n");
		}
		System.out.print(str);
	}

	static class Year {
		private int year;
		private int occurence;

		public Year(int year, int occurence) {
			this.year = year;
			this.occurence = occurence;
		}

		public int getYear() {
			return year;
		}

		public int getOccurence() {
			return occurence;
		}

		@Override
		public String toString() {
			return year + " " + occurence;
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
