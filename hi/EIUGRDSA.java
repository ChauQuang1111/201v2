import java.util.*;
import java.io.*;

public class EIUGRDSA {
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

		Map<Integer, Map<Integer, Integer>> submissions = new HashMap<>();
		for (int studentID : studentsArray) {
			submissions.put(studentID, new HashMap<>());
		}

		for (int i = 0; i < numberOfSubmissions; i++) {
			int studentID = reader.nextInt();
			int courseID = reader.nextInt();
			int grade = reader.nextInt();
			submissions.get(studentID).put(courseID,
					Math.max(grade, submissions.get(studentID).getOrDefault(courseID, 0)));
		}

		Map<Integer, Integer> averageScore = new HashMap<>();
		for (Map.Entry<Integer, Map<Integer, Integer>> entry : submissions.entrySet()) {
			double totalScore = 0;
			for (int grade : entry.getValue().values()) {
				totalScore += grade;
			}
			averageScore.put(entry.getKey(), (int) totalScore / numberOfProblems);
		}

		List<Map.Entry<Integer, Integer>> sortedStudents = new ArrayList<>(averageScore.entrySet());
		Collections.sort(sortedStudents, Comparator.comparing(Map.Entry::getKey));

		for (Map.Entry<Integer, Integer> entry : sortedStudents) {
			str.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}

		System.out.print(str);

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
