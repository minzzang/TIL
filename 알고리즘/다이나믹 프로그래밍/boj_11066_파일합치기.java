 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-07
  * URL   : https://www.acmicpc.net/problem/11066
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[k+1];
            int[] sum = new int[k+1];
            int[][] dp = new int[k+1][k+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i-1] + arr[i];
            }

            for (int d = 1; d <= k; d++) {
                for (int y = 1; y + d <= k; y++) {
                    int x = y + d;
                    dp[y][x] = Integer.MAX_VALUE;

                    for (int mid = y; mid < x; mid++) {
                        dp[y][x] =
                                Math.min(dp[y][x], dp[y][mid] + dp[mid + 1][x] + sum[x] - sum[y - 1]);
                    }
                }
            }
            sb.append(dp[1][k]).append("\n");
        }
        System.out.println(sb);
    }
}
