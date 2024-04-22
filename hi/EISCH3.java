import java.util.*;
import java.io.*;

public class EISCH3 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int n = reader.nextInt();
		String[] scholarship = { "A", "A", "B", "B", "B", "C", "C", "C", "C", "C" };
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String name = reader.next();
			String major = reader.next();
			double totalSubject = reader.nextDouble();
			Student student = new Student(name, major, totalSubject);
			students.add(student);
			for (int j = 0; j < totalSubject; j++) {
				student.addGrade(reader.nextDouble());
			}
		}

		Comparator<Student> studentComparator = (s1, s2) -> {
			int compare = Double.compare(s2.getAvrGrade(), s1.getAvrGrade());
			if (compare == 0) {
				compare = s1.getName().compareTo(s2.getName());
			}
			return compare;
		};

		Collections.sort(students, studentComparator);

		Map<String, Integer> scholarshipsPerMajor = new HashMap<>();
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) {
			Student student = iterator.next();
			Integer count = scholarshipsPerMajor.getOrDefault(student.getMajor(), 0);
			if (count != null && count == 2) {
				iterator.remove();
			} else {
				scholarshipsPerMajor.put(student.getMajor(), count + 1);
			}
		}

		int i = 0;
		int count = 0;
		for (Student student : students) {
			student.setScholarship(scholarship[i]);
			i++;
			count++;
			if (i == scholarship.length) {
				break;
			}
		}

		int j = 0;
		for (Student student : students) {
			str.append(student.toString()).append("\n");
			j++;
			if (j == count) {
				break;
			}
		}
		System.out.print(str);
	}

	static class Student {
		private String name;
		private String major;
		private double totalSubject;
		private double avrGrade;
		private double totalGrade;
		private String scholarship;

		public Student(String name, String major, double totalSubject) {
			this.name = name;
			this.major = major;
			this.totalSubject = totalSubject;
			this.avrGrade = 0;
			this.totalGrade = 0;
		}

		public void addGrade(double grade) {
			totalGrade += grade;
			avrGrade = totalGrade / totalSubject;
		}

		public String getName() {
			return name;
		}

		public double getAvrGrade() {
			return avrGrade;
		}

		public double getTotalGrade() {
			return totalGrade;
		}

		public String getMajor() {
			return major;
		}

		public void setScholarship(String scholarship) {
			this.scholarship = scholarship;
		}

		public void setAvrGrade(double avrGrade) {
			this.avrGrade = avrGrade;
		}

		@Override
		public String toString() {
			return name + " " + avrGrade + " " + scholarship;
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

		public float nextFloat() {
			return Float.parseFloat(next());
		}
	}
}