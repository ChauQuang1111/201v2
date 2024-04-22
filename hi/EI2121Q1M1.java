import java.util.*;
import java.io.*;

public class EI2121Q1M1 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		Map<Integer, Staff> staffMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			int startYear = reader.nextInt();
			staffMap.put(id, new Staff(id, name, startYear));
		}
		List<Staff> staffs = new ArrayList<>(staffMap.values());
		Comparator<Staff> staffComparator = (s1, s2) -> {
			var compare = s2.getYear() - s1.getYear();
			if (compare == 0) {
				compare = s1.getName().compareTo(s2.getName());
				if (compare == 0) {
					compare = s1.getId() - s2.getId();
				}
			}
			return compare;
		};
		Collections.sort(staffs, staffComparator);
		for (Staff staff : staffs) {
			str.append(staff.toString()).append("\n");
		}
		System.out.print(str);

	}

	static class Staff {
		private int id;
		private String name;
		private int workingYears;

		public Staff(int id, String name, int startYears) {
			this.id = id;
			this.name = name;
			this.workingYears = 2021 - startYears;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public int getYear() {
			return workingYears;
		}

		@Override
		public String toString() {
			return id + " " + name + " " + workingYears;
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
