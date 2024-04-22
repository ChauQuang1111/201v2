import java.util.*;
import java.io.*;

public class EITASKDIS {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		int totalEmployees = reader.nextInt();
		int totalTask = reader.nextInt();

		List<Employee> employees = new ArrayList<>();
		PriorityQueue<Employee> employeesQueue = new PriorityQueue<Employee>((s1, s2) -> {
			int compare = s1.getTime() - s2.getTime();
			if(compare == 0) {
				compare = s1.getPosition() - s2.getPosition();
			}
			return compare;
		});

		for (int i = 0; i < totalEmployees; i++) {
			Employee employee = new Employee(i);
			employees.add(employee);
			employeesQueue.add(employee);
		}

		List<Integer> tasks = new ArrayList<>();
		for (int i = 0; i < totalTask; i++) {
			int value = reader.nextInt();
			tasks.add(value);
		}
		tasks.sort((t1, t2) -> t2.compareTo(t1));

		for (int task : tasks) {
			Employee employee = employeesQueue.poll();
			employee.addTime(task);
			employeesQueue.offer(employee);
		}

		for (Employee employee : employees) {
		    str.append(employee.getTime()).append(" ");
		}

		System.out.print(str);
	}

	static class Employee {
		private int time;
		private int position;

		public Employee(int position) {
			this.time = 0;
			this.position = position;
		}

		public int getTime() {
			return time;
		}

		public void setTime(int time) {
			this.time = time;
		}

		public int getPosition() {
			return position;
		}

		public void setPosition(int position) {
			this.position = position;
		}

		public void addTime(int time) {
			this.time += time;
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