 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-29
  * URL   : https://www.acmicpc.net/problem/11055
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, dp;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i=1; i<=N; i++) {
            sum = Math.max(sum, getMaxOfSum(i));
        }
        System.out.println(sum);
    }

    private static int getMaxOfSum(int n) {

        if (n == 1) return dp[1] = arr[1];
        if (dp[n] > 0) return dp[n];

        for (int i=n-1; i>0; i--) {
            if (arr[n] > arr[i]) {
                dp[n] = Math.max(dp[n], getMaxOfSum(i) + arr[n]);
            }
        }

        return dp[n] = dp[n] == 0 ? arr[n] : dp[n];
    }
}
