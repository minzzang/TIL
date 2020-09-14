 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-14
  * URL   : https://www.acmicpc.net/problem/1978
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = 0;
        int sum = 0;
        for (int i=0; i<count; i++) {
            num = Integer.parseInt(st.nextToken());
            sum += checkPrimeNumber(num);
        }
        System.out.println(sum);
    }

    private static int checkPrimeNumber(int num) {

        if (num == 1) return 0;
        if (num == 2) return 1;

        for (int i=2; i*i<=num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return 1;
    }

}
