 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-03
  * URL   : https://www.acmicpc.net/problem/10844
  *
  */

import java.io.*;

public class Main {

    private static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1][10];
        for (int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][1] % 1000000000;
            dp[i][9] = dp[i-1][8] % 1000000000;
            for (int j=1; j<9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;
        for (int i=0; i<=9; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 1000000000);
    }
}