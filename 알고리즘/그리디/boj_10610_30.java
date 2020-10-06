 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-06
  * URL   : https://www.acmicpc.net/problem/10610
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ch = str.toCharArray();
        Arrays.sort(ch);

        if (ch[0] != '0') {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (int i=0; i<ch.length; i++) {
            sum += ch[i] - '0';
        }

        if (sum % 3 == 0) {
            StringBuffer sb = new StringBuffer(new String(ch));
            System.out.println(sb.reverse());
            return;
        }
        System.out.println(-1);
    }
}