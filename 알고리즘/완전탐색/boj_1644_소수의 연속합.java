 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-12-11
  * URL   : https://www.acmicpc.net/problem/1644
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] primeNumber = new int[N+3];
        Arrays.fill(primeNumber, Integer.MAX_VALUE);
        int index = 1;
        for (int i = 1; i <= N; i++) {
            if (isPrimeNum(i)) {
                primeNumber[index++] = i;
            }
        }

        int start = 0, end = 0;
        int sum = 0, count = 0;

        while (end < N) {
            if (sum + primeNumber[end] <= N) {
                sum += primeNumber[end++];
            } else {
                sum -= primeNumber[start++];
            }

            if (sum == N) count++;
        }
        System.out.println(count);
    }

    private static boolean isPrimeNum(int n) {
        if (n == 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
