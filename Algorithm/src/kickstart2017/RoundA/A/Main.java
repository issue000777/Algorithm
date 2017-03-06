package kickstart2017.RoundA.A;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

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

			int R = in.nextInt();
			int C = in.nextInt();

			BigDecimal result = _getResult(R, C);
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static BigDecimal _getResult(int R, int C) {

		BigDecimal result = BigDecimal.ZERO;

		int i = 1;
		while (R - i > 0 && C - i > 0) {
			result = result.add(new BigDecimal((R - i) * (C - i)));
			i++;

		}

		for (int m = 1; m < Math.min(R, C); m++) {
			for (int n = 1; n < Math.min(R, C); n++) {

				if (m + n < Math.min(R, C)) {
					result = result.add(new BigDecimal((R - m - n) * (C - m - n)));
				}

			}
		}

		return result.remainder(new BigDecimal("1000000007"));
	}
	

}
