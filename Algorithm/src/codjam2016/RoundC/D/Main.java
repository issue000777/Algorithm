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
			
			 String result = _getResult(soldierList);
			
			 System.out.println(result);
			
			 fw.write("Case #" + casei + ": ");
			 fw.write(result + "");
			 fw.write("\n");


		}

		fw.close();
		in.close();

	}
	
	private static String _getResult(List<Soldier> soldierList){
		
		
		for(Soldier s : soldierList){
			s.left = _getLeft(s.attack, s.defense, soldierList);
		}
		
		for(Soldier s : soldierList){
			if(s.left % 2 == 1)
				return "NO";
		}
		
		return "YES";
	}
	
	private static int _getLeft(int attack, int defense, List<Soldier> soldierList){
		
		int rtn = 0;
		
		for(Soldier s : soldierList){
			if(s.attack > attack || s.defense > defense)
				rtn++;
		}
		
		return rtn;
	}


}

class Soldier {
	int attack;
	int defense;
	int left;
	
	Soldier(int attack, int defense){
		this.attack = attack;
		this.defense = defense;
	}
}

