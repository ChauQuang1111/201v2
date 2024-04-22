import java.io.*;
import java.util.*;

public class EIGRADU {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		int numberOfCredits = reader.nextInt();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < numberOfStudents; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			int course = reader.nextInt();
			List<Integer> grades = new ArrayList<>();
			for (int j = 0; j < course; j++) {
				grades.add(reader.nextInt());
			}
			students.add(new Student(id, name, course, grades));
		}

		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int gpaComparison = Integer.compare(s2.calculateGPA(s2.getGrades()), s1.calculateGPA(s1.getGrades()));
				if (gpaComparison != 0) {
					return gpaComparison;
				}
				return Integer.compare(s1.getId(), s2.getId());
			}
		});

		for (Student student : students) {
			int gpa = student.calculateGPA(student.getGrades());
			if (student.calculateCredit(student.getGrades(), numberOfCredits)) {
				str.append(student.getId()).append(" ").append(student.getName()).append(" ").append(gpa).append("\n");
			}
		}

		System.out.println(str.toString());

	}

	static class Student {
		private int id;
		private String name;
		private int course;
		private List<Integer> grades;

		public Student(int id, String name, int course, List<Integer> grades) {
			this.id = id;
			this.name = name;
			this.course = course;
			this.grades = grades;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public List<Integer> getGrades() {
			return grades;
		}

		public int calculateGPA(List<Integer> grades) {
			double totalGrade = 0;
			int passedCourses = 0;
			for (int grade : grades) {
				if (grade >= 50) {
					totalGrade += grade;
					passedCourses++;
				}
			}
			if (passedCourses == 0) {
				return 0;
			}
			return (int) Math.floor(totalGrade / passedCourses);
		}

		public boolean calculateCredit(List<Integer> grades, int neededCredit) {
			double totalGrade = 0;
			int totalCredit = 0;
			for (int grade : grades) {
				if (grade >= 50) {
					totalGrade += grade;
					totalCredit += 4;
				}
			}
			if (totalCredit >= neededCredit) {
				return true;
			}
			return false;
		}
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
