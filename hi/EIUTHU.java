import java.util.*;
import java.io.*;

public class EIUTHU {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String m = scanner.next();
		String n = scanner.next();
		int dem = 0;
		for (int i = 0; i < m.length(); i++) {
			if (n.indexOf(m.substring(i, m.length())) == 0) {
				dem = m.length() - i;
				break;
			}
		}
		System.out.print(m.length() + n.length() - dem + " ");

	}
}