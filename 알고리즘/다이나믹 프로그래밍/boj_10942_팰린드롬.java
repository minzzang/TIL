 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-03
  * URL   : https://www.acmicpc.net/problem/10942
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

        int[][] dp = new int[N+1][N+1];
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {
            for (int j = i; j <= N; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                if (arr[i] != arr[j])  continue;
                if (j - i < 3) {
                    dp[i][j] = 1;
                    continue;
                }
                if (dp[i+1][j-1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dp[a][b] == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}