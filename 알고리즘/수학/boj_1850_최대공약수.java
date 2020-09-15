 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-15
  * URL   : https://www.acmicpc.net/problem/1850
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
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long gcd = gcd(a, b);

        for (int j=0; j<gcd; j++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    private static long gcd(long a, long b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

}
