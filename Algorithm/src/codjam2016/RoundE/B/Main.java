package codjam2016.RoundE.B;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	static Long n;

	public static void main(String[] args) throws Exception {

		boolean isSmall = false;

		String str = isSmall == true ? "small" : "large";
		String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
		path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
		Scanner in = new Scanner(new File(path + ".in"));
		FileWriter fw = new FileWriter(new File(path + ".out"));

		int caseNum = in.nextInt();
		// caseNum = 1;

		for (int i = 1; i <= caseNum; i++) {

			n = in.nextLong();

			Long result = _getResult(n);
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static boolean _isBeautiful(Long x) {
		Long tmp = n;
		while (tmp > 1) {
			if (tmp % x != 1)
				return false;
			tmp /= x;
		}
		return true;
	}

	private static Long _getResult(Long n) {

		for (int i = 2; i <= n && i <= 1000000; i++) {
			if (_isBeautiful((long) i)) {
				return (long) i;
			}
		}
		Long x = (long) Math.pow(n, 1 / 3.0);
		if (_isBeautiful(x)) {
			return x;
		}
		x = (long) Math.pow(n, 0.5);
		if (_isBeautiful(x)) {
			return x;
		}

		return n - 1;
	}
}
