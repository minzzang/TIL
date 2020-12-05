 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-05
  * URL   : https://www.acmicpc.net/problem/2294
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sumOfCoin = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        int[] dp = new int[sumOfCoin+1];
        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = coins[i]; j <= sumOfCoin; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j-coins[i]]);
            }
        
        }
        System.out.println(dp[sumOfCoin] == 100001 ? -1 : dp[sumOfCoin]);
    }
}