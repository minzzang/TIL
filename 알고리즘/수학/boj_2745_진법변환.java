 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-11
  * URL   : https://www.acmicpc.net/problem/2745
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

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int decimal = 0;
        for (int i=0; i<N.length(); i++) {
            int num = (int)N.charAt(i);
            int index = N.length() - (i+1);

            if (num > 57) {
                num -= 55;
            } else {
                num -= 48;
            }

            decimal += num * Math.pow(B, index);
        }

        System.out.println(decimal);
    }
}