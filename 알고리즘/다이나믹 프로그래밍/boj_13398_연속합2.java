 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-30
  * URL   : https://www.acmicpc.net/problem/13398
  *
  */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        int[] dp = new int[N];
        dp[0] = arr[0];
        for (int i=1; i<N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }

        int[] dp2 = new int[N];
        dp2[N-1] = arr[N-1];
        for (int i=N-2; i>0; i--) {
            dp2[i] = Math.max(dp2[i+1] + arr[i], arr[i]);
            max = Math.max(dp2[i], max);
        }

        for (int i=1; i<N-1; i++) {
            max = Math.max(dp[i-1] + dp2[i+1], max);
        }

        System.out.println(max);
    }
}