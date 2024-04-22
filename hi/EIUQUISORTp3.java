import java.util.*;
import java.io.*;

public class EIUQUISORTp3 {

    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }
        shuffle(array);
        quickSort(array, 0, n - 1);
        for (int num : array) {
            str.append(num).append("\n");
        }
        System.out.print(str);
    }

    static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int[] pivotIndices = partition(array, low, high);
            quickSort(array, low, pivotIndices[0] - 1);
            quickSort(array, pivotIndices[1] + 1, high);
        }
    }

    static int[] partition(int[] array, int low, int high) {
        int pivot = array[low];
        int lt = low;
        int gt = high;
        int i = low;

        while (i <= gt) {
            if (array[i] < pivot) {
                swap(array, i, lt);
                i++;
                lt++;
            } else if (array[i] > pivot) {
                swap(array, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        return new int[] {lt, gt};
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    static void shuffle(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(array, i, index);
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

        public float nextFloat() {
            return Float.parseFloat(next());
        }
    }
}
