import java.util.*;
import java.io.*;

public class EIUQUISORTp2 {

    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int n = reader.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = reader.nextInt();
        }
        quickSort(array, 0, n - 1);
        for (int num : array) {
            str.append(num).append("\n");
        }
        System.out.print(str);
    }

    static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivot = medianOfThree(array, start, end);
            int pivotIndex = partition(array, start, end, pivot);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }

    static int medianOfThree(int[] array, int start, int end) {
        int mid = start + (end - start) / 2;
        if (array[start] > array[mid]) {
            if (array[mid] > array[end]) {
                return mid;
            } else if (array[start] > array[end]) {
                return end;
            } else {
                return start;
            }
        } else {
            if (array[start] > array[end]) {
                return start;
            } else if (array[mid] > array[end]) {
                return end;
            } else {
                return mid;
            }
        }
    }

    static int partition(int[] array, int start, int end, int pivot) {
        int pivotValue = array[pivot];
        swap(array, pivot, end);

        int i = start;
        for (int j = start; j < end; j++) {
            if (array[j] <= pivotValue) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, end);
        return i;
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
