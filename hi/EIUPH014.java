import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EIUPH014 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 1;
		StringBuilder str = new StringBuilder();
		while (n != 0) {
			n = scanner.nextInt();
			if (n==0) {
				break;
			}
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			int count = 0;
			int temp = 0;
			while (checkArray(a) && n != 0) {
				temp = a[0];
				for (int i = 0; i < a.length - 1; i++) {
					a[i] = Math.abs(a[i] - a[i + 1]);
				}
				a[n - 1] = Math.abs(a[n - 1] - temp);
				count++;
				if (count >= 1000) {
					count = -1;
					break;
				}
			}
			str.append(count + "\n");
		}
		System.out.println(str);
	}

	public static boolean checkArray(int[] a) {
		Set<Integer> seenValues = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			seenValues.add(a[i]);
		}
		if (seenValues.size() == 1) {
			return false;
		} else {
			return true;
		}
	}
}
