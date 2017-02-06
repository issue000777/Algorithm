package codjam2016.RoundB.B;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
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
		// caseNum = 2;

		for (int casei = 1; casei <= caseNum; casei++) {
			BigDecimal a, b, n, k;

			a = in.nextBigDecimal();
			b = in.nextBigDecimal();
			n = in.nextBigDecimal();
			k = in.nextBigDecimal();

			int result = _getResult(a, b, n, k);
			System.out.println(result);
			fw.write("Case #" + casei + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static int _getMod(int a, int n, int mod) {
		int r = 1 % mod;
		while (n > 0) {
			if (n % 2 == 1){
				n--;
				r = r * a % mod;
			}
			
			else{
				n = n/2;
				a = a * a % mod;
			}
			
			
		}
		return r % mod;
	}

	private static int _getResult(BigDecimal a, BigDecimal b, BigDecimal n, BigDecimal k) {

		BigDecimal divider = new BigDecimal("1000000007");
		BigDecimal result = BigDecimal.ZERO;

		for (int i = 1; i <= n.intValue(); i++) {
			for (int j = 1; j <= n.intValue(); j++) {
				if (i == j)
					continue;

				BigDecimal remainderA = new BigDecimal(_getMod(a.intValue(), i, k.intValue()));
				BigDecimal remainderB = new BigDecimal(_getMod(b.intValue(), j, k.intValue()));


				if (remainderA.add(remainderB).remainder(k).compareTo(BigDecimal.ZERO) == 0) {
					// System.out.println("======");
					// System.out.println(i + " : " + j);
					// System.out.println(remainderA + " : " + remainderB);
					result = result.add(BigDecimal.ONE);
				}

			}
		}

		return result.remainder(divider).intValue();
	}

}
