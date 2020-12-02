 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-02
  * URL   : https://www.acmicpc.net/problem/1890
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) continue;
                if (map[i][j] == 0) continue;
                int jump = map[i][j];

                if (j + jump < N) {
                    dp[i][j+jump] += dp[i][j];
                }
                if (i + jump < N) {
                    dp[i+jump][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N-1][N-1]);

    }
}
