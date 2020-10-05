 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-05
  * URL   : https://www.acmicpc.net/problem/1912
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        dp[0] = -1000;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = -1000;
        for (int i=1; i<=N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
