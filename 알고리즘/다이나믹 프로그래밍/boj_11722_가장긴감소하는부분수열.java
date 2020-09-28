 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-28
  * URL   : https://www.acmicpc.net/problem/11722
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    private static int[] arr, d;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        d = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            max = Math.max(max, dp(i));
        }

        System.out.println(max);
    }

    private static int dp(int n) {
        if(n == 1) return 1;
        if (d[n] > 0) return d[n];

        for (int i=n-1; i>0; i--) {
            if (arr[i] > arr[n]) {
                d[n] = Math.max(dp(i) + 1, d[n]);
            }
        }

        return d[n] = d[n] == 0 ?  1: d[n];
    }

}