package codjam2016.RoundD.D;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int M;
    static int L;

    public static void main(String[] args) throws Exception {

        // Scanner in = new Scanner(new File("src/codjam2016/RoundD/D/D-small-practice.in"));
        Scanner in = new Scanner(new File("src/codjam2016/RoundD/D/test"));
        FileWriter fw = new FileWriter(new File("src/codjam2016/RoundD/D/output.txt"));
        int caseNum = in.nextInt();


        for (int i = 1; i <= caseNum; i++) {
            int N = in.nextInt();
            M = in.nextInt();
            L = in.nextInt();
            List<Rubber> rubber = new ArrayList<Rubber>();

            for (int j = 1; j <= N; j++) {
                int min = in.nextInt();
                int max = in.nextInt();
                int price = in.nextInt();

                rubber.add(new Rubber(min, max, price));
            }

            int result = _getResult(rubber, 0, 0);


            fw.write("Case #" + i + ":");

            if (result < Integer.MAX_VALUE)
                fw.write(result + "");
            else
                fw.write("IMPOSSIBLE");
            fw.write("\n");
        }
        fw.close();
        in.close();

    }



    private static int _getResult(List<Rubber> rubber, int curLength, int curCost) {


        if (curLength == L)
            return curCost;

        List<Rubber> tmp = new ArrayList<Rubber>();

        for (Rubber e : rubber) {
            if (e.price + curCost > M)
                continue;
            if (e.max + curLength > L)
                continue;
            tmp.add(e);
        }

        if (tmp.isEmpty())
            return Integer.MAX_VALUE;

        List<Integer> results = new ArrayList<Integer>();

        for (int i = 0; i < rubber.size(); i++) {
            Rubber e = rubber.get(i);
            List<Rubber> rubberIn = new ArrayList<Rubber>();
            for (Rubber t : tmp) {
                rubberIn.add(t);
            }
            rubberIn.remove(e);

            results.add(_getResult(rubberIn, curLength + e.max, curCost + e.price));

        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < results.size(); i++) {
            if (result > results.get(i))
                result = results.get(i);
        }

        return result;
    }

    static class Rubber {
        int min;
        int max;
        int price;
        int used;

        Rubber(int min, int max, int price) {
            this.min = min;
            this.max = max;
            this.price = price;
        }
    }

}
