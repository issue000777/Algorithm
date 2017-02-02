package codjam2016.RoundC.C;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

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
			 int n = in.nextInt();
			
			 List<String> inputStr = new ArrayList<String>();
			
			 for (int i = 0; i < n; i++) {
			 inputStr.add(in.next());
			 }
			
			 String result = _getResult(inputStr, n);
			
			 System.out.println(result);
			
			 fw.write("Case #" + casei + ": ");
			 fw.write(result + "");
			 fw.write("\n");


		}

		fw.close();
		in.close();

	}

	private static String _getResult(List<String> inputStr, int n) {

		List<AssignFunction> funcList = new ArrayList<AssignFunction>();
		Set<String> emptyList = new HashSet<String>();
		for (String str : inputStr) {
			AssignFunction func = new AssignFunction(str);
			funcList.add(func);
		}

		for (int i = 0; i <= funcList.size(); i++) {

			for (AssignFunction func : funcList) {

				if (func.right.isEmpty()) {
					emptyList.add(func.left);
				} else {
					boolean isEmpty = true;
					for (String str : func.right) {
						if (!emptyList.contains(str)) {
							isEmpty = false;
						}
					}
					
					if(isEmpty){
						emptyList.add(func.left);
					}
				}
			}

		}
		

		if(emptyList.size() == funcList.size())
			return "GOOD";
		else
			return "BAD";

	}
	


}

class AssignFunction {
	String left;
	List<String> right = new ArrayList<>();

	AssignFunction(String input) {
		left = input.substring(0, input.indexOf("="));
		input = input.substring(input.indexOf("(") + 1, input.indexOf(")"));

		while (input.indexOf(",") > 0) {
			right.add(input.substring(0, input.indexOf(",")));
			input = input.substring(input.indexOf(",") + 1, input.length());
		}

		if (!input.isEmpty())
			right.add(input);
	}

	void print() {
		System.out.println("left : " + left);

		System.out.println("rightsize : " + right.size());
		for (String str : right) {
			System.out.println("right : " + str);
		}
	}
}
