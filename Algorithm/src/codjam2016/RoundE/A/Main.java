package codjam2016.RoundE.A;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Main {

    static BigDecimal n;
    static BigDecimal m;


    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new File("src/codjam2016/RoundE/A/A-small-practice.in"));
        FileWriter fw = new FileWriter(new File("src/codjam2016/RoundE/A/A-small-practice.out"));
        int caseNum = in.nextInt();
        // caseNum = 1;

        for (int i = 1; i <= caseNum; i++) {
            String str = in.next();

            n = in.nextBigDecimal();
            m = in.nextBigDecimal();


            BigDecimal result = _getResult(str, n, m);
            fw.write("Case #" + i + ": ");
            fw.write(result + "");
            fw.write("\n");
        }
        fw.close();
        in.close();

    }


    private static BigDecimal _getResult(String str, BigDecimal n, BigDecimal m) {

        int length = str.length();
        int bCnt = 0;

        for (int i = 0; i < length; i++)
            if (str.charAt(i) == 'B')
                bCnt++;

        return _getBCnt(str, m, bCnt, length).subtract(_getBCnt(str, n.subtract(BigDecimal.ONE), bCnt, length));
    }

    private static BigDecimal _getBCnt(String str, BigDecimal i, int bCnt, int length) {
        BigDecimal result = BigDecimal.ZERO;


        if (i.compareTo(BigDecimal.ZERO) <= 0)
            return result;
        else {
            BigDecimal quotient = i.divide(new BigDecimal(length), BigDecimal.ROUND_FLOOR);
            int remainder = i.remainder(new BigDecimal(length)).intValue();

            result = result.add(quotient.multiply(new BigDecimal(bCnt)));
            if (remainder > 0)
                for (int k = 1; k <= remainder; k++) {
                    if (str.charAt(k - 1) == 'B')
                        result = result.add(BigDecimal.ONE);
                }

            return result;
        }
    }
}
