import java.io.*;
import java.util.*;

public class EICREDIT {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < numberOfStudents; i++) {
			String studentName = reader.next();
			int totalSubject = reader.nextInt();
			List<Integer> grades = new ArrayList<>();
			for (int j = 0; j < totalSubject; j++) {
				grades.add(reader.nextInt());
			}
			Student student = new Student(studentName, totalSubject, grades);
			students.add(student);
		}
		for (Student student : students) {
			str.append(student.getStudentName()).append(" ").append(student.calculateCredits(student.getGrades())).append("\n");
		}
		System.out.print(str);
	}

	static class Student {
		private String studentName;
		private int totalSubject;
		List<Integer> grades = new ArrayList<>();

		public Student(String studentName, int totalSubject, List<Integer> grades) {
			this.studentName = studentName;
			this.totalSubject = totalSubject;
			this.grades = grades;
		}

		public String getStudentName() {
			return studentName;
		}

		public List<Integer> getGrades() {
			return grades;
		}


		public int calculateCredits(List<Integer> grades) {
			int totalCredit = 0;
			for (int grade : grades) {
				if (grade >= 50) {
					totalCredit += 4;
				}
			}
			return totalCredit;
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
