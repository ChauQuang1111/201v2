import java.util.*;
import java.io.*;

public class EISCHSH {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		int numberOfScholarship = reader.nextInt();

		List<Student> students = new ArrayList<>();
		for (int i = 0; i < numberOfStudents; i++) {
			int id = reader.nextInt();
			String name = reader.next();
			double courses = reader.nextDouble();
			List<Integer> grades = new ArrayList<>();
			for (int j = 0; j < courses; j++) {
				grades.add(reader.nextInt());
			}
			Student student = new Student(id, name, courses, grades);
			students.add(student);
		}

		Comparator<Student> studentComparator = (s1, s2) -> {
			double compare = s2.calculateGpa() - s1.calculateGpa();
			if (compare == 0) {
				compare = s1.getId() - s2.getId();
			}
			return (int) compare;
		};
        students.sort(studentComparator);

        int currentRank = 1;
        double previousGPA = -1; 
        for (int i = 0; i < Math.min(numberOfScholarship, students.size()); i++) {
            Student student = students.get(i);
            double currentGPA = student.calculateGpa();
            if (currentGPA != previousGPA) {
                currentRank = i + 1;
                previousGPA = currentGPA;
            }
            str.append(currentRank).append(" ").append(student.getId()).append(" ").append(student.getName()).append(" ").append(Math.round(currentGPA)).append("\n");
        }

        System.out.println(str);
	}

	static class Student {
		private int id;
		private String name;
		private double course;
		private double totalGrade;
		private double gpa;
		private List<Integer> grades = new ArrayList<>();

		public Student(int id, String name, double course, List<Integer> grades) {
			super();
			this.id = id;
			this.name = name;
			this.course = course;
			this.totalGrade = 0;
			this.gpa = 0;
			this.grades = grades;
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public double getCourse() {
			return course;
		}

		public double calculateGpa() {
			double passedCourses = 0;
			double totalGrade = 0;
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

		public List<Integer> getGrades() {
			return grades;
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
