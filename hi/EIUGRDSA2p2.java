import java.util.*;
import java.io.*;

public class EIUGRDSA2p2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		int numberOfProblems = reader.nextInt();
		int numberOfSubmissions = reader.nextInt();

		Map<Integer, Student> studentMap = new HashMap<>();
		Map<String, String > problemMap = new HashMap<>();

		for (int i = 0; i < numberOfStudents; i++) {
			int studentID = reader.nextInt();
			Student student = new Student(studentID, numberOfProblems);
			studentMap.put(studentID, student);
		}
		
		for (int i = 0; i < numberOfProblems; i++) {
			String problemCode = reader.next();
			problemMap.put(problemCode, problemCode);
		}

		for (int i = 0; i < numberOfSubmissions; i++) {
			int studentID = reader.nextInt();
			String problemCode = reader.next();
			int grade = reader.nextInt();
			Student tempStudent = studentMap.get(studentID);
			String tempProblemCode = problemMap.get(problemCode);
			if (tempProblemCode != null) {
				tempStudent.addGrade(tempProblemCode, grade);
			}
		}
		
		List<Student> students = new ArrayList<>(studentMap.values());
		Comparator<Student> studentComparator = (s1, s2) -> {
			int compare = (int) s2.getAverageGrades() -  s1.getAverageGrades();
			if (compare == 0) {
				compare = s1.getTotalSubmissions() - s2.getTotalSubmissions();
				if (compare == 0) {
					compare = s1.getStudentID() - s2.getStudentID();
				}
			}
			return compare;
		};
		Collections.sort(students, studentComparator);

		
		for (Student student : students) {
			str.append(student.getStudentID()).append(" ").append(student.getAverageGrades()).append(" ").append(student.getTotalSubmissions()).append("\n");
		}

		System.out.print(str);

	}

	static class Student {
		private int studentID;
		private int totalProblems;
		private double totalGrades;
		private double averageGrades;
		private int totalSubmissions;
		private Map<String, Integer> grades = new HashMap<String, Integer>();

		public Student(int studentID, int totalProblems) {
			this.studentID = studentID;
			this.totalProblems = totalProblems;
			this.totalGrades = 0;
			this.averageGrades = 0;
			this.totalSubmissions = 0;
		}

		public void addGrade(String problemCode, int grade) {
			int oldGrade = grades.getOrDefault(problemCode, 0);
			if (grade >= oldGrade) {
				grades.put(problemCode, grade);
				totalGrades += (grade - oldGrade);
				averageGrades = Math.floor(totalGrades / totalProblems);
			}
			this.totalSubmissions++;
		}

		public int getStudentID() {
			return studentID;
		}

		public int getAverageGrades() {
			return (int) this.averageGrades;
		}

		public int getTotalSubmissions() {
			return totalSubmissions;
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
