 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-30
  * URL   : https://www.acmicpc.net/problem/16194
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                if (dp[i] == 0 || dp[i] > dp[i-j] + arr[j] ) {
                    dp[i] = dp[i-j] + arr[j];
                }
            }
        }
        System.out.println(dp[N]);
    }
}