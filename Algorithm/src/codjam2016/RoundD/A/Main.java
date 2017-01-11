package codjam2016.RoundD.A;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    
    static double[][] solution = new double[2001][2001];

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new File("src/codjam2016/RoundD/A/A-large-practice.in"));
        FileWriter fw = new FileWriter(new File("src/codjam2016/RoundD/A/output.txt"));
        int caseNum = in.nextInt();

        for (int i = 1; i <= caseNum; i++) {
            n = in.nextInt();
            m = in.nextInt();


            BigDecimal result = _getResult(n, m);
            result.setScale(6, BigDecimal.ROUND_UP);
            fw.write("Case #" + i + ": ");
            fw.write(result + "");
            fw.write("\n");
        }
        fw.close();
        in.close();

    }


    private static BigDecimal _getResult(int n, int m) {
        if(solution[n][m] > 0)
            return new BigDecimal(solution[n][m]);
        
        if(n <= m)
            return BigDecimal.ZERO;
        if(m == 0)
            return BigDecimal.ONE;
        
         BigDecimal val = (new BigDecimal(m)).multiply(_getResult(n, m-1)).add(new BigDecimal(n).multiply(_getResult(n-1, m))).divide(new BigDecimal(n+m), MathContext.DECIMAL64);
         val.setScale(6, BigDecimal.ROUND_UP);
         solution[n][m] = val.doubleValue();
         return val;
    }
}
