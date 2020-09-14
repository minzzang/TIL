 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-14
  * URL   : https://www.acmicpc.net/problem/10809
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];

        for (int i=0; i<alpha.length; i++) {
            char ch = (char)(i+97);
            alpha[i] = str.indexOf(ch);
        }

        for (int i : alpha) {
            System.out.print(i + " ");
        }

    }
}
