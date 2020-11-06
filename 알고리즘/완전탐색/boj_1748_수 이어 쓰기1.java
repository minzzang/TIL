 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-11-06
  * URL   : https://www.acmicpc.net/problem/1748
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int[] basis = {0, 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

        int count = 0;
        while (a != 0) {
            int length = (a + "").length();
            int n = a - basis[length] + 1;
            count += n * length;
            a = basis[length] - 1;
        }
        System.out.println(count);
    }
}