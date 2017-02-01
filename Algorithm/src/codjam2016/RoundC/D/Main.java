package codjam2016.RoundC.D;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
		//caseNum = 1;

		for (int casei = 1; casei <= caseNum; casei++) {
			int n = in.nextInt();

			List<Soldier> soldierList = new ArrayList<Soldier>();

			for (int i = 0; i < n; i++) {
				int attack = in.nextInt();
				int defense = in.nextInt();
				soldierList.add(new Soldier(attack, defense));
			}
			String result = _getResult(soldierList);

			System.out.println(result);

			 fw.write("Case #" + casei + ": ");
			 fw.write(result + "");
			 fw.write("\n");
		}
		

		fw.close();
		in.close();

	}

	private static String _getResult(List<Soldier> soldierList) {

		if (_pick(soldierList))
			return "YES";
		else
			return "NO";

	}

	private static boolean _pick(List<Soldier> soldierList) {

		List<Soldier> candidate = new ArrayList<Soldier>();
		int maxAttack = 0;
		int maxDefense = 0;

		for (Soldier s : soldierList) {
			if (s.isCandiate) {
				maxAttack = Math.max(maxAttack, s.attack);
				maxDefense = Math.max(maxDefense, s.defense);
			}
		}

		for (Soldier s : soldierList) {
			if (s.isCandiate) {
				if (s.attack == maxAttack && s.defense == maxDefense) {
					return true;
				} else if (s.attack == maxAttack || s.defense == maxDefense) {
					s.isCandiate = false;
				} else {
					candidate.add(s);
				}
			}
		}

		if (candidate.isEmpty()) {
			return false;
		}

		
		return _pick(soldierList);

	}

}

class Soldier {
	int attack;
	int defense;
	boolean isCandiate = true;

	Soldier(int attack, int defense) {
		this.attack = attack;
		this.defense = defense;
	}
}
