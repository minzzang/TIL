 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-16
  * URL   : https://www.acmicpc.net/problem/10820
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while ((str = br.readLine()) != null) {

            int A = 0, a = 0, num = 0, blank = 0;
            char[] input = str.toCharArray();
            for (int i=0; i<input.length; i++) {
                int n = input[i] + 0;
                if (n > 96) a++;
                else if (n > 64) A++;
                else if (n > 47) num++;
                else blank++;
            }
            System.out.println(a+ " " + A+ " " + num + " " + blank);
        }
    }

}