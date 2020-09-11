 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-11
  * URL   : https://www.acmicpc.net/problem/2089
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        if (num == 0) System.out.println(0);

        while (num != 0) {
            sb.append(Math.abs(num%-2));
            num = (int)Math.ceil(num/-2.0);
        }
        sb.reverse();
        System.out.println(sb);
    }
}