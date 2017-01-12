package acm;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    

    

    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(new File("C://cbp/workspace/test/src/acm/A-large-practice.in"));
        FileWriter fw = new FileWriter(new File("C://cbp/workspace/test/src/acm/output.txt"));
        int caseNum = in.nextInt();
        
        for (int i = 1; i <= caseNum; i++) {
            Long n = in.nextLong();
            
            
            Long result = _getResult(n);
            System.out.println(result);
            
            fw.write("Case #" + i + ": ");
            fw.write(result.toString());
            fw.write("\n");
        }
        fw.close();
        in.close();
        
    }


    private static Long _getResult(Long n){
    	
        return (long) 0;
    }
}
