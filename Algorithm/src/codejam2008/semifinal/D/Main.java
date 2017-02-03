package codejam2008.semifinal.D;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int[][] dir = { { 1, 1 }, { 1, -1 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };
	static Map<String, Boolean> cache;
	static int hit = 0;
	
	public static void main(String[] args) throws Exception {

		boolean isSmall = true;

		
		String str = isSmall == true ? "small" : "large";
		String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
		path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
		Scanner in = new Scanner(new File(path + ".in"));
		FileWriter fw = new FileWriter(new File(path + ".out"));

		int caseNum = in.nextInt();
		//caseNum = 5;

		for (int casei = 1; casei <= caseNum; casei++) {
			int r, c;

			r = in.nextInt();
			c = in.nextInt();

			cache = new HashMap<String, Boolean>();
			
			char[][] map = new char[r][c];
			int m = 0, n = 0;
			for (int i = 0; i < r; i++) {
				String tmp = in.next();
				for (int j = 0; j < c; j++) {
					map[i][j] = tmp.charAt(j);
					if (map[i][j] == 'K') {
						m = i;
						n = j;
					}
				}
			}
			hit = 0;
			String result = _getResult(map, m, n) ? "A" : "B";
			System.out.println(result);
			fw.write("Case #" + casei + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static boolean _getResult(char[][] map, int m, int n) {
		
		if(hit%10000 == 0)
			System.out.println(hit);

		Boolean tmp = cache.get(Arrays.deepToString(map));
		if(tmp != null){
			hit++;
			return tmp;
		}
		
		for (int k = 0; k < dir.length; k++) {
			int nexti = m + dir[k][0];
			int nextj = n + dir[k][1];

			if (nexti < 0 || nexti >= map.length || nextj < 0 || nextj >= map[0].length || map[nexti][nextj] != '.')
				continue;

			char[][] newMap = new char[map.length][map[0].length];

			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map[0].length; j++)
					newMap[i][j] = map[i][j];

			newMap[nexti][nextj] = 'k';
			newMap[m][n] = '#';

			if (_getResult(newMap, nexti, nextj) == false){
				cache.put(Arrays.deepToString(map), true);
				return true;
			}

		}

		cache.put(Arrays.deepToString(map), false);
		return false;
	}

}
