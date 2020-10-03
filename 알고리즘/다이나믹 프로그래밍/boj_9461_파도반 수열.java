 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-03
  * URL   : https://www.acmicpc.net/problem/9461
  *
  */

import java.io.*;

public class Main {

    private static long[] dp;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            if (N == 1) {
                sb.append(1 + "\n");
                continue;
            }

            dp = new long[N+1];
            dp[1] = dp[2] = 1;
            for (int i=3; i<=N; i++) {
                dp[i] = dp[i-3] + dp[i-2];
            }
            sb.append(dp[N] + "\n");
        }

        System.out.println(sb);
    }
}