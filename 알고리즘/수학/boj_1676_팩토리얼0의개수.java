 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-15
  * URL   : https://www.acmicpc.net/problem/1676
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i=2; i<=num; i++) {
            if (i % 5 == 0) count++;
            if (i % 25 == 0) count++;
            if (i % 125 == 0) count++;
        }

        System.out.println(count);
    }

}
