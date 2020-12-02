 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-02
  * URL   : https://www.acmicpc.net/problem/15989
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num < 4) {
                sb.append(num).append("\n");
                continue;
            }

            int[][] dp = new int[4][num+1];
            dp[1][1] = dp[1][2] = dp[1][3] = 1;
            dp[2][2] = dp[2][3] = dp[3][3] = 1;

            for (int i = 4; i <= num; i++) {
                dp[3][i] += dp[1][i-3] + dp[2][i-3] + dp[3][i-3];
                dp[2][i] += dp[1][i-2] + dp[2][i-2];
                dp[1][i] += dp[1][i-1];
            }

            int sum = dp[1][num] + dp[2][num] + dp[3][num];
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}