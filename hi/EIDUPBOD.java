import java.util.*;
import java.io.*;

public class EIDUPBOD {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		Map<Birthday, Integer> birthdayCounts = new TreeMap<>();
		for (int i = 0; i < numberOfStudents; i++) {
			int date = reader.nextInt();
			int month = reader.nextInt();
			int year = reader.nextInt();
			Birthday birthday = new Birthday(date, month, year);
			birthdayCounts.put(birthday, birthdayCounts.getOrDefault(birthday, 0) + 1);
		}

		for (Map.Entry<Birthday, Integer> entry : birthdayCounts.entrySet()) {
			str.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		System.out.print(str);

	}

	static class Birthday implements Comparable<Birthday> {
		private int date;
		private int month;
		private int year;

		public Birthday(int date, int month, int year) {
			this.date = date;
			this.month = month;
			this.year = year;
		}

		@Override
		public String toString() {
			return String.format("%02d/%02d/%d", date, month, year);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (this.getClass() != o.getClass())
				return false;
			Birthday birthday = (Birthday) o;
			return date == birthday.date && month == birthday.month && year == birthday.year;
		}

		@Override
		public int hashCode() {
			return Objects.hash(date, month, year);
		}

		@Override
		public int compareTo(Birthday o) {
			if (this.year != o.year) {
				return Integer.compare(this.year, o.year);
			}
			if (this.month != o.month) {
				return Integer.compare(this.month, o.month);
			}
			return Integer.compare(this.date, o.date);
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