 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-08
  * URL   : https://www.acmicpc.net/problem/1476
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

        int earth = Integer.parseInt(st.nextToken());
        int sun = Integer.parseInt(st.nextToken());
        int moon = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int sum = 1;
        while (true) {
            if (e % 15 == earth || e % 15 + 15 == earth) {
                if (s % 28 == sun || s % 28 + 28 == sun) {
                    if (m % 19 == moon || m % 19 + 19 == moon) {
                        break;
                    }
                }
            }
            e++;
            s++;
            m++;
            sum++;
        }
        System.out.println(sum);
    }
}