 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-16
  * URL   : https://www.acmicpc.net/problem/1929
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
        StringBuffer sb = new StringBuffer();

        int first = Integer.parseInt(st.nextToken());
        int last = Integer.parseInt(st.nextToken());
        boolean isPrime = true;
        for (int i=first; i<=last; i++) {
            if (i==1) continue;

            isPrime = true;
            for (int j=2; j*j<=i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) sb.append(i+ "\n");
        }
        System.out.println(sb);

    }
}
