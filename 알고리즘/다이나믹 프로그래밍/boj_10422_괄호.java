 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-05
  * URL   : https://www.acmicpc.net/problem/10422
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int MAX_LENGTH = 5001;
    private static int  DIVIDING_NUMBER = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[MAX_LENGTH / 2 + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += ((dp[j] % DIVIDING_NUMBER) * (dp[i-j-1] % DIVIDING_NUMBER)) % DIVIDING_NUMBER;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 == 1) {
                sb.append(0);
            } else {
                sb.append(dp[n/2] % DIVIDING_NUMBER);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}