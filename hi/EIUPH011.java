import java.util.*;

public class EIUPH011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] a = new long[n];
        Set<Long> seenValues = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            long value = a[i];
            if (seenValues.add(value)) {
                System.out.print(value + " ");
            }
        }

        scanner.close();
    }
}
