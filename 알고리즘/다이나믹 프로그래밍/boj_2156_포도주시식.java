 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-05
  * URL   : https://www.acmicpc.net/problem/2156
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+3];
        dp = new int[N+3];

        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];

        for (int i=4; i<=N; i++) {
            int n = Math.max(dp[i-3], dp[i-4]) + arr[i-1];
            dp[i] = Math.max(n, dp[i-2]) + arr[i];
        }

        System.out.println(Math.max(dp[N], dp[N-1]));
    }
}
