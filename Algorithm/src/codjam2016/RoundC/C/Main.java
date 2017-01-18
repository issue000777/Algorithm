package codjam2016.RoundC.C;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
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
			
			 List<String> inputStr = new ArrayList<String>();
			
			 for (int i = 0; i < n; i++) {
			 inputStr.add(in.next());
			 }
			
			 String result = _getResult(inputStr, n);
			
			 System.out.println(result);
			
			 fw.write("Case #" + casei + ": ");
			 fw.write(result + "");
			 fw.write("\n");

//			int n = in.nextInt();
//
//			HashMap<String, ArrayList<String>> inverse = new HashMap<>();
//			HashMap<String, Integer> degree = new HashMap<>();
//
//			for (int i = 0; i < n; i++) {
//				String s[] = in.next().split("=");
//				// System.out.println(Arrays.deepToString(s));
//				String q[] = s[1].split("\\(");
//
//				// System.out.println(Arrays.deepToString(q));
//				String r[] = q[1].split("\\)");
//
//				// System.out.println(Arrays.deepToString(r));
//				String x[];
//				if (r.length == 0) {
//					x = new String[0];
//				} else {
//					x = r[0].split(",");
//				}
//
//				// System.out.println(Arrays.deepToString(x));
//
//				degree.put(s[0], x.length);
//				for (String y : x) {
//					if (!inverse.containsKey(y)) {
//						inverse.put(y, new ArrayList<String>());
//					}
//					inverse.get(y).add(s[0]);
//				}
//			}
//
//			Queue<String> q = new LinkedList<String>();
//
//			for (String x : degree.keySet()) {
//				if (degree.get(x) == 0) {
//					q.add(x);
//				}
//			}
//
//			while (!q.isEmpty()) {
//				String s = q.remove();
//				if (inverse.containsKey(s)) {
//					for (String y : inverse.get(s)) {
//						degree.put(y, degree.get(y) - 1);
//						if (degree.get(y) == 0) {
//							q.add(y);
//						}
//					}
//				}
//			}
//			
//			System.out.println(q);
//
//			String ans = "GOOD";
//
//			for (int k : degree.values()) {
//				if (k != 0)
//					ans = "BAD";
//			}
//			
//			for (Entry<String, Integer> entry : degree.entrySet()) {
//				if(entry.getValue() != 0){
//					System.out.println(entry.getKey());
//				}
//			}
//			System.out.println(ans);
//			fw.write("Case #" + casei + ": ");
//			fw.write(ans + "");
//			fw.write("\n");

		}

		fw.close();
		in.close();

	}

	private static String _getResult(List<String> inputStr, int n) {
		System.out.println();
		System.out.println("======================");

		Map<String, Integer> strMap = new HashMap<String, Integer>();
		List<AssignFunction> funcList = new ArrayList<AssignFunction>();
		int[][] path = new int[1001][1001];

		int cur = 0;
		for (String str : inputStr) {
			AssignFunction func = new AssignFunction(str);
			funcList.add(func);

			if (!strMap.containsKey(func.left))
				strMap.put(func.left, cur++);
			for (String right : func.right) {
				if (!strMap.containsKey(right))
					strMap.put(right, cur++);
			}
		}

		for (AssignFunction func : funcList) {
			for (String right : func.right) {
				path[strMap.get(func.left)][strMap.get(right)] = 1;
			}
		}

		Boolean isCycle = false;
		int[] skip = new int[1001];
		for (int i = 0; i < path.length; i++) {
			List<Integer> pathList = new ArrayList<Integer>();
			int[] use = new int[1001];
			pathList.add(i);
			isCycle = _isCycle(path, skip, use, pathList, i);
			if (isCycle == true) {
				return "BAD";
			}

			for (int k = 0; k < skip.length; k++) {
				if (use[k] == 1)
					skip[k] = use[k];
			}
			skip[i] = 1;
		}

		return "GOOD";

	}

	private static boolean _isCycle(int[][] path, int[] skip, int[] use, List<Integer> pathList, int curPos) {

		if (pathList.size() >= path.length) {
			System.out.println("rtn1");
			System.out.println(pathList);
			return true;
		}

		if (pathList.size() != 1 && pathList.get(0) == curPos) {
			System.out.println("rtn2");
			System.out.println(pathList);
			return true;
		}

		for (int i = 0; i < path.length; i++) {
			if (path[curPos][i] == 1 && skip[i] == 0) {
				use[i] = 1;
				List<Integer> nextPathList = new ArrayList<Integer>();
				for (Integer integer : pathList) {
					nextPathList.add(integer);
				}

				nextPathList.add(i);

				boolean result = _isCycle(path, skip, use, nextPathList, i);
				if (result == true) {

					return true;
				} else {

					// System.out.println(pathList.size());
				}
			}

		}

		return false;
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
