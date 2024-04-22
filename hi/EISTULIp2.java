import java.util.*;
import java.io.*;

public class EISTULIp2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		var numberOfStudents = reader.nextInt();
		var numberOfTopStudents = reader.nextInt();
		var students = new ArrayList<Student>();

		for (var i = 0; i < numberOfStudents; i++) {
			var studentID = reader.nextLong();
			var studentName = reader.next();
			var course = reader.nextInt();
			var student = new Student(studentID, studentName);

			for (var j = 0; j < course; j++) {
				var grade = reader.nextInt();
				student.addGrade(grade);
			}
			students.add(student);
		}
		students.sort((s1, s2) -> {
			return Double.compare(s2.GPA, s1.GPA);
		});

		if (numberOfStudents > numberOfTopStudents) {
			var pivot = students.get(numberOfTopStudents);
			for (var k = 0; k < numberOfTopStudents; k++) {
				var topStudent = students.get(k);
				if (topStudent.GPA == pivot.GPA) {
					break;
				}
				str.append(topStudent).append("\n");
			}
		} else {
			for (var student : students) {
				str.append(student).append("\n");
			}
		}
		System.out.println(str);
	}

	static class Student {
		public long studentID;
		public String studentName;
		public int totalCourse = 0;
		public int totalGrade = 0;
		public double GPA;
		public int credit;

		public Student(long ID, String name) {
			studentID = ID;
			studentName = name;
		}

		public void addGrade(int grade) {
			if (grade >= 50) {
				totalCourse++;
				totalGrade += grade;
				GPA = (double) totalGrade / totalCourse;
				credit += 4;
			}
		}

		@Override
		public String toString() {
			return studentID + " " + studentName + " " + Math.round(GPA) + " " + credit;
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