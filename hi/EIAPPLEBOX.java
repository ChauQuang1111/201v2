import java.util.*;
import java.io.*;

public class EIAPPLEBOX {
    static InputReader reader = new InputReader(System.in);
    static StringBuilder str = new StringBuilder();

    public static void main(String[] args) {
        int t = reader.nextInt();
        while (t-- > 0) {
            int N = reader.nextInt();
            long A = reader.nextLong();
            long P = reader.nextLong();
            long[] arr = new long[N];
            arr[0] = (A * A) % P;
            for (int i = 1; i < N; i++) {
                arr[i] = (arr[i - 1] * A) % P;
            }
            long inversionCount = mergeSort(arr, 0, N - 1);
            str.append(inversionCount).append("\n");
        }
        System.out.print(str);
    }

    static long mergeSort(long[] arr, int left, int right) {
        long inversionCount = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;
            inversionCount += mergeSort(arr, left, mid);
            inversionCount += mergeSort(arr, mid + 1, right);
            inversionCount += merge(arr, left, mid, right);
        }
        return inversionCount;
    }

    static long merge(long[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        long[] L = new long[n1];
        long[] R = new long[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        long count = 0; 
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                count += n1 - i;
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return count;
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
