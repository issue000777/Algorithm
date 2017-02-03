package codjam2016.RoundB.A;

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
		//caseNum = 2;

		for (int casei = 1; casei <= caseNum; casei++) {
			int l, r;

			l = in.nextInt();
			r = in.nextInt();


			int result = _getResult(l, r);
			System.out.println(result);
			fw.write("Case #" + casei + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static int _getResult(int l, int r) {


		int n = Math.min(l, r);
		
		return n*(n+1)/2;
	}

}
