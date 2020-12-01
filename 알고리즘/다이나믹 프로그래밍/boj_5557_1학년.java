 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-01
  * URL   : https://www.acmicpc.net/problem/5557
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 20;
        long[][] dp = new long[N][max+1];

        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][numbers[0]] = 1;
        for (int i = 1; i < N-1; i++) {
            for (int j = 0; j <= max; j++) {
                if (dp[i-1][j] > 0) {
                    if (j + numbers[i] <= max) {
                        dp[i][j+numbers[i]] += dp[i-1][j];
                    }
                    if (j - numbers[i] >= 0) {
                        dp[i][j-numbers[i]] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[N-2][numbers[N-1]]);
    }
}