 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-12
  * URL   : https://www.acmicpc.net/problem/11005
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        
        if (N == 0) System.out.println(0);
        while (N != 0) {
            if (N%B < 10) {
                sb.append(N%B);
            } else {
                sb.append((char)(N%B + 55));
            }
            N = N/B;
        }

        System.out.println(sb.reverse());
    }
}
