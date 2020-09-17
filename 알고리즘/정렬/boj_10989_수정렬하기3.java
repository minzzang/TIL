 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-09-17
  * URL   : https://www.acmicpc.net/problem/10989
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int length = Integer.parseInt(br.readLine());
       int[] num = new int[10001];

       for (int i=0; i<length; i++) {
           num[Integer.parseInt(br.readLine())]++;
       }

       StringBuffer sb = new StringBuffer();
       for (int i=1; i<num.length; i++) {
           if (num[i] == 0) continue;

           for (int j=1; j<=num[i]; j++) {
                sb.append(i + "\n");
           }
       }
       System.out.println(sb);
    }
}
