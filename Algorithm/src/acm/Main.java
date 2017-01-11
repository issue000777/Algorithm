package acm;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    

    

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(new File("C://cbp/workspace/test/src/acm/A-large-practice.in"));
        FileWriter fw = new FileWriter(new File("C://cbp/workspace/test/src/acm/output.txt"));
        int caseNum = in.nextInt();
        
        for (int i = 1; i <= caseNum; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            
            
            int result = _getResult(n, m);
            System.out.println(result);
            
            fw.write("Case #" + i + ": ");
            fw.write(result);
            fw.write("\n");
        }
        fw.close();
        in.close();
        
    }


    private static int _getResult(int n, int m){
        return 0;
    }
}
