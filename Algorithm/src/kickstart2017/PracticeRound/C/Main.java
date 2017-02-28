package kickstart2017.PracticeRound.C;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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

			BigDecimal L = in.nextBigDecimal();
			BigDecimal R = in.nextBigDecimal();

			BigDecimal result = _getResult(L, R);
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static BigDecimal _getResult(BigDecimal N, BigDecimal M) {

		BigDecimal tmp = N.compareTo(M) < 0 ? N : M;
		return tmp.multiply(tmp.add(BigDecimal.ONE)).divide(new BigDecimal(2));

	}

}
