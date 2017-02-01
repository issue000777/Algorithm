package codjam2016.RoundC.D;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			 Map<String, Integer> cache = new HashMap<String, Integer>(); 
			 
			 for (int i = 0; i < n; i++) {
				 int attack = in.nextInt();
				 int defense = in.nextInt();
				 soldierList.add(new Soldier(attack, defense));
			 }
			 String result = _getResult(soldierList, cache);
			 
			
			 System.out.println(result);
			 
			
			 fw.write("Case #" + casei + ": ");
			 fw.write(result + "");
			 fw.write("\n");


		}

		fw.close();
		in.close();

	}
	
	private static String _getResult(List<Soldier> soldierList, Map<String, Integer> cache){


		
		if(_pick(soldierList, 0, 0, cache))
			return "YES";
		else
			return "NO";
	
		
	}
	
	private static boolean _pick(List<Soldier> soldierList, int attack, int defense, Map<String, Integer> cache){
		
		Integer tmp = cache.get(attack+":"+defense);
		if(tmp != null && tmp == 1)
			return true;
		else if (tmp != null && tmp == 2)
			return false;
		
		List<Soldier> candidate = new ArrayList<Soldier>();
		for(Soldier s : soldierList){
			if(s.attack > attack || s.defense > defense){
				candidate.add(s);
			}
		}
		
		if(candidate.isEmpty()){
			cache.put(attack+":"+defense, 2);
			return false;
		}

		
		for(Soldier s : candidate){

			
			if(_pick(soldierList, Math.max(s.attack, attack), Math.max(s.defense, defense), cache) == false){
				cache.put(attack+":"+defense, 1);
				return true;
			}
			
		}
		cache.put(attack+":"+defense, 2);
		return false;
		
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

