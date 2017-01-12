package codjam2016.RoundD.B;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(new File("src/codjam2016/RoundD/B/B-large-practice.in"));
        FileWriter fw = new FileWriter(new File("src/codjam2016/RoundD/B/output.txt"));
        int caseNum = in.nextInt();
        //caseNum = 3;

        for (int i = 1; i <= caseNum; i++) {
            n = in.nextInt();
            m = in.nextInt();


            int result = _getResult(n, m);
            //System.out.println("Case #" + i + "    " +n + " : " + m);
            //System.out.println("result : " + result);

            fw.write("Case #" + i + ": ");
            fw.write(result + "");
            fw.write("\n");
        }
        fw.close();
        in.close();

    }


    private static int _getResult(int n, int m) {

        int[][] seat = new int[n + 1][m + 1];
        int result = 0;

        for (int i = 1; i <= n; i++) {

            

            for (int j = 1; j <= m; j++) {
                if ((i+j)%3 != 1 || ((n==2 || m==2)&&i==n && j==m)) {
                    seat[i][j] = 1;
                    result++;
                }
            }
        }

        return result;
    }
}
