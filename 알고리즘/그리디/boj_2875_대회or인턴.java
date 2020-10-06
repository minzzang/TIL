 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2020-10-06
  * URL   : https://www.acmicpc.net/problem/2875
  *
  */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i=1; i<=M; i++) {
            if (i * 2 <= N && i <= M) {
                int intern = N-(i * 2) + M-i;
                if (intern < K)  break;
                max++;
            }
        }

        System.out.println(max);
    }
}