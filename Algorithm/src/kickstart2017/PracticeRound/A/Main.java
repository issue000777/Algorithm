package kickstart2017.PracticeRound.A;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
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

		for (int i = 1; i <= caseNum; i++) {

			int N = in.nextInt();
			in.nextLine();

			List<String> names = new ArrayList<String>();

			for (int j = 0; j < N; j++){
				String tmp = in.nextLine();
				names.add(tmp);
			}

			String result = _getResult(names);
			System.out.println(result);
			fw.write("Case #" + i + ": ");
			fw.write(result + "");
			fw.write("\n");
		}
		fw.close();
		in.close();

	}

	private static String _getResult(List<String> names) {

		List<String> candidates = new ArrayList<String>();
		
		int curCount = 0;
		
		for(String name : names){
			int tmpCount = _getCount(name);
			if(tmpCount > curCount){
				candidates.clear();
				candidates.add(name);
				curCount = tmpCount;
			}
			else if(tmpCount == curCount){
				candidates.add(name);
			}
		}

		Collections.sort(candidates);

		return candidates.get(0);
	}
	
	private static int _getCount(String name){
		
		int[] charArr = new int[26];
		
		for(char ch : name.toCharArray()){
			if(ch >= 'A' && ch <= 'Z'){
				charArr[ch - 'A']++;
			}
			
		}
		
		int count = 0;
		for(int i=0; i<charArr.length; i++){
			if(charArr[i] > 0)
				count++;
		}
		
		return count;
		
	}
}
