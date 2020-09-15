 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-15
  * URL   : https://www.acmicpc.net/problem/1934
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int a, b, gcd = 0;
        for (int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            gcd = gcd(a, b);
            System.out.println(a * b / gcd);
        }

    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

}
