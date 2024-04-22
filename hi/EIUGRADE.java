import java.io.*;
import java.util.*;

public class EIUGRADE {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int numberOfGrades = reader.nextInt();
		Map<Integer, List<Grade>> studentGrades = new HashMap<>();

		for (int i = 0; i < numberOfGrades; i++) {
			int studentID = reader.nextInt();
			int courseID = reader.nextInt();
			double courseGrade = reader.nextDouble();
			if (!studentGrades.containsKey(studentID)) {
				studentGrades.put(studentID, new ArrayList<>());
			}
			studentGrades.get(studentID).add(new Grade(courseID, courseGrade));
		}

		Map<Integer, Double> avrGrades = new HashMap<>();
		for (Map.Entry<Integer, List<Grade>> entry : studentGrades.entrySet()) {
			double totalGrade = 0;
			List<Grade> grades = entry.getValue();
			for (Grade grade : grades) {
				totalGrade += grade.grade;
			}
			double avrGrade = totalGrade / grades.size();
			avrGrades.put(entry.getKey(), avrGrade);
		}
		
		
		List<Map.Entry<Integer, Double>> sortedStudents = new ArrayList<>(avrGrades.entrySet());
		Collections.sort(sortedStudents, (a,b) -> {
			int cmp = Double.compare(b.getValue(), a.getValue());
			if (cmp==0) {
				return a.getKey().compareTo(b.getKey());
			}
			return cmp;
		});
		
		for (Map.Entry<Integer, Double> entry : sortedStudents) {
			str.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		
		System.out.print(str);
		
		

	}

	static class Grade {
		private int courseID;
		private double grade;

		public Grade(int courseID, double grade) {
			this.courseID = courseID;
			this.grade = grade;
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
