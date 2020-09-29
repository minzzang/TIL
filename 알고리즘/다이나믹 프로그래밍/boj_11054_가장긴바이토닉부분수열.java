 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-29
  * URL   : https://www.acmicpc.net/problem/11054
  *
  */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, ldp, rdp;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        ldp = new int[N+1];
        rdp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int n = 0;
        for (int i=1; i<=N; i++) {
            n = getLeftLIS(i) + getRightLIS(N-i+1);
        }

        int sum = 0;
        for (int i=1; i<=N; i++) {
            sum = Math.max(sum, ldp[i] + rdp[i] - 1);
        }
        System.out.println(sum);
    }

    private static int getLeftLIS(int n) {

        if (n == 1) return ldp[1] = 1;
        if (ldp[n] > 0) return ldp[n];

        for (int i=n-1; i>0; i--) {
            if (arr[n] > arr[i]) {
                ldp[n] = Math.max(ldp[n], getLeftLIS(i) + 1);
            }
        }

        return ldp[n] = ldp[n] == 0 ? 1 : ldp[n];
    }

    private static int getRightLIS(int n) {

        if (n == N) return rdp[N] = 1;
        if (rdp[n] > 0) return rdp[n];

        for (int i=n+1; i<=N; i++) {
            if (arr[n] > arr[i]) {
                rdp[n] = Math.max(rdp[n], getRightLIS(i) + 1);
            }
        }

        return rdp[n] = rdp[n] == 0 ? 1 : rdp[n];
    }
}
