 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-30
  * URL   : https://www.acmicpc.net/problem/15990
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int MOD = 1000000009;
    private static long[][] arr = new long[100001][4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] test = new int[N];

        for (int i=0; i<N; i++) {
            test[i] = Integer.parseInt(br.readLine());
        }

        arr[1][1] = arr[2][2] = arr[3][1] = arr[3][2] = arr[3][3] = 1;
        arr[1][2] = arr[1][3] = arr[2][1] = arr[2][3] = 0;
        arr[1][0] = arr[2][0] = 1;
        arr[3][0] = 3;

        for (int i=4; i<100001; i++) {
            arr[i][1] = (arr[i-1][2] + arr[i-1][3]) % MOD;
            arr[i][2] = (arr[i-2][1] + arr[i-2][3]) % MOD;
            arr[i][3] = (arr[i-3][1] + arr[i-3][2]) % MOD;
            arr[i][0] = (arr[i][1] + arr[i][2] + arr[i][3]) % MOD;
        }

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<N; i++) {
            sb.append(arr[test[i]][0] % MOD).append("\n");
        }

        System.out.println(sb);
    }
}