 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-15
  * URL   : https://www.acmicpc.net/problem/11653
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int i = 2;
        while (num != 1) {
            if (num % i == 0) {
                num = num / i;
                sb.append(i + "\n");
            } else {
                i++;
            }
        }
        System.out.println(sb);
    }

}
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

}
