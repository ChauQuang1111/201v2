import java.io.*;
import java.util.*;

public class EIUSLSp2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		List<Student> students = new ArrayList<>();

		for (int i = 0; i < numberOfStudents; i++) {
			String name = reader.next();
			int course = reader.nextInt();
			Student student = new Student(i, name, course);
			students.add(student);
			for (int j = 0; j < course; j++) {
				student.calculateTotalGrade(reader.nextDouble());
			}
		}

		Collections.sort(students, (Comparator<Student>) (Student s1, Student s2) -> {
			int compare = Double.compare(s1.calculateGPA(s1.getTotalGrade()), s2.calculateGPA(s2.getTotalGrade()));
			if (compare == 0) {
				compare = s2.getRollNum() - s1.getRollNum();
			}
			return compare;
		});

		int index = numberOfStudents;
		int count = 0;
		while (index > 0 && count < 2) {
			str.append(students.get(index - 1).getStudentName()).append("\n");
			index--;
			count++;
		}
		System.out.print(str);

	}

	static class Student {
		private int rollNum;
		private String studentName;
		private int course;
		private double totalGrade;

		public Student(int rollNum, String studentName, int course) {
			this.rollNum = rollNum;
			this.studentName = studentName;
			this.course = course;
		}

		public int getRollNum() {
			return rollNum;
		}

		public String getStudentName() {
			return studentName;
		}

		public int getCourse() {
			return course;
		}

		public double getTotalGrade() {
			return totalGrade;
		}

		public double calculateTotalGrade(double grade) {
			return this.totalGrade += grade;
		}

		public double calculateGPA(double totalPoint) {
			return (double) totalPoint / this.course;
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
