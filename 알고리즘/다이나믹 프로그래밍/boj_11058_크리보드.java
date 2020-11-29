 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-29
  * URL   : https://www.acmicpc.net/problem/11058
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
            int multiply = 2;
            for (int j = i-3; j > 0; j--) {
                dp[i] = Math.max(Math.max(dp[i], dp[j] * multiply++), dp[i-1] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}