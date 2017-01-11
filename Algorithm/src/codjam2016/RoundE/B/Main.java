package codjam2016.RoundE.B;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static BigDecimal n;


    public static void main(String[] args) throws Exception {

        boolean isSmall = true;

        String str = isSmall == true ? "small" : "large";
        String path = "/" + Main.class.getPackage().toString().substring(8).replace('.', '/');
        path = "src" + path + "/" + path.substring(path.length() - 1) + "-" + str + "-practice";
        Scanner in = new Scanner(new File(path + ".in"));
        FileWriter fw = new FileWriter(new File(path + ".out"));
        
        int caseNum = in.nextInt();
        // caseNum = 1;

        for (int i = 1; i <= caseNum; i++) {

            n = new BigDecimal(in.next());

            BigDecimal result = _getResult2(n);
            System.out.println(result);
            fw.write("Case #" + i + ": ");
            fw.write(result + "");
            fw.write("\n");
        }
        fw.close();
        in.close();

    }

    private static boolean pend(int x, BigDecimal n) {
        BigDecimal tmp = n;
        while (tmp.compareTo(BigDecimal.ZERO) > 0) {
            if (tmp.remainder(new BigDecimal(x)) != BigDecimal.ONE)
                return false;
            tmp = tmp.divide(new BigDecimal(x), BigDecimal.ROUND_DOWN);
        }
        return true;
    }

    private static BigDecimal _getResult2(BigDecimal n) {
        Math.pow(1.3, 1.5);
        int minN = 100000;
        if (new BigDecimal(minN).compareTo(n) > 0)
            minN = n.intValue();

        for (int i = 2; i <= minN; i++)
            if (pend(i, n)) {

                return new BigDecimal(i);
            }
        int x = bigIntSqRootFloor(n, 3).intValue();


        if (pend(x, n)) {
            return new BigDecimal(x);
        }
        x = bigIntSqRootFloor(n, 2).intValue();
        if (pend(x, n)) {
            return new BigDecimal(x);
        }
        return n.subtract(BigDecimal.ONE);
    }

    private static BigDecimal bigIntSqRootFloor(BigDecimal x, int base) throws IllegalArgumentException {
        if (x.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Negative argument.");
        }
        // square roots of 0 and 1 are trivial and
        // y == 0 will cause a divide-by-zero exception
        if (x.equals(BigDecimal.ZERO) || x.equals(BigDecimal.ONE)) {
            return x;
        } // end if
        BigDecimal two = BigDecimal.valueOf(base);
        BigDecimal y;
        // starting with y = x / 2 avoids magnitude issues with x squared
        for (y = x.divide(two, BigDecimal.ROUND_FLOOR); y.compareTo(x.divide(y, BigDecimal.ROUND_FLOOR)) > 0; y = ((x.divide(y, BigDecimal.ROUND_FLOOR)).add(y)).divide(two, BigDecimal.ROUND_FLOOR));
        return y;
    }

    private static BigDecimal _getResult(BigDecimal n) {

        BigDecimal base = n.subtract(BigDecimal.ONE);

        List<BigDecimal> targets = _getTarget(base);
        BigDecimal result = base;

        for (BigDecimal divisor : targets) {
            if (_isBeautiful(divisor, n) && divisor.compareTo(result) < 0) {
                result = divisor;
            }
        }

        return result;
    }

    private static boolean _isBeautiful(BigDecimal base, BigDecimal n) {
        BigDecimal tmp = n;

        while (tmp.remainder(base).compareTo(BigDecimal.ONE) == 0) {
            tmp = tmp.subtract(BigDecimal.ONE).divide(base);
            if (tmp.compareTo(BigDecimal.ONE) == 0)
                return true;
        }

        return false;
    }

    private static List<BigDecimal> _getTarget(BigDecimal n) {
        List<BigDecimal> divisorList = new ArrayList<BigDecimal>();

        BigDecimal divisor = new BigDecimal(2);
        while (n.compareTo(BigDecimal.ONE) > 0) {

            if (n.remainder(divisor).compareTo(BigDecimal.ZERO) == 0) {
                divisorList.add(divisor);
                n = n.divide(divisor);
                divisor = new BigDecimal(2);
            }

            else {
                divisor = divisor.add(BigDecimal.ONE);
            }

        }



        return _getCombination(divisorList);
    }

    private static List<BigDecimal> _getCombination(List<BigDecimal> divisorList) {
        List<BigDecimal> returnList = new ArrayList<BigDecimal>();

        List<List<BigDecimal>> powerSet = powerList(divisorList);

        for (List<BigDecimal> set : powerSet) {
            BigDecimal rtn = BigDecimal.ONE;

            for (BigDecimal num : set) {
                rtn = rtn.multiply(num);
                returnList.add(rtn);
            }

        }


        return returnList;
    }

    public static List<List<BigDecimal>> powerList(List<BigDecimal> originalSet) {
        List<List<BigDecimal>> sets = new ArrayList<List<BigDecimal>>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<BigDecimal>());
            return sets;
        }
        List<BigDecimal> list = new ArrayList<BigDecimal>(originalSet);
        BigDecimal head = list.get(0);
        List<BigDecimal> rest = new ArrayList<BigDecimal>(list.subList(1, list.size()));
        for (List<BigDecimal> set : powerList(rest)) {
            List<BigDecimal> newSet = new ArrayList<BigDecimal>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
