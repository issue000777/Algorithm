package codjam2016.RoundC.A;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {

		boolean isSmall = false;

		String str = isSmall == true ? "small" : "large";
		String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
		path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
		Scanner in = new Scanner(new File(path + ".in"));
		FileWriter fw = new FileWriter(new File(path + ".out"));

		int caseNum = in.nextInt();
		//caseNum = 2;

		for (int casei = 1; casei <= caseNum; casei++) {
			int r, c, rs, cs, s;
			double p, q;

			r = in.nextInt();
			c = in.nextInt();
			rs = in.nextInt();
			cs = in.nextInt();
			s = in.nextInt();
			p = in.nextDouble();
			q = in.nextDouble();

			char[][] map = new char[r][c];
			int[][] pathMap = new int[r][c];

			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++)
					map[i][j] = in.next().charAt(0);

			double result = _getResult(map, pathMap, p, q, rs, cs, s, true);
			result = new BigDecimal(result).setScale(7, BigDecimal.ROUND_UP).doubleValue();
			System.out.println(result);
			fw.write("Case #" + casei + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static double _getResult(char[][] map, int[][] path, double p, double q, int rs, int cs, int s,
			boolean isFirst) {

		if (s < 0 || rs < 0 || cs < 0 || rs >= map.length || cs >= map[0].length)
			return 0;

		double cur = 0;
		double prob = map[rs][cs] == 'A' ? p : q;

		if (!isFirst) {
			cur = Math.pow(1 - prob, path[rs][cs]) * prob;
			path[rs][cs] = path[rs][cs] + 1;
		}
	 
		double result = 0;
		for (int i = 0; i < dir.length; i++) {

			int[][] pathCopy = new int[path.length][path[0].length];
			for (int j = 0; j < path.length; j++)
				for (int k = 0; k < path[0].length; k++)
					pathCopy[j][k] = path[j][k];

			double tmp = _getResult(map, pathCopy, p, q, rs + dir[i][0], cs + dir[i][1], s - 1, false);
			result = tmp > result ? tmp : result;
		}

		
		return cur + result;
	}

}
