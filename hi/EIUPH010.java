import java.util.*;
import java.io.*;

public class EIUPH010 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		int n = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		Arrays.sort(a);
		long max = 1;
		long count = 1;
		long temp = a[0];
		for (int i = 0; i < n - 1; i++) {
			if (a[i] == a[i + 1]) {
				count++;
			} else {
				count = 1;
			}
			if (max < count) {
				max = count;
				temp = a[i];
			} else if (max == count) {
				if (temp >= a[i]) {
					temp = a[i];
				}
			}
		}
		str.append(temp + " " + max);
		System.out.print(str);
	}
}
