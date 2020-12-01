 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-01
  * URL   : https://www.acmicpc.net/problem/1495
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        int[] playList = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            playList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i-1][j]) {
                    if (j + playList[i] <= M) {
                        dp[i][j+playList[i]] = true;
                    }
                    if (j - playList[i] >= 0) {
                        dp[i][j-playList[i]] = true;
                    }
                }
            }
        }

        int index = -1;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                index = i;
                break;
            }
        }

        System.out.println(index);
    }
}