import java.util.*;
import java.io.*;

public class EIDORM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder str = new StringBuilder();
		int n = sc.nextInt();
		int room = 1;
		int count = 0;
		while (room<=n) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			if (p+2<=q) {
				count++;
			}
			room++;
		}
		str.append(count);
		System.out.println(str);

	}
}
