 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-03
  * URL   : https://www.acmicpc.net/problem/11048
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] arr = new int[Y][X];
        for (int i=0; i<Y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<X; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[Y+1][X+1];
        for (int i=1; i<=Y; i++) {
            for (int j=1; j<=X; j++) {
                dp[i][j] = Math.max(Math.max(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + arr[i-1][j-1];
            }
        }

        System.out.println(dp[Y][X]);
    }

}