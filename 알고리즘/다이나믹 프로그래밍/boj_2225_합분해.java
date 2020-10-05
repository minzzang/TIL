 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-05
  * URL   : https://www.acmicpc.net/problem/2225
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[K+1][N+1];
        dp[1][N] = 1;

        for (int i=2; i<=K; i++) {
            for (int j=0; j<=N; j++) {
                long sum = 0;
                for (int k=j; k<=N; k++) {
                    sum += dp[i-1][k] % 1000000000;
                }
                dp[i][j] = sum % 1000000000;
            }
        }

        long answer = 0;
        for (int i=0; i<=N; i++) {
            answer += dp[K][i] % 1000000000;
        }
        System.out.println(answer % 1000000000);
    }
}
