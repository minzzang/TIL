 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-14
  * URL   : https://www.acmicpc.net/problem/1212
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String[] first = {"0", "1", "10", "11"};

        String str = br.readLine();

        for (int i=0; i<str.length(); i++) {
            int index = str.charAt(i)-'0';
            if (i==0 && index < 4) {
                sb.append(first[index]);
                continue;
            }
            sb.append(data[index]);
        }
        System.out.print(sb);

    }
}
