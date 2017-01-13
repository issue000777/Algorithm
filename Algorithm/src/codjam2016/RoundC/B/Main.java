package codjam2016.RoundC.B;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

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
			int r, c, k;

			r = in.nextInt();
			c = in.nextInt();
			k = in.nextInt();

			int[][] map = new int[r][c];

			for (int i = 0; i < k; i++) {
				int m = in.nextInt();
				int n = in.nextInt();
				map[m][n] = 1;
			}

			int result = _getResult(map);
			System.out.println(result);
			fw.write("Case #" + casei + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static int _getResult(int[][] map) {

		int result = 0;

		int i = 0;
		int j = 0;
		while (i < map.length) {
			while (j < map[0].length) {
				for (int d = 1; d <= map.length; d++) {
					if (_isAvailable(map, d, i, j))
						result++;
					else
						break;
					System.out.println(result);
				}
				j++;
			}
			i++;
		}

		return result;
	}

	private static boolean _isAvailable(int[][] map, int d, int m, int n) {

		for (int i = m; i < m + d; i++) {
			for (int j = n; j < n + d; j++) {
				if (i >= map.length || j >= map[0].length || map[i][j] == 1)
					return false;

			}
		}

		return true;
	}

}
