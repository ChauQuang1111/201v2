import java.util.*;
import java.io.*;

public class EIUONCE {
	static InputReader reader = new InputReader(System.in);

    public static void main(String[] args) {
    	StringBuilder str = new StringBuilder();
    	int t = reader.nextInt();
    	for (int i = 0; i<t; i++) {
    		int n = reader.nextInt(); 
    		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>((l1, l2) -> l1.compareTo(l2));
    		for (int j = 0; j<n; j++) {
    			int number = reader.nextInt();
    			map.put(number, map.getOrDefault(number, 0)+1);
    		}
    		for (int occurrence : map.keySet()) {
    			if (map.get(occurrence)==1) {
    				str.append(occurrence).append(" ");
    			}
    		}
    		str.append("\n");
    	}
    	System.out.println(str);
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




