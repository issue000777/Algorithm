package kickstart2017.RoundA.B;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		boolean isSmall = true;

		String str = isSmall == true ? "small" : "large";
		String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
		path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
		Scanner in = new Scanner(new File(path + ".in"));
		FileWriter fw = new FileWriter(new File(path + ".out"));

		int caseNum = in.nextInt();
		// caseNum = 1;

		for (int i = 1; i <= caseNum; i++) {

			String s1 = in.next();
			String s2 = in.next();

			Boolean out = _getResult(s1, s2);
			String result = out ? "TRUE" : "FALSE";
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static boolean _getResultLarge(String s1, String s2) {
		int[][] map = new int[s1.length()][s2.length()];

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {

			}
		}

		return map[s1.length() - 1][s2.length() - 1] == 1 ? true : false;
	}

	private static boolean _getResult(String s1, String s2) {

		if (s1.isEmpty() && s2.isEmpty()) {
			return true;
		}

		if (s1.isEmpty()) {
			for (byte c : s2.getBytes()) {
				if (c != '*')
					return false;
			}

			return true;
		}

		if (s2.isEmpty()) {
			for (byte c : s1.getBytes()) {
				if (c != '*')
					return false;
			}

			return true;
		}

		boolean rtn = false;

		if (s1.substring(0, 1).equals("*") || s2.substring(0, 1).equals("*")) {
			if (s1.substring(0, 1).equals("*")) {

				int diff = 0;
				int i = 0;
				while (true) {
					if (i <= s2.length() && diff <= 4) {
						rtn |= _getResult(s1.substring(1), s2.substring(i));

						if (!s2.substring(i).isEmpty() && !s2.substring(i, i + 1).equals("*"))
							diff++;
						i++;
					} else {
						break;
					}

				}

			}

			if (s2.substring(0, 1).equals("*")) {
				int diff = 0;
				int i = 0;
				while (true) {
					if (i <= s1.length() && diff <= 4) {
						rtn |= _getResult(s1.substring(i), s2.substring(1));

						

						if (!s1.substring(i).isEmpty() && !s1.substring(i, i + 1).equals("*"))
							diff++;
						i++;
					}
					
					else {
						break;
					}


				}
			}
			return rtn;
		}

		if (s1.substring(0, 1).equals(s2.substring(0, 1))) {
			return _getResult(s1.substring(1), s2.substring(1));
		}

		return false;

	}

}
