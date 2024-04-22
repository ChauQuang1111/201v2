import java.util.*;
import java.io.*;

public class EISTULI {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		int numberOfTopStudents = reader.nextInt();

		List<Student> students = new ArrayList<>();
		for (int i = 0; i < numberOfStudents; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			int courses = reader.nextInt();
			List<Integer> grades = new ArrayList<>();
			for (int j = 0; j < courses; j++) {
				grades.add(reader.nextInt());
			}
			Student student = new Student(i, id, name, courses, grades);
			students.add(student);
		}

		Comparator<Student> studentComparator = (s1, s2) -> {
			double compare = s2.calculateGpa() - s1.calculateGpa();
			if (compare == 0) {
				compare = s1.getOrder() - s2.getOrder();
			}
			return (int) compare;
		};

		students.sort(studentComparator);
		
		int count = 0;
		double kthGPA = students.get(numberOfTopStudents - 1).calculateGpa();
		for (Student student : students) {
			if (student.calculateGpa() >= kthGPA) {
				count++;
			}
		}

		int numberOfSameGPA = 0;
		if (count > numberOfTopStudents) {
			double previousGPA = -1;
			for (int i = 0; i < count; i++) {
				Student student = students.get(i);
				double currentGPA = student.calculateGpa();
				if (currentGPA != previousGPA) {
					previousGPA = currentGPA;
					numberOfSameGPA = 1;
				} else {
					numberOfSameGPA++;
				}
			}
			count -= numberOfSameGPA;
		}

		for (int i = 0; i < count; i++) {
			Student student = students.get(i);
			str.append(student.getId()).append(" ").append(student.getName()).append(" ")
					.append(Math.round(student.calculateGpa())).append(" ").append(student.getCredits()).append("\n");
		}
		System.out.println(str);
	}

	static class Student {
		private int order;
		private int id;
		private String name;
		private int courses;
		private List<Integer> grades;

		public Student (int order, int id, String name, int courses, List<Integer> grades) {
			this.id = id;
			this.name = name;
			this.courses = courses;
			this.grades = grades;
		}

		public int getId() {
			return id;
		}

		public int getOrder() {
			return order;
		}

		public String getName() {
			return name;
		}

		public double calculateGpa() {
			int totalGrade = 0;
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
			return (double) totalGrade / passedCourses;
		}

		public int getTotalGrade() {
			int totalGrade = 0;
			for (int grade : grades) {
				totalGrade += grade;
			}
			return totalGrade;
		}

		public int getCourses() {
			return courses;
		}

		public int getCredits() {
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

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
