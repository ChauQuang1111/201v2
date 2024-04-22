import java.util.*;
import java.io.*;

public class EIUMEDARRAY4 {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int t = reader.nextInt();
        while (t-- > 0) {
            int N = reader.nextInt();
            long A = reader.nextLong();
            long P = reader.nextLong();
            long k = reader.nextLong();
            long[] arr = new long[N];
            arr[0] = (A * A) % P;
            for (int i = 1; i < N; i++) {
                arr[i] = (arr[i - 1] * A) % P;
            }
            long kthSmallest = getKthSmallestNumber(arr, 0, N - 1, k);
            str.append(kthSmallest).append("\n");
        }
        System.out.print(str);
    }

    static long getKthSmallestNumber(long[] array, int low, int high, long k) {
        long[] pivotIndices = partition(array, low, high);
        if (pivotIndices[0] - low == k - 1) {
            return array[(int) pivotIndices[0]];
        } else if (k - 1 <= pivotIndices[1] - low) {
            return getKthSmallestNumber(array, low, (int) pivotIndices[0] - 1, k);
        } else {
            return getKthSmallestNumber(array, (int) pivotIndices[1] + 1, high, k - (pivotIndices[1] - low + 1));
        }
    }

    static long[] partition(long[] array, int low, int high) {
        long pivot = array[low];
        long lt = low;
        long gt = high;
        long i = low;

        while (i <= gt) {
            if (array[(int) i] < pivot) {
                swap(array, (int) i, (int) lt);
                i++;
                lt++;
            } else if (array[(int) i] > pivot) {
                swap(array, (int) i, (int) gt);
                gt--;
            } else {
                i++;
            }
        }
        return new long[]{lt, gt};
    }

    static void swap(long[] array, int i, int j) {
        long temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
