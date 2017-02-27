package kickstart2017.PracticeRound.B;

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

		BigDecimal[][] map = new BigDecimal[2001][2001];

		for (int i = 1; i <= 2000; i++) {
			map[i][0] = BigDecimal.ONE;
		}
		for (int i = 0; i <= 2000; i++) {
			for (int j = i; j <= 2000; j++) {
				map[i][j] = BigDecimal.ZERO;
			}
		}
		for (int i = 1; i <= 2000; i++) {
			for (int j = 1; j < i; j++) {
				map[i][j] = new BigDecimal(i).multiply(map[i - 1][j])
						.divide(new BigDecimal(i + j), MathContext.DECIMAL128).add(
								new BigDecimal(j).multiply(map[i][j-1]).divide(new BigDecimal(i + j), MathContext.DECIMAL128));
			}
		}
		
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}


		for (int i = 1; i <= caseNum; i++) {

			int N = in.nextInt();
			int M = in.nextInt();

			BigDecimal result = _getResult(map, N, M);
			result = result.setScale(8, RoundingMode.HALF_EVEN);
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static BigDecimal _getResult(BigDecimal[][] map, int N, int M) {

		return map[N][M];

	}

}
