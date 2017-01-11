package codjam2016.RoundE.C;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, BigDecimal> cache = null;


    public static void main(String[] args) throws Exception {

        boolean isSmall = true;

        String str = isSmall == true ? "small" : "large";
        String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
        path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
        Scanner in = new Scanner(new File(path + ".in"));
        FileWriter fw = new FileWriter(new File(path + ".out"));


        int caseNum = in.nextInt();

        // caseNum = 1;
        cache = new HashMap<String, BigDecimal>();
        for (int i = 1; i <= caseNum; i++) {

            int n = in.nextInt();
            int d = in.nextInt();

            BigDecimal result = getResult(n, d);
            fw.write("Case #" + i + ": ");
            fw.write(result + "");
            fw.write("\n");
        }
        fw.close();
        in.close();

    }

    private static BigDecimal getResult(int n, int d) {
        BigDecimal result = BigDecimal.ZERO;



        for (int init = d; init <= n; init = init + d) {
            int maxLength = n / init;

            for (int curLength = 1; curLength <= maxLength; curLength++) {
                result = result.add(new BigDecimal(getCount(curLength - 1, n - init * curLength)));
            }
        }


        return result;
    }

    private static int getCount(int length, int remain) {
        if (remain == 0)
            return 1;

        if (remain > length * 2)
            return 0;

        if (remain > length) {
            int rmLength = remain - length;
            length = length - rmLength;
            remain = remain - rmLength * 2;
        }


        return (remain / 2) + 1;
    }

}
