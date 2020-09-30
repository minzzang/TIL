 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-30
  * URL   : https://www.acmicpc.net/problem/9465
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N+1];
            int[][] dp = new int[3][N+1];

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++) {
                dp[0][i-1] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
                dp[1][i-1] = Math.max(dp[0][i-1], dp[2][i-1] + arr[0][i]);
                dp[2][i-1] = Math.max(dp[0][i-1], dp[1][i-1] + arr[1][i]);
            }
            int sum = Math.max(dp[0][N-1], Math.max(dp[1][N-1], dp[2][N-1]));

            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }
}

