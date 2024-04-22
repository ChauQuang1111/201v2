import java.util.*;
import java.io.*;

public class EIUGRDSA2 {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfStudents = reader.nextInt();
		int numberOfProblems = reader.nextInt();
		int numberOfSubmissions = reader.nextInt();

		int[] studentsArray = new int[numberOfStudents];
		int[] problemsArray = new int[numberOfProblems];

		for (int i = 0; i < studentsArray.length; i++) {
			studentsArray[i] = reader.nextInt();
		}
		for (int i = 0; i < problemsArray.length; i++) {
			problemsArray[i] = reader.nextInt();
		}

		Map<Integer, Student> students = new HashMap<>();
		for (int studentID : studentsArray) {
			students.put(studentID, new Student(studentID));
		}

		Map<Integer, Integer> validSubmissions = new HashMap<>();
		for (int i = 0; i < numberOfSubmissions; i++) {
			int studentID = reader.nextInt();
			int courseID = reader.nextInt();
			int grade = reader.nextInt();
			Student student = students.get(studentID);
			if (student != null) {
				if (student.submissions == null) {
					student.submissions = new HashMap<>();
				}
				student.submissions.put(courseID, Math.max(grade, student.submissions.getOrDefault(courseID, 0)));
			}
			validSubmissions.put(studentID, validSubmissions.getOrDefault(studentID, 0) + 1);

		}

		Map<Integer, Double> averageScore = new HashMap<>();
		for (Map.Entry<Integer, Student> entry : students.entrySet()) {
			int studentID = entry.getKey();
			Student student = entry.getValue();
			if (student.submissions != null) {
				double totalScore = 0;
				for (int grade : student.submissions.values()) {
					totalScore += grade;
				}
				double avgScore = totalScore / numberOfProblems;
				averageScore.put(studentID, avgScore);
			}
		}

		List<Map.Entry<Integer, Double>> sortedStudents = new ArrayList<>(averageScore.entrySet());
		Collections.sort(sortedStudents, new Comparator<Map.Entry<Integer, Double>>() {
			@Override
			public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
				int result = Double.compare(e2.getValue(), e1.getValue());
				if (result != 0) {
					return result;
				}

				int count1 = validSubmissions.get(e1.getKey());
				int count2 = validSubmissions.get(e2.getKey());
				result = Integer.compare(count1, count2);
				if (result != 0) {
					return result;
				}

				return Integer.compare(e1.getKey(), e2.getKey());
			}
		});

		for (Map.Entry<Integer, Double> entry : sortedStudents) {
			int studentID = entry.getKey();
			double avgScore = entry.getValue();
			str.append(studentID).append(" ").append((int) avgScore).append(" ").append(validSubmissions.get(studentID))
					.append("\n");
		}

		System.out.print(str);

	}

	static class Student {
		private int studentID;
		private Map<Integer, Integer> submissions;

		public Student(int studentID) {
			this.studentID = studentID;
		}

		public int getStudentID() {
			return studentID;
		}

		public void setStudentID(int studentID) {
			this.studentID = studentID;
		}

		public Map<Integer, Integer> getSubmissions() {
			return submissions;
		}

		public void setSubmissions(Map<Integer, Integer> submissions) {
			this.submissions = submissions;
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
