package acm;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Test {
	
	static int T;
	static int N;
	static int[] A = new int[5000];
	static int[] D = new int[5000];
	
	 public static void main(String[] args) throws Exception {
	        
	        Scanner in = new Scanner(new File("C://cbp/workspace/test/src/acm/A-large-practice.in"));
	        FileWriter fw = new FileWriter(new File("C://cbp/workspace/test/src/acm/output.txt"));
	        int caseNum = in.nextInt();
	        
	        for (int i = 1; i <= caseNum; i++) {
	        	N = in.nextInt();
	            
	        	for (int j = 0; j < N; j++) {
					 int attack = in.nextInt();
					 int defense = in.nextInt();
					 A[j] = attack;
					 D[j] = defense;
				 }
	            
	            boolean result = solve();
	            System.out.println(result);
	            
	            fw.write("Case #" + i + ": ");
	            //fw.write(result.toString());
	            fw.write("\n");
	        }
	        fw.close();
	        in.close();
	        
	    }

	 
	 static boolean solve()
	 {
	     int AMax = -1;
	     int DMax = -1;
	     int maxCnt = 0;
	     int smallerCnt = 0;

	     for (int i = 0; i < N; i++) {
	         if (A[i] == -1 && D[i] == -1) {
	             continue;
	         }
	         AMax = Math.max(AMax, A[i]);
	         DMax = Math.max(DMax, D[i]);
	     }

	     if (AMax == -1 && DMax == -1) {
	         return false;
	     }

	     for (int i = 0; i < N; i++) {
	         if (AMax == A[i] && DMax == D[i]) {
	             maxCnt++;
	             A[i] = D[i] = -1;
	         } else if (AMax > A[i] && DMax > D[i]) {
	             smallerCnt++;
	         } else {
	             A[i] = D[i] = -1;
	         }
	     }

	     if (maxCnt > 0) {
	         return true;
	     } else {
	         return solve();
	     }
	 }

}
