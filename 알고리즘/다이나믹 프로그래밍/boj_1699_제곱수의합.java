 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-04
  * URL   : https://www.acmicpc.net/problem/1699
  *
  */

import java.io.*;

public class Main {

    private static int[] dp;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[1] = 1;

        for (int i=2; i<=N; i++) {
            for (int j=1; j*j<=i; j++) {
                if (j == 1) {
                    dp[i] = dp[i-j*j] + 1;
                } else {
                    dp[i] = Math.min(1+dp[i-j*j], dp[i]);
                }
            }
        }
        System.out.println(dp[N]);
    }
}