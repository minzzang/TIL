 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-07-20
  * URL   : https://www.acmicpc.net/problem/2193
  *
  */

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(dp(N));
    }

    private static long dp(int n) {
        // int 범위를 초과해서 long 사용
        long[] d = new long[n+1];

        if (n == 1 || n == 2) return 1;

        d[1] = 1;
        d[2] = 1;

        for (int i=3; i<n+1; i++) {
            d[i] = d[i-1] + d[i-2];
        }

        return d[n];
    }
}
