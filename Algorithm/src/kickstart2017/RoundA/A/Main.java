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
		

		boolean isSmall = true;

		String str = isSmall == true ? "small" : "large";
		String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
		path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
		Scanner in = new Scanner(new File(path + ".in"));
		FileWriter fw = new FileWriter(new File(path + ".out"));

		int caseNum = in.nextInt();
		// caseNum = 1;

		for (int i = 1; i <= caseNum; i++) {

			BigDecimal R = in.nextBigDecimal();
			BigDecimal C = in.nextBigDecimal();

			BigDecimal result = _getResultLarge(R, C);
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static BigDecimal _getResult(BigDecimal R, BigDecimal C) {

		BigDecimal result = BigDecimal.ZERO;
		

		int i = 1;
		while (R.intValue() - i > 0 && C.intValue() - i > 0) {
			result = result.add(new BigDecimal((R.intValue() - i) * (C.intValue() - i)));
			i++;

		}

		for (int m = 1; m < Math.min(R.intValue(), C.intValue()); m++) {
			for (int n = 1; n < Math.min(R.intValue(), C.intValue()); n++) {

				if (m + n < Math.min(R.intValue(), C.intValue())) {
					result = result.add(new BigDecimal((R.intValue() - m - n) * (C.intValue() - m - n)));
				}

			}
		}
		
		
		return result.remainder(new BigDecimal("1000000007"));
	}
	
	private static BigDecimal _getResultLarge(BigDecimal R, BigDecimal C) {

		BigDecimal result = BigDecimal.ZERO;
		
		BigDecimal n = R.subtract(BigDecimal.ONE).compareTo(C.subtract(BigDecimal.ONE)) < 0 ? R.subtract(BigDecimal.ONE) : C.subtract(BigDecimal.ONE); 
		
		BigDecimal nPlusOne = n.add(BigDecimal.ONE);
		BigDecimal twoNPlusOne = n.multiply(new BigDecimal(2)).add(BigDecimal.ONE);
		BigDecimal result1 = n.multiply(n).multiply(nPlusOne).multiply(nPlusOne).divide(new BigDecimal(4));
		BigDecimal result2 = R.add(C).multiply(n).multiply(nPlusOne).multiply(twoNPlusOne).divide(new BigDecimal(6));
		BigDecimal result3 = R.multiply(C).multiply(n).multiply(nPlusOne).divide(new BigDecimal(2));
		result = result1.subtract(result2).add(result3);
		
		return result.remainder(new BigDecimal("1000000007"));
	}
	

}
