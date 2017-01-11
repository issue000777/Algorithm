package codjam2016.RoundD.C;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static List<String>         words;
    static Map<String, Integer> cache;

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new File("src/codjam2016/RoundD/D/D-small-practice.in"));
        FileWriter fw = new FileWriter(new File("src/codjam2016/RoundD/D/output.txt"));
        int caseNum = in.nextInt();
        // caseNum = 2;

        for (int i = 1; i <= caseNum; i++) {
            int n = in.nextInt();
            int m = in.nextInt();

            words = new ArrayList<String>();
            cache = new HashMap<String, Integer>();
            List<String> sentences = new ArrayList<String>();

            for (int j = 0; j < n; j++)
                words.add(in.next());
            for (int j = 0; j < m; j++)
                sentences.add(in.next());

            String result = _getResult(sentences);

            fw.write("Case #" + i + ":");
            fw.write(result);
            fw.write("\n");
        }
        fw.close();
        in.close();

    }



    private static String _getResult(List<String> sentences) {


        String result = "";

        for (String str : sentences) {
            result += " " + _getCount(str);
        }
        return result;
    }

    private static BigDecimal _getCount(String sentence) {

        if (sentence.isEmpty())
            return BigDecimal.ONE;
        if (cache.get(sentence) != null)
            return new BigDecimal(cache.get(sentence));

        String[] tmpWords = new String[words.size()];
        int[] available = new int[words.size()];
        for (int i = 0; i < words.size(); i++) {
            tmpWords[i] = words.get(i);
        }



        BigDecimal result = BigDecimal.ZERO;
        while (_isAvailble(available) && !sentence.isEmpty()) {
            String str = sentence.substring(0, 1);
            sentence = sentence.substring(1);

            for (int i = 0; i < tmpWords.length; i++) {
                if (available[i] == 0) {
                    if (tmpWords[i].contains(str)) {
                        tmpWords[i] = tmpWords[i].replaceFirst(str, "");
                        if (tmpWords[i].isEmpty()) {
                            BigDecimal tmp = _getCount(sentence).remainder(new BigDecimal("1000000007"));
                            cache.put(sentence, tmp.intValue());
                            result = result.add(tmp);
                        }

                    } else {
                        available[i] = 1;
                    }
                }
            }
        }

        return result;
    }

    private static boolean _isAvailble(int[] avail) {

        for (int i = 0; i < avail.length; i++)
            if (avail[i] == 0)
                return true;

        return false;
    }
}
