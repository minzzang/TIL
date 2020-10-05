 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-05
  * URL   : https://www.acmicpc.net/problem/2133
  *
  */

import java.io.*;

public class Main {

    private static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 1;

        for (int i=2; i<=N; i+=2) {
            dp[i] = dp[i-2] * 3;
            for (int j=i-4; j>=0; j-=2) {
                dp[i] += dp[j] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}
