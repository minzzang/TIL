 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-28
  * URL   : https://www.acmicpc.net/problem/11052
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    private static int[] arr, d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        d = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(N));
    }

    private static int dp(int n) {

        if (n == 0) return 0;

        if (d[n] > 0) {
            return d[n];
        }

        for (int i=1; i<=n; i++) {
            d[n] = Math.max(d[n], dp(n-i) + arr[i]);
        }
        return d[n];
    }

}