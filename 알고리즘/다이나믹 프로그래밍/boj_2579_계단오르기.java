 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-02
  * URL   : https://www.acmicpc.net/problem/2579
  *
  */

import java.io.*;

public class Main {

    private  static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];

        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            dp[1] = arr[1];
        } else {
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            for (int i=3; i<=N; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
            }
        }

        System.out.println(dp[N]);
    }
}