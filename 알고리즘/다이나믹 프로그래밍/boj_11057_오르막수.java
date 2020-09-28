 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-28
  * URL   : https://www.acmicpc.net/problem/11057
  *
  */

import java.io.*;

public class Main {

    private static int[][] dp;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][10];
        for (int i=0; i<=9; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=N; i++) {
            dp[i][0] = 1;
            for (int j=1; j<=9; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 10007;
            }
        }

        int sum = 0;
        for (int i=0; i<=9; i++) {
            sum += dp[N][i];
        }

        System.out.println(sum % 10007);
    }
}
