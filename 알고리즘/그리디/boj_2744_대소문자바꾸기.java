 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-06
  * URL   : https://www.acmicpc.net/problem/2744
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char[] ch = str.toCharArray();

        StringBuffer sb = new StringBuffer();
        for (int i=0; i<ch.length; i++) {
            if (ch[i] > 'Z') {
                sb.append((char)(ch[i] - 32));
            } else {
                sb.append((char)(ch[i] + 32));
            }
        }
        System.out.println(sb);
    }
}
