package codjam2016.RoundC.B;

import java.io.File;
import java.io.FileWriter;
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
		//caseNum = 1;

		for (int casei = 1; casei <= caseNum; casei++) {
			int r, c, k;

			r = in.nextInt();
			c = in.nextInt();
			k = in.nextInt();

			int[][] map = new int[r + 1][c + 1];
			int[][] count = new int[r + 1][c + 1];

			for (int i = 0; i < k; i++) {
				int m = in.nextInt();
				int n = in.nextInt();
				map[m + 1][n + 1] = 1;
			}

			long result = _getResult(map, count);
			
			
			
			System.out.println(result);

			fw.write("Case #" + casei + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static long _getResult(int[][] map, int[][] count) {

		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					count[i][j] = 0;
				} else {
					count[i][j] = Math.min(Math.min(count[i - 1][j], count[i][j - 1]), count[i - 1][j - 1]) + 1;
				}

			}
		}

		long result = 0;
		for (int i = 1; i < count.length; i++) {
			for (int j = 1; j < count[0].length; j++) {
				//System.out.print(count[i][j] + " ");
				result += count[i][j];
			}
			//System.out.println();
		}

		return result;
	}


}
