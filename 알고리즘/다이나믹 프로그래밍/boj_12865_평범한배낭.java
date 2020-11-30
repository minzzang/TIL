 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-30
  * URL   : https://www.acmicpc.net/problem/12865
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] weights, values;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[K + 1];
        values = new int[K + 1];
        dp = new int[K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            weights[i] = weight;
            values[i] = value;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= weights[i]; j--) {
                if (dp[j] < dp[j-weights[i]] + values[i]) {
                    dp[j] = dp[j-weights[i]] + values[i];
                }
            }
        }

        System.out.println(dp[K]);
    }
}