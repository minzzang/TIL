 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-25
  * URL   : https://www.acmicpc.net/problem/11729
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuffer sb = new StringBuffer();
    private static int N, count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        recursion(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void recursion(int depth, int from, int by, int to) {
        count++;

        if (depth == 1) {
            sb.append(from + " " + to + "\n");
        } else {
            recursion(depth-1, from, to, by);
            sb.append(from + " " + to + "\n");
            recursion(depth-1, by, from, to);
        }
    }

}
