 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-06
  * URL   : https://www.acmicpc.net/problem/2011
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ch = str.toCharArray();
        if (ch[0] == '0') {
            System.out.println(0);
            return;
        }

        dp = new int[ch.length + 1];
        dp[0] = dp[1] = 1;

        for (int i=1; i<ch.length; i++) {
            char prev = ch[i-1];
            if (ch[i] == '0' && (prev > '2' || prev == '0')) {
                System.out.println(0);
                return;
            }
            if (prev == '1' || (prev == '2' && ch[i] < '7')) {
                dp[i+1] = dp[i-1] % 1000000;
            }
            if (ch[i] != '0') {
                dp[i+1] += dp[i] % 1000000;
            }
        }
        System.out.println(dp[ch.length] % 1000000);

    }
}

