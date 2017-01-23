package codjam2016.RoundC.D;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
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
		//caseNum = 2;

		for (int casei = 1; casei <= caseNum; casei++) {
			 int n = in.nextInt();
			
			 List<Soldier> soldierList = new ArrayList<Soldier>();
			 for (int i = 0; i < n; i++) {
				 int attack = in.nextInt();
				 int defense = in.nextInt();
				 soldierList.add(new Soldier(attack, defense));
			 }
			
			 String result = "";
			
			 System.out.println(_getResult(soldierList));
			
			 fw.write("Case #" + casei + ": ");
			 fw.write(result + "");
			 fw.write("\n");


		}

		fw.close();
		in.close();

	}
	
	private static String _getResult(List<Soldier> soldierList){
		
		return "YES";
	}
	
	


}

class Soldier {
	int attack;
	int defense;
	
	Soldier(int attack, int defense){
		this.attack = attack;
		this.defense = defense;
	}
}

